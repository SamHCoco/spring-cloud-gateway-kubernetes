package com.samhcoco.projects.springcloudgatewaykubernetes.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("movie-service", r -> r.path("/movie-service/**")
                        .filters(f -> f.rewritePath("/movie-service/(?<segment>.*)", "/$\\{segment}"))
                        .uri("http://movie-service:9000"))
                .build();
    }

}

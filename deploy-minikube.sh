#!/bin/bash

mvn clean install

eval $(minikube docker-env)

bash build-image.sh

kubectl apply -f ./k8/gateway-deploy.yaml -n spring-k8
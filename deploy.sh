#!/bin/sh

PROJECT_NAME="example"
IMAGE_NAME="example-be"

JAR_FILE="target/*.jar"

IMAGE_VERSION="0.1"

cd docker/rest

docker build -t $PROJECT_NAME/$IMAGE_NAME:$IMAGE_VERSION .

docker login -u $REGISTRY_USERNAME -p $REGISTRY_PASSWORD
docker push $PROJECT_NAME/$IMAGE_NAME:$IMAGE_VERSION

docker rmi $PROJECT_NAME/$IMAGE_NAME:$IMAGE_VERSION

echo "Docker image $PROJECT_NAME/$IMAGE_NAME:$IMAGE_VERSION has been built and pushed to the GitLab Container Registry."

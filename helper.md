Please ignore this repo for now!

// https://hub.docker.com/_/postgres

build micronaut ->  ./gradlew build

build docker image -> docker build .

run docker image -> docker run -p 8080:8080 imageName

run docker compose -> docker-compose -f docker-compose.dev.yml up

run skaffold -> skaffold dev

direct access to NATS -> kubectl port-forward nats-depl-75ff586df-77v66 4222:4222


//https://guides.micronaut.io/latest/micronaut-data-jdbc-repository-maven-kotlin.html

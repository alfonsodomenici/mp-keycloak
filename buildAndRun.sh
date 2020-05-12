#!/bin/sh
mvn clean package && docker build -t it.alfonsodomenici/mp-keycloak .
docker rm -f mp-keycloak || true && docker run -d -p 8080:8080 -p 4848:4848 --name mp-keycloak it.alfonsodomenici/mp-keycloak 

#!/bin/sh
mvn clean package && docker build -t es.oruiz/musica .
docker rm -f musica || true && docker run -d -p 8080:8080 -p 4848:4848 --name musica es.oruiz/musica 

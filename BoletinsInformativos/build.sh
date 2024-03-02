#!/bin/bash

# Limpar e compilar o projeto com Maven
mvn clean package

# Construir a imagem Docker
docker build -t geppa/boletins .

# Executar o contêiner Docker com Docker Compose
docker-compose up -d

FROM openjdk:17-jdk-slim

WORKDIR /geppa

COPY target/*.jar /geppa/app.jar

EXPOSE 80

CMD java -XX:+UseContainerSupport -Xmx500m -jar app.jar --server.port=$PORT


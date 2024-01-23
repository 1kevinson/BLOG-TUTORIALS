# Generate jar file first -> ./mvnw clean package
FROM openjdk:17-alpine

MAINTAINER 1kevinson.com

RUN addgroup -S spring && adduser -S spring -G spring

USER spring:spring

ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} app.jar

ENTRYPOINT ["java","-jar","/app.jar"]
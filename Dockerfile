#
FROM maven:3.6.0-jdk-11-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package





FROM openjdk:latest
COPY target/adonis-0.0.1-SNAPSHOT.jar /usr/src/snap.jar
CMD java -jar /user/src/snap.jar
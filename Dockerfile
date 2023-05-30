FROM openjdk:latest
COPY target/adonis-0.0.1-SNAPSHOT.jar /usr/src/snap.jar
CMD java -jar /user/src/snap.jar
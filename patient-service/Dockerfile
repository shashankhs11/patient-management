#maven image to install dependencies and build a jar
FROM maven:3.9.9-eclipse-temurin-21 AS builder

WORKDIR /app

COPY pom.xml .

RUN mvn dependency:go-offline -B #this caches the dependencies once installed

COPY src ./src

RUN mvn clean package #creates a jar

#now we don't need maven anymore, so we use java runtime
#This step actually runs the code
FROM openjdk:21-jdk AS runner

WORKDIR /app

#copying the jar file from builder step to app and places it as app.jar
COPY --from=builder ./app/target/patient-service-0.0.1-SNAPSHOT.jar ./app.jar

EXPOSE 4000

#This actually runs our code. Using the java cli that comes with our jdk
#ENTRYPOINT makes sure the container always runs the given command.
#This is essentially "java -jar app.jar"
ENTRYPOINT ["java", "-jar", "app.jar"]


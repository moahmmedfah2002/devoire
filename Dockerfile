FROM openjdk:17-jdk-alpine
ARG JAR_FILE=target/thread-1.0-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
ARG T=/
COPY ${T} thread
ENTRYPOINT ["java", "-jar", "/app.jar"]

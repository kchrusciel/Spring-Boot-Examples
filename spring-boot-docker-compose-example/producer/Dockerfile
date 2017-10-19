FROM openjdk:8-jre-alpine
ADD target/producer-docker.jar producer-docker.jar
EXPOSE 8081
EXPOSE 8001
ENTRYPOINT ["java", "-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=8001", "-jar", "producer-docker.jar"]
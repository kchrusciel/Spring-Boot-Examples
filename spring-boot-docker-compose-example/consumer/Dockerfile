FROM openjdk:8-jre-alpine
ADD target/consumer-docker.jar consumer-docker.jar
EXPOSE 8082
EXPOSE 8002
ENTRYPOINT ["java", "-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=8002", "-jar", "consumer-docker.jar"]
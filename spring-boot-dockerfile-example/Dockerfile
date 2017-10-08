FROM openjdk:8-jre-alpine
ADD target/code-couple-docker.jar code-couple-docker.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "code-couple-docker.jar"]
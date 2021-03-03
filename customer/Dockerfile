FROM openjdk:8-jdk-alpine
ADD target/customer-0.0.1.jar app.jar
EXPOSE 9494
ENTRYPOINT ["java", "-jar", "/app.jar"]
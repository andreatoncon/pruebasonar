FROM eclipse-temurin:17.0.6_10-jre-alpine
ADD target/*.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]
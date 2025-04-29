# Build process done beforehand via these commands
# ❯ ./mvnw clean
# ❯ ./mvnw clean package

FROM eclipse-temurin:21-alpine

COPY target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]

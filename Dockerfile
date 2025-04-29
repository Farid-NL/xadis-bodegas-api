FROM eclipse-temurin:21-jdk-alpine AS build

COPY . .

RUN ./mvnw clean package -DskipTests

FROM eclipse-temurin:21-alpine

COPY --from=build /target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]

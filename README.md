<h1 align="center">
    xadis-bodega-api
</h1>

<h4 align="center">
    API sencilla de bodegas
</h4>

<p align="center">
    <img alt="java-badge" src="https://img.shields.io/badge/java-21-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white">
    <img alt="springboot-badge" src="https://img.shields.io/badge/spring-3.4.5-6CB52D?style=for-the-badge&logo=spring&logoColor=white">
    <img alt="docker-badge" src="https://img.shields.io/badge/docker-1D63ED?style=for-the-badge&logo=docker&logoColor=white">
</p>

## Run it locally

You'll need:

- Java JDK 21
- Docker Engine/Desktop (for the database)

1. Makes sure you have Java 21 in your path

   ```txt
   ❯ java -version
   openjdk version "21.0.7" 2025-04-15 LTS
   OpenJDK Runtime Environment Temurin-21.0.7+6 (build 21.0.7+6-LTS)
   OpenJDK 64-Bit Server VM Temurin-21.0.7+6 (build 21.0.7+6-LTS, mixed mode, sharing)
   ```

2. Create a `.env` file based off of `.env.example`

3. Create the database

   ```txt
   ❯ docker compose up -d
   [+] Running 2/2
   ✔ Network xadis-gh_default    Created
   ✔ Container xadis-gh-mysql-1  Started
   ```

4. Build the project

   ```txt
   ./mvnw clean package -DskipTests
   ```

5. Run the app

   ```txt
   ./mvnw spring-boot:run
   ```

6. Go to http://localhost:8080/swagger-ui/index.html to see the Swagger documentation

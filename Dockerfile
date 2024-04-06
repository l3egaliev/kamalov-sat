# Stage 1: Сборка приложения
FROM maven:3.8.4-openjdk-17 AS build

LABEL authors="rocki"

WORKDIR /app
COPY pom.xml .
COPY src ./src

# Сборка приложения
RUN mvn clean package

# Stage 2: Запуск приложения
FROM openjdk:17-jdk-alpine

WORKDIR /app
EXPOSE 5000

# Устанавливаем переменную окружения для активации профилей Spring Boot
ENV SPRING_PROFILES_ACTIVE=production

COPY --from=build /app/target/kamalov_sat-1.0.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]

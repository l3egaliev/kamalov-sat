#FROM openjdk:17-jdk-alpine AS build
#
#LABEL authors="rocki"
#
#WORKDIR /app
#COPY . .
#
## Обновляем список пакетов и устанавливаем пакет apt-transport-https, который позволяет использовать HTTPS-транспорт для репозиториев apt
#RUN apk update && \
#    apk add --no-cache \
#    maven \
#    postgresql-client
#
#RUN mvn clean package
#
#FROM openjdk:17-jdk-alpine
#WORKDIR /app
#EXPOSE 8080
#
#COPY --from=build /app/target/kamalov_sat-1.0.jar app.jar
#
#ENTRYPOINT ["java", "-jar", "app.jar"]

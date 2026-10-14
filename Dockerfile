# --- Etapa de construcción ---
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app

# Copiamos el pom y las fuentes directamente
COPY pom.xml .
COPY src src

# Empaquetamos usando maven instalado en la imagen
RUN mvn clean package -DskipTests

# --- Etapa de ejecución final ---
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

# Copiamos el JAR generado desde la carpeta target de maven
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
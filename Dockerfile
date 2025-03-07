FROM eclipse-temurin:17-jdk-alpine

LABEL authors="esther.bakabou"

WORKDIR /app

COPY target/produit.jar /app/produit.jar


EXPOSE 8082

CMD ["java", "-jar", "produit.jar"]


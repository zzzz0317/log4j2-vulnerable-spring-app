FROM maven:3.8.4-openjdk-8 as build-deps
COPY . /build/
WORKDIR /build/
RUN mvn package

FROM openjdk:8u111-jdk
EXPOSE 8080
WORKDIR /app
COPY --from=build-deps /build/target/*.jar /app/app.jar
CMD ["java", "-jar", "/app/app.jar"]

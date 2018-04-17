FROM bigtruedata/sbt AS build
WORKDIR /app
COPY . .
RUN sbt assembly

FROM openjdk:8-alpine
WORKDIR /app
COPY --from=build /app/target/scala-2.12/app.jar .
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
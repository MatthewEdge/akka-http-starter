FROM bigtruedata/sbt AS build
WORKDIR /root/app
COPY . .
RUN sbt assembly

FROM openjdk:8-alpine
COPY --from=build /root/app/target/scala-2.12/app.jar .
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]

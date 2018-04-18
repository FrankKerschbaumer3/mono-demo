FROM bigtruedata/sbt:latest AS build
WORKDIR /app
COPY . .
CMD ["sbt", "assembly"]

FROM openjdk:8-alpine
WORKDIR /app
COPY --from=build /app/target/scala-2.12/app.jar .
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
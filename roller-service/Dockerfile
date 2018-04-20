FROM bigtruedata/sbt AS build
WORKDIR /monorepo/roller
COPY . .
RUN sbt assembly

FROM openjdk:8-alpine
COPY --from=build /monorepo/roller/target/scala-2.12/app.jar /app/app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/app.jar"]

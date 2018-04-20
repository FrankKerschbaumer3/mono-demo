FROM bigtruedata/sbt AS build
WORKDIR /monorepo/time
COPY . .
RUN sbt assembly

FROM openjdk:8-alpine
COPY --from=build /monorepo/time/target/scala-2.12/app.jar /app/app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/app.jar"]

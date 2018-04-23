FROM bigtruedata/sbt AS build
WORKDIR /monorepo
COPY . .
RUN sbt assembly

FROM openjdk:8-alpine
COPY --from=build /monorepo/target/scala-2.12/app.jar /monorepo/app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/monorepo/app.jar"]

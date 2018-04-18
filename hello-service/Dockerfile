FROM bigtruedata/sbt AS hello-build
WORKDIR /app
COPY . .
RUN sbt assembly

FROM openjdk:8-alpine
WORKDIR /app
COPY --from=hello-build /app/target/scala-2.12/app.jar .
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
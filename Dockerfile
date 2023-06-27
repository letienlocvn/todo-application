FROM ubuntu:latest
LABEL authors="letienloc"

ENTRYPOINT ["top", "-b"]

FROM openjdk:20-jdk-slim
WORKDIR /app
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:resolve

COPY src ./src
#, "-Dspring-boot.run.profiles=mysql"
CMD ["./mvnw", "spring-boot:run"]

FROM maven:3.8.2-jdk-11-alpine AS MAVEN_ENV
WORKDIR /build/
COPY pom.xml /build
COPY src /build/src
RUN mvn clean package -DskipTests=true

FROM openjdk:11-jre-slim
COPY  --from=MAVEN_ENV /build/target/rescue-me-dogs*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
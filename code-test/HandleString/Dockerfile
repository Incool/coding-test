# 使用带 JDK 21 和 Maven 3.9.9 的镜像
FROM maven:3.9.9-eclipse-temurin-21
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests && cp target/HandleString-*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
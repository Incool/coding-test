FROM maven:3.9.9-eclipse-temurin-21 AS builder
WORKDIR /app
COPY pom.xml .
# 先下载依赖
RUN mvn dependency:go-offline -B
COPY src ./src
RUN mvn clean package -DskipTests && cp target/HandleString-*.jar app.jar

# 运行阶段
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app
COPY --from=builder /app/app.jar .
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
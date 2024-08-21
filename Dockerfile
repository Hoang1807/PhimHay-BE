FROM maven:3.8.5-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests

#
# Package stage
#
FROM openjdk:17.0.1-jdk-slim
COPY --from=build /target/PhimHay-1.0.0.war demo.war
# ENV PORT=8080
EXPOSE 8080
ENTRYPOINT ["java","-jar","demo.war"]

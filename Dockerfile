FROM eclipse-temurin:21-jre-alpine
WORKDIR /app
# Copy the exact JAR file Maven generated into the container
COPY target/my-maven-app-1.0-SNAPSHOT.jar app.jar
# Expose the port we set in application.properties
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "app.jar"]
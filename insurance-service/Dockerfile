 # Start from an official Java image
FROM openjdk:17-jdk-slim

# Set working directory inside container
WORKDIR /app

# Copy the built jar from host to container
COPY target/*.jar app.jar

# Expose port (optional, depends on your app)
EXPOSE 8080

# Run the JAR file
ENTRYPOINT ["java", "-jar", "app.jar"]

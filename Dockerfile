# Use Ubuntu as the base image
FROM ubuntu:latest

# Install dependencies
RUN apt update && apt install -y openjdk-17-jdk

# Set working directory
WORKDIR /app

# Copy JAR file from target directory
COPY target/basicpostcrud-2-0.0.1-SNAPSHOT.jar /app/basicpostcrud-2-0.0.1-SNAPSHOT.jar

# Expose the backend port
EXPOSE 8083

# Command to run the Spring Boot application
CMD ["java", "-jar", "/app/basicpostcrud-2-0.0.1-SNAPSHOT.jar"]

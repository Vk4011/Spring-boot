# Use a base image with OpenJDK 21
FROM openjdk:21-slim

# Add a group and user for running the Spring Boot application
RUN addgroup --system spring && adduser --system --ingroup spring spring

# Switch to the new user
USER spring:spring

# Define the JAR_FILE build argument
ARG JAR_FILE=target/*.jar

# Copy the JAR file to the container
COPY ${JAR_FILE} app.jar

# Expose the application port
EXPOSE 8080

# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "/app.jar"]

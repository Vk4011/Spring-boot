# Use the official Ubuntu base image
FROM ubuntu:latest AS build

# Update and install required packages
RUN apt-get update && \
    apt-get install -y openjdk-21-jdk maven

# Set the working directory
WORKDIR /app

# Copy the project files to the working directory
COPY . .

# Build the application using Maven
# Use ./mvnw if it exists, otherwise use mvn
RUN if [ -f ./mvnw ]; then ./mvnw clean package -DskipTests; else mvn clean package -DskipTests; fi

# Use a smaller base image for the final container
FROM eclipse-temurin:21-jre-jammy

# Set the working directory
WORKDIR /app

# Copy the built JAR file from the build stage
COPY --from=build /app/target/*.jar app.jar

# Expose the port the app runs on
EXPOSE 8080

# Define the entry point for the container
ENTRYPOINT ["java", "-jar", "app.jar"]

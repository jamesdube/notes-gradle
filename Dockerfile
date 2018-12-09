FROM openjdk:10-jre-slim
COPY . .
CMD ["./gradelw build"]
COPY ./build/libs/notes-gradle-0.0.1.jar .
EXPOSE 8080
CMD ["java", "-jar", "notes-gradle-0.0.1.jar"]
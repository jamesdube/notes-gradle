FROM openjdk:10-jre-slim
RUN mkdir -p /notes-gradle
COPY . /notes-gradle
WORKDIR /notes-gradle
RUN ./gradlew build
RUN cp /notes-gradle/build/libs/notes-gradle-0.0.1.jar .
EXPOSE 8080
CMD ["java", "-jar", "notes-gradle-0.0.1.jar"]
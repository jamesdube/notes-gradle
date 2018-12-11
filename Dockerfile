FROM openjdk:10-jre-slim
RUN mkdir -p /notes-gradle
COPY . /notes-gradle
WORKDIR /notes-gradle
RUN cp /notes-gradle/build/libs/* .
EXPOSE 8080
CMD ["java", "-jar", "notes-gradle-0.0.3.jar"]
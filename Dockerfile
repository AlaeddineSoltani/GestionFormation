FROM openjdk:8-jdk-alpine
EXPOSE 8085
ARG JAR_FILE=./target/*.jar
ADD ${JAR_FILE} GesF-1.0.jar
EXPOSE 8085
ENTRYPOINT ["java","-jar","/app.jar"]
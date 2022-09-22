FROM openjdk:18-alpine
RUN addgroup -S springdocker && adduser -S springdocker -G springdocker
USER springdocker:springdocker
ARG JAR_FILE
COPY ${JAR_FILE} web-app.jar
ENTRYPOINT ["java","-jar","web-app.jar"]
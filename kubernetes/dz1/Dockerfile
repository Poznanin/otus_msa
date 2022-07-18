FROM openjdk:18-alpine
RUN addgroup -S springdocker && adduser -S springdocker -G springdocker
USER springdocker:springdocker
COPY ${JAR_FILE} web-app-plain.jar
ENTRYPOINT ["java","-jar","/web-app-plain.jar"]
FROM openjdk:18-alpine
RUN addgroup -S springdocker && adduser -S springdocker -G springdocker
USER springdocker:springdocker
#COPY web-app/build/libs/web-app.jar web-app.jar
ARG JAR_FILE
COPY ${JAR_FILE} web-app.jar
ENTRYPOINT ["java","-jar","web-app.jar"]
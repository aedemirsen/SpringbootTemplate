FROM openjdk:11-jre-slim

WORKDIR /app

#jar file should be located in target folder in this path
ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} /app/rest-api.jar

ENV SPRING_PROFILES_ACTIVE=prod

CMD ["java", "-jar", "-Dspring.profiles.active=${SPRING_PROFILES_ACTIVE}", "rest-api.jar"]

FROM openjdk:11-jre-slim

WORKDIR /app

COPY *.jar /app/rest-api.jar

ENV SPRING_PROFILES_ACTIVE=prod

CMD ["java", "-jar", "-Dspring.profiles.active=${SPRING_PROFILES_ACTIVE}", "rest-api.jar"]

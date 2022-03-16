FROM adoptopenjdk/openjdk11:alpine-jre
VOLUME /tmp
EXPOSE 8080
ADD target/*.jar app.jar
ENTRYPOINT exec java -jar app.jar

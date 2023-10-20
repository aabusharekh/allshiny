FROM openjdk:22-slim-bullseye


RUN mkdir -p /opt/shinyproxy/
COPY shinyproxy.jar /opt/shinyproxy/shinyproxy.jar
COPY application.yml /opt/shinyproxy/application.yml

WORKDIR /opt/shinyproxy/
CMD ["java", "-jar", "/opt/shinyproxy/shinyproxy.jar"]

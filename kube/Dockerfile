FROM pncamain.azurecr.io/eclipse-temurin:21_35-jre-alpine
EXPOSE 8080

RUN apk --update --no-cache upgrade \
    && rm -rf /tmp/*.apk /var/cache/apk/* 

WORKDIR /app

COPY allcontainerproxy-SR_2.0.0-exec.jar shinyproxy.jar 
COPY templates templates

CMD ["java", "-jar", "/app/shinyproxy.jar"]
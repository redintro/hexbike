FROM alpine:latest
ENV REFRESHED_AT 05/07/18:48:00

RUN apk --no-cache add openjdk11-jre && \
    apk --no-cache add bash

WORKDIR /opt

EXPOSE 8080

CMD ["java", "-jar", "hexbike-0.0.1-SNAPSHOT.jar"]
FROM openjdk:17-jdk-alpine3.14
#FROM adoptopenjdk/openjdk11:alpine-jre-nightly

ARG DIR="/usr/src/my_workdir/"
ARG SBT_VERSION="1.6.1"

COPY sbt /usr/bin/sbt

WORKDIR ${DIR}

COPY . ${DIR}

RUN apk update               && \
    apk add --no-cache bash  && \
    sbt update

RUN sbt compile
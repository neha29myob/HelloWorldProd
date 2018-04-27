FROM gradle:4.6.0-jdk8-alpine

COPY . /hello-world
WORKDIR /hello-world
USER root
RUN chown -R gradle /hello-world
USER gradle

RUN ./gradlew tasks
EXPOSE 8000

CMD ["sh", "-c", "./gradlew runJar"]
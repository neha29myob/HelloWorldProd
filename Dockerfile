FROM openjdk:8

COPY . /hello-world-production
WORKDIR /hello-world-production

RUN ./gradlew tasks

EXPOSE 8000

CMD ["sh", "-c", "./gradlew runJar"]

FROM openjdk:8

COPY . /hello-world-production
WORKDIR /hello-world-production

RUN ./gradlew build

EXPOSE 8000

CMD ["sh", "-c", "./gradlew runJar"]

# FROM openjdk:8
# COPY . /hello-world
# WORKDIR /hello-world
# RUN ./gradlew jar
# EXPOSE 8000
# CMD ["java", "-jar", "build/libs/HelloWorldProduction-1.0-SNAPSHOT.jar"]
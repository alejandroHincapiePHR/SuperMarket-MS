FROM openjdk:17.0.2
WORKDIR /app
COPY ./build/libs/registry.server-0.0.1-SNAPSHOT.jar /app
EXPOSE 8082
ENTRYPOINT ["java","-jar","./registry.server-0.0.1-SNAPSHOT.jar"]
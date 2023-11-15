FROM openjdk:17.0.2
WORKDIR /app
COPY ./build/libs/administration.api.gateway-0.0.1-SNAPSHOT.jar /app
EXPOSE 8887
ENTRYPOINT ["java","-jar","./administration.api.gateway-0.0.1-SNAPSHOT.jar"]
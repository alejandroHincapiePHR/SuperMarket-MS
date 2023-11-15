FROM openjdk:17.0.2
WORKDIR /app
COPY ./build/libs/admin.config-0.0.1-SNAPSHOT.jar /app
EXPOSE 8888
ENTRYPOINT ["java","-jar","./admin.config-0.0.1-SNAPSHOT.jar"]
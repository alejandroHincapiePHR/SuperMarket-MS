FROM openjdk:17.0.2
WORKDIR /app
COPY ./build/libs/administration.server-0.0.1-SNAPSHOT.jar /app
EXPOSE 8890
ENTRYPOINT ["java","-jar","./administration.server-0.0.1-SNAPSHOT.jar"]
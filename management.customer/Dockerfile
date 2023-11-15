FROM openjdk:17.0.2
WORKDIR /app
COPY ./build/libs/management.CustomerService-0.0.1-SNAPSHOT.jar /app
EXPOSE 8082
ENTRYPOINT ["java","-jar","./management.CustomerService-0.0.1-SNAPSHOT.jar"]

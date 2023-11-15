FROM openjdk:17.0.2
WORKDIR /app
COPY ./build/libs/management.bill-0.0.1-SNAPSHOT.jar /app
EXPOSE 8083
ENTRYPOINT ["java","-jar","./management.bill-0.0.1-SNAPSHOT.jar"]
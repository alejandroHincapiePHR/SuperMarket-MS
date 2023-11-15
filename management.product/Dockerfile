FROM openjdk:17.0.2
WORKDIR /app
COPY ./build/libs/management.product-0.0.1-SNAPSHOT.jar /app
EXPOSE 8081
ENTRYPOINT ["java","-jar","./management.product-0.0.1-SNAPSHOT.jar.jar"]
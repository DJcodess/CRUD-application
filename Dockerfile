FROM openjdk:17-alpine
EXPOSE 8080 
WORKDIR /app
ADD target/demojar.jar demojar.jar

ENTRYPOINT ["java","-jar","demojar.jar"]

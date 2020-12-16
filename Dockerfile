# Building the App with Maven
FROM maven:3-jdk-11

ADD . /spring-graphgl
WORKDIR /spring-graphgl

# Run Maven build
RUN mvn clean install

FROM openjdk:11-jdk
COPY --from=0 "/spring-graphgl/target/spring-graphql-*.jar" app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]
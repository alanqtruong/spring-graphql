# Building the App with Maven
FROM maven:3-jdk-11

ADD . /spring-graphgl
WORKDIR /spring-graphgl

# Run Maven build
RUN mvn clean install

FROM openjdk:11-jdk-slim
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
ARG DEPENDENCY=/spring-graphgl/target/dependency
COPY --from=0 ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY --from=0 ${DEPENDENCY}/META-INF /app/META-INF
COPY --from=0 ${DEPENDENCY}/BOOT-INF/classes /app
EXPOSE 8080
ENTRYPOINT ["java","-cp","app:app/lib/*","com.example.spring.graph.ql.Application"]
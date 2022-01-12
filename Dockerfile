FROM openjdk:17
COPY ./target/grocerylist-generator-0.0.1-SNAPSHOT.jar /usr/src/jms-project/
WORKDIR /usr/src/jms-project
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "grocerylist-generator-0.0.1-SNAPSHOT.jar"]
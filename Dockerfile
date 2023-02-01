FROM openjdk:8-jre-slim
VOLUME /tmp
EXPOSE 8165
ARG JAR_FILE=target/algorithm-enc-dec-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} algorithm-enc-dec.jar
ENTRYPOINT ["java","-jar","algorithm-enc-dec.jar"]
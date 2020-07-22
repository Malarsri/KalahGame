FROM openjdk:8-jre-alpine
COPY target/kalah-0.0.1-SNAPSHOT.jar .
CMD /usr/bin/java -Dlogging.path=/log/ -Xmx400m -Xms400m -jar kalah-0.0.1-SNAPSHOT.jar
EXPOSE 8080
FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD target/gs-uploading-files-0.1.0.jar hello-app.jar
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /gs-uploading-files-0.1.0.jar" ]
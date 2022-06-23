FROM java:8
ADD ./target/mall-0.0.1-SNAPSHOT.jar
ENTRYPOINT java ${JAVA_OPTS} -jar app.jar
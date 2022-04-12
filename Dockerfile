FROM maven:3-jdk-11
COPY . ./
RUN mvn install package -Dmaven.test.skip
RUN ls

EXPOSE 9001
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar target/assignment-0.0.1-SNAPSHOT.jar" ]


FROM openjdk:8-jre-slim
VOLUME /mnt/data/apps/
ADD merchant-latest.jar /mnt/data/apps/app.jar
ENTRYPOINT ["/bin/sh","-c","java $JAVA_OPTS -jar /mnt/data/apps/app.jar"]

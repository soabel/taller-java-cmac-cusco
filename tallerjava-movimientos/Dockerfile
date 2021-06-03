FROM openjdk:11-jre
LABEL maintainer="CMAC-CUSCO"
COPY target/movimientos-*SNAPSHOT.jar /opt/app.jar
ENTRYPOINT ["java", "-Djava.file.encoding=UTF-8","-jar","/opt/app.jar"]
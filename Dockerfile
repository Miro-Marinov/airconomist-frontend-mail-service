FROM java:8
MAINTAINER Miroslav Marinov <mirobomarinov@gmail.com>
VOLUME /tmp
ADD target/airconomist-frontend-email-service.jar app.jar
EXPOSE 8080
EXPOSE 46655
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
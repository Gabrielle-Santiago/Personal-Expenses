FROM dvmarques/openjdk-17-jdk-alpine-with-timezone
RUN mkdir /com
WORKDIR /com
COPY target/*.jar /com/com.jar
CMD ["java", "-jar", "/com/com.jar"]

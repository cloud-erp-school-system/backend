FROM openjdk:10-jre-slim

WORKDIR /app
COPY ./target/cloud-erp-school-0.0.1-SNAPSHOT.jar /app

EXPOSE 8080

CMD ["java", "-jar", "cloud-erp-school-0.0.1-SNAPSHOT.jar", "-Dspring-boot.run.profiles=dev"]

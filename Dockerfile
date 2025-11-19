FROM eclipse-temurin:11-jdk 
WORKDIR /app 
COPY target/myapp-1.0-SNAPSHOT.jar /app/app.jar 
ENTRYPOINT ["java", "-jar", "app.jar"] 

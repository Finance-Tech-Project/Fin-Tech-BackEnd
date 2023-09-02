FROM eclipse-temurin:11-jre-alpine
#LABEL mentainer="finapp"
WORKDIR /finapp
COPY target/stock-pock-1.0-SNAPSHOT.jar /finapp/finapp.jar
ENTRYPOINT ["java", "-jar", "finapp.jar"]
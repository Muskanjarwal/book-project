# Sample-dropwizard-app

Language: Java 17

Framework used: Maven, Hibernate, Google Guice, Dropwizard

Database: MySQL

## Local Set-up Guide:

1. Run ```mvn clean install``` to build the application.
2. Start the application by running the jar file -
```
java -jar target/sample-dropwizard-app-1.0-SNAPSHOT.jar server config.yml
```
3. To check that your application is running enter url http://localhost:8080

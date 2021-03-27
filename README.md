[![Build Status](https://travis-ci.org/cloud-erp-school-system/backend.svg?branch=main)](https://travis-ci.org/cloud-erp-school-system/backend)

[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=cloud-erp-school-system_backendtravis&metric=alert_status)](https://sonarcloud.io/dashboard?id=cloud-erp-school-system_backendtravis)

![Java CI with Maven](https://github.com/cloud-erp-school-system/backend/workflows/Java%20CI%20with%20Maven/badge.svg)

# Cloud ERP School Backend

## Swagger (API Documentation)

REST API documentation can be accessed by `http://localhost:8080/swagger-ui/`

## Documenting APIs

More information on how to document new APIs, can be found [here](https://www.baeldung.com/swagger-2-documentation-for-spring-rest-api)

## Google Java Format

For this project we are using Google Java Format. This is important to have everyone in the same code format.
Please, check this [link](https://github.com/google/google-java-format) for more details on how to install in your IDEA.

## Database
We use MariaDb as it is a more updated/maintained version of MySQL.

To start it, use docker with the follow command:

```
docker run -p 3306:3306 -d --name mariadb -eMARIADB_ROOT_PASSWORD=Password123! -eMYSQL_DATABASE=mydb -eMYSQL_USER=mydb -eMYSQL_PASSWORD=mydb mariadb/server:10.4
```

These are development only variables.

## Deploying using Docker

To build the Dockerized version of the project, run

```
docker build . -t cloud-erp:latest
```

Once the Docker image is correctly built, you can test it locally using

```
docker run -p 8080:8080 cloud-erp:latest
```

## Administrator Area
For the Administrator area we are using Vaadin as frontend:

### Running the Application
There are two ways to run the application:
- To run from the command line, use `mvn` and open [http://localhost:8080](http://localhost:8080) in your browser.
- Another way is to run the `Application` class directly from your IDE.

#### Intellij IDEA
- On the right side of the window, select Maven --> Plugins--> `spring-boot` --> `spring-boot:run` goal
- Optionally, you can disable tests by clicking on a `Skip Tests mode` blue button.

Clicking on the green run button will start the application.

After the application has started, you can view your it at http://localhost:8080/ in your browser.

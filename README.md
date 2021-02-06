[![Build Status](https://travis-ci.org/github/cloud-erp-school-system/backend.svg?branch=master)](https://travis-ci.org/github/cloud-erp-school-system/backend)]

[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=cloud-erp-school-system_backend&metric=alert_status)](https://sonarcloud.io/dashboard?id=cloud-erp-school-system_backend)

# Cloud ERP School Backend

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

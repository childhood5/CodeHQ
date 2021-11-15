# CodeHQ

This application is used specifically for codeHQ project.

## Requirements

1. Java - 1.8.x

2. Maven - 3.x.x

3. H2 (for local development)

## Steps to setup

**1. Clone the application**

```bash
git clone https://github.com/childhood5/CodeHQ.git
```


**2. Build and run the app using maven**

- Build project : make sure we clean artifact in target folder
```bash
 mvn clean install
```
- Run project
```bash
mvn spring-boot:run
```


## Local Development
The local environment uses the in memory H2 database.  You can view the H2 DB at `http://localhost:8080/h2-console`

When running locally, you can access the apis at 

-Store a device: POST method: `http://localhost:8080/api/devices/registration`

-Get a device: GET method: `http://localhost:8080/api/devices/{deviceId}`



# Hexcar

## Git
- https://github.com/redintro/hexbike
- git@github.com:redintro/hexbike.git

## Building with Maven
The project is configured to use maven as its build tool:
- To build: `mvn clean install`

The project has a docker-compose maven profile defined that clears down and stands up a docker-compose environment: 
- To build and run: `mvn clean install -P docker-compose`

Maven can also be used to call docker-compose directly: 
- Start: `mvn docker-compose:up`
- Stop: `mvn docker-compose:down`

See: https://github.com/dkanejs/docker-compose-maven-plugin

## Docker Compose
To run from the command line without maven:
- Start: `docker-compose up -d --build`
- Stop: `docker-compose down`

### Logs
Tail a running containers logs: 
- Start: `docker-compose logs -f service`
- Stop:`CTRL-C`

### Containers
To view containers:
- Running: `docker-compose ps`
- All: `docker-compose ps -a`

### Shell 
To start a bash shell in a running container:
- Start: `docker-compose exec [service-name] /bin/bash`
- Exit: `CTRL-D`

## Curl

### Bearer token
Get a bearer token:
- `curl -i --data '{"username":"admin","password":"admin"}' -H 'Content-Type: application/json' -X POST http://localhost:8080/login`

### API
Call the API:
- `curl -H 'Authorization: Bearer [jwt-token here...]' -X GET http://localhost:8080/api/bikes`
- `curl -H 'Authorization: Bearer [jwt-token here...]' -X GET http://localhost:8080/api/owners`

## API Documentation
View the API documentation:
`http://localhost:8080/swagger-ui.html`

To access protected endpoints obtain a bearer token, click on the padlock icon and authenticate with the bearer token

## Jacoco Test Coverage
Code coverage reports are automatically generated as part of the build:
- Run: `mvn clean install`
- Coverage reports are available at target/site/jacoco/index.html



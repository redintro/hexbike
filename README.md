# Hexcar
## Git
- https://github.com/redintro/hexbike
- git@github.com:redintro/hexbike.git
## Build
mvn clean install
## Docker Compose
### Start / Stop
- docker-compose up -d --build
- docker-compose down
### Logs
docker-compose logs -f service
## Curl
### Bearer token
- curl -i --data '{"username":"admin","password":"admin"}' -H 'Content-Type: application/json' -X POST http://localhost:8080/login
### API
- curl -H 'Authorization: Bearer [jwt-token here...]' -X GET http://localhost:8080/api/bikes
- curl -H 'Authorization: Bearer [jwt-token here...]' -X GET http://localhost:8080/api/owners
## API Documentation
http://localhost:8080/swagger-ui.html
## Jacoco Test Coverage
- Run mvn build
- Coverage reports are available at target/site/jacoco/index.html



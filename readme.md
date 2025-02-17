## Características de metricas
Ejemplo de como consumir metricas desde _postman_ con la dependencia **micrometer-registry-prometheus**
* _{dominio}/actuator/metrics/{name-metric}_
http://localhost:8090/actuator/metrics/http.server.requests

## Ejecutar redis desde la terminal con docker
* `docker run --name my-redis -d -p 6379:6379 redis`

## ver containers running dockers
* `docker ps`
## Construir imagen
* `docker build -t "spring-img-game-service" .`

## Accessing Redis CLI
* `docker exec -it my-redis redis-cli`

## Stopping and Removing the Container
* `docker stop my-redis`
* `docker rm my-redis`

## Basic Redis Commands
* `SET mykey "Hello"`
* `GET mykey`
* `DEL mykey`

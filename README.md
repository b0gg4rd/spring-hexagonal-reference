# Spring Hexagonal Reference

## Requirements

- Docker 27

## Building

- Create data base container

```shell
docker run -d \
  --net=host \
  --name=spring-hexagonal-reference-db \
  -e POSTGRES_PASSWORD=root \
  postgres:17.2
```

- Apply migrations with Liquibase

```shell
docker run \
  -u $(id -u):$(grep -w docker /etc/group | awk -F\: '{print $3}') \
  --net=host \
  --rm \
  -w $(pwd) \
  -v /etc/group:/etc/group:ro \
  -v /etc/passwd:/etc/passwd:ro \
  -v $(pwd):$(pwd) \
  -v ${HOME}/.m2:${HOME}/.m2 \
  -v /var/run/docker.sock:/var/run/docker.sock \
  azul/zulu-openjdk-alpine:21.0.5 \
  ./mvnw -Djansi.force=true -ntp -P local -U clean resources:resources liquibase:update
```

- Run the microservice

```shell
docker run \
  -u $(id -u):$(grep -w docker /etc/group | awk -F\: '{print $3}') \
  --net=host \
  --rm \
  -w $(pwd) \
  -v /etc/group:/etc/group:ro \
  -v /etc/passwd:/etc/passwd:ro \
  -v $(pwd):$(pwd) \
  -v ${HOME}/.m2:${HOME}/.m2 \
  -v /var/run/docker.sock:/var/run/docker.sock \
  azul/zulu-openjdk-alpine:21.0.5 \
  ./mvnw -Djansi.force=true -ntp -P local -U clean package docker:build docker:run
```

- Run integration tests with JetBrains HTTP Client

```shell
docker run -it \
  --net=host \
  --rm \
  -v ${PWD}/src/test/resources/intellij-httpclient:/workdir \
  jetbrains/intellij-http-client \
    -L VERBOSE \
    -e local \
    -v env.json \
    spring-hexagonal-reference.http
```
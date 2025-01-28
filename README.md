# Spring Hexagonal Reference

## Requirements

- Docker 27

## Building

- Create database container

```shell
docker run -d \
  --net=host \
  --rm \
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

```shell
┌─────────────────────────────────────────────────────────────────────────────┐
│                      Running IntelliJ HTTP Client with                      │
├──────────────────────┬──────────────────────────────────────────────────────┤
│        Files         │ spring-hexagonal-reference.http                      │
├──────────────────────┼──────────────────────────────────────────────────────┤
│  Public Environment  │ server = http:…localhost:8080                        │
├──────────────────────┼──────────────────────────────────────────────────────┤
│ Private Environment  │                                                      │
├──────────────────────┼──────────────────────────────────────────────────────┤
│        Docker        │ Inside Docker localhost is used as an address for    │
│                      │ container, not a host machine.                       │
│                      │                                                      │
│                      │ To access services on host machine, you can use      │
│                      │ host.docker.internal in request or use flag -D to    │
│                      │ ask HTTP Client to treat all localhost in requests   │
│                      │ as host.docker.internal.                             │
│                      │                                                      │
│                      │ Read more:                                           │
│                      │ https://stackoverflow.com/a/24326540/11161744        │
└──────────────────────┴──────────────────────────────────────────────────────┘
Request 'health' GET http://localhost:8080/actuator/health
= request =>
GET http://localhost:8080/actuator/health
User-Agent: IntelliJ HTTP Client/CLI 2024.3
Accept-Encoding: br, deflate, gzip, x-gzip
Accept: */*

###

<= response =
HTTP/1.1 200 
Content-Type: application/vnd.spring-boot.actuator.v3+json
Transfer-Encoding: chunked
Date: Sat, 25 Jan 2025 18:58:57 GMT
 
{"status":"UP"}
 
Response code: 200; Time: 3316ms (3 s 316 ms); Content length: 15 bytes (15 B)
 
Request 'create-one-person' POST http://localhost:8080/persons
= request =>
POST http://localhost:8080/persons
Content-Type: application/json
Content-Length: 47
User-Agent: IntelliJ HTTP Client/CLI 2024.3
Accept-Encoding: br, deflate, gzip, x-gzip
Accept: */*

{
  "name": "Ameyali Rodríguez",
  "age": 42
}

###

<= response =
HTTP/1.1 500 
Content-Type: application/json
Transfer-Encoding: chunked
Date: Sat, 25 Jan 2025 18:58:58 GMT
Connection: close
 
{"timestamp":"2025-01-25T18:58:58.231+00:00","status":500,"error":"Internal Server Error","path":"/persons"}
 
Response code: 500; Time: 405ms (405 ms); Content length: 108 bytes (108 B)
 
Failed spring-hexagonal-reference.http#1 given_correct_body_when_execute_then_status_201

Response status is not 201
  this.assert (at js-graalvm-response-handler.js:32)
  :anonymous (at /workdir/spring-hexagonal-reference.http:19)
Request 'retrieve-all-persons' GET http://localhost:8080/persons
= request =>
GET http://localhost:8080/persons
Accept: application/json
User-Agent: IntelliJ HTTP Client/CLI 2024.3
Accept-Encoding: br, deflate, gzip, x-gzip

###

<= response =
HTTP/1.1 405 
Allow: POST
Content-Type: application/json
Transfer-Encoding: chunked
Date: Sat, 25 Jan 2025 18:59:06 GMT
 
{"timestamp":"2025-01-25T18:59:06.433+00:00","status":405,"error":"Method Not Allowed","path":"/persons"}
 
Response code: 405; Time: 85ms (85 ms); Content length: 105 bytes (105 B)
 
Failed spring-hexagonal-reference.http#2 given_correct_request_when_execute_then_status_200

Response status is not 200
  this.assert (at js-graalvm-response-handler.js:32)
  :anonymous (at /workdir/spring-hexagonal-reference.http:30)
 


3 requests completed, 2 have failed tests
RUN FAILED

```
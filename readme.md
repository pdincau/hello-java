# Hello Java

Trivial java application.

## How to build

```sh
mvn clean package
```

## How to run

```sh
java -jar -Dhttp.server.port=${PORT} target/hello-java-jar-with-dependencies.jar
```

Default port is 8080.

## Greeting route

You can check the health of the service by calling:

```sh
curl localhost:${PORT}/hello?yourname
```


## Healthcheck route

You can check the health of the service by calling:

```sh
curl localhost:${PORT}/ping
```

# Portfolio for Component Based Development Course

To run this Microservice lab, you must first compile the code by running

```shell
mvn clean install
```

Hereafter cd into the ScoringService module

```shell
cd ScoringService
```

Now locally run the service

```shell
mvn spring-boot:run
```

This will open a Spring rest api on localhost:8080

With this service running, the game may be launched by running the following from the root.

```shell
mvn exec:exec -pl GameEngine
```
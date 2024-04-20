<h1 align="center">Meu Feedback</h1>
<p align="center">API to get good customer feedback</p>

Users can create great feedback forms with specific questions and answers.

## Prerequisites

* Java 17
* Kotlin
* MySQL 8
* Docker
* Lombok

## Installation

Before starting the project, you will need to have MySQL:

* __MySQL__ - Database used to store My Feedback project information;

If this resource does not exist, it can be purchased and installed on the local machine through `Docker`:

```sh
docker-compose up -d
```

The database will be created, however, it will only be populated by `Flyway` after the first execution.

Finally, with `Java 17` installed, just download the project dependencies and compile:

```sh
./mvnw clean install -DskipTests
```

## Initialization

To initialize the API, just run the following command:

```sh
./mvnw spring-boot:run
```

## Testes

WIP

```sh
./mvnw test
```
WIP

## Environment variables

This is the list of environment variables used by the application, just change the values as needed.

| Nome |                Descrição                 | Tipo | Valor Padrão |
|------|:----------------------------------------:|:----:|-------------:|
| SPRING_DATASOURCE_ID |           Database identifier      | `String` | `mysql` |
| SPRING_DATASOURCE_HOST | Endereço de conexão com o banco de dados | `String` | `localhost` |
| SPRING_DATASOURCE_PORT |       Database connection address        | `Integer` | `3306` |
| SPRING_DATASOURCE_DATABASE |             Database name                | `String` | `meufeedback` |
| SPRING_DATASOURCE_DRIVER_CLASS_NAME |     Database connection driver name      | `String` | `com.mysql.jdbc.Driver` |
| SPRING_DATASOURCE_USERNAME |              Database User               | `String` | `user_db` |
| SPRING_DATASOURCE_PASSWORD |            Database Password             | `String` | `password_db` |
| SPRING_FLYWAY_ENABLED |              Enable Flyway               | `Boolean` | `true` |

## Autor

Application developed by Diego Gomes Borges.
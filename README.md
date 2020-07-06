# crud
Crud application on Java8, Spring Boot, Spring MVC, Spring JPA, PostgreSQL, Docker, Swagger, Maven

# Run the app
1. mvn clean install
2. docker-compose up --build


# API done
POST /notes Add a note <br>
GET /notes Get all notes <br>
GET /notes/:id Get a single note with a specific id <br>
PUT /notes/:id Update a single note with a specific id <br>
DELETE /notes/:id Delete a single note with a specific id <br>

# Miscellaneous
For running the docker on any db other than PostgreSQL, we will have to change <br>
the application.properties file to have proper dialect and datasource. <br>
This could be done via Docker constant and env files during docker creation. <br>
For testing, we have provided a Swagger UI to ease the testing. <br>
Open http://localhost:8080/swagger-ui.html to check api <br>

# Extra Notes
Using alpine version of docker image to reduce the size of docker. <br>
The docker-compose.yml file contains PostgresSQL params as well

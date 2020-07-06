# crud
Crud application on Java8, Spring Boot, Spring MVC, Spring JPA, PostgreSQL, Docker, Swagger, Maven

# Run the app
1. mvn clean install
2. docker-compose up --build


# API done
POST /notes Add a note
GET /notes Get all notes
GET /notes/:id Get a single note with a specific id
PUT /notes/:id Update a single note with a specific id 
DELETE /notes/:id Delete a single note with a specific id

#Miscellaneous
For running the docker on any db other than PostgreSQL, we will have to change 
the application.properties file to have proper dialect and datasource
This could be done via Docker constant and env files during docker creation
For testing, we have provided a Swagger UI to ease the testing
Open http://localhost:8080/swagger-ui.html to check api

#Notes
Using alpine version of docker image to reduce the size of docker
The docker-compose.yml file contains PostgresSQL params as well

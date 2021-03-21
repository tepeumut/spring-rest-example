# Spring Boot REST API Example Project with MySQL
## Running Project
Project is a [Spring Boot](https://spring.io/guides/gs/spring-boot) application built using [Maven](https://spring.io/guides/gs/maven/). You can build a jar file and run it from the command line:
```
git clone https://github.com/tepeumut/spring-rest-example.git
cd spring-rest-example
./mvnw package
java -jar target/*.jar
```
Or you can run it from Maven directly using the Spring Boot Maven plugin. If you do this it will pick up changes that you make in the project immediately (changes to Java source files require a compile as well - most people use an IDE for this):
```
./mvnw spring-boot:run
```
## Database Configuration
It uses a MySQL database (for now), can be changed easily in the ``application.properties`` for any other database.
For MySQL:
```
spring.datasource.url=jdbc:mysql://USER:PASSWORD@localhost:3306/DATABASE?characterEncoding=UTF-8
```
Change ``USER``,``PASSWORD`` and ``DATABASE`` as per your MySQL installation.


You can then access the project here: http://localhost:8080/users

You can find to Swagger docs here: http://localhost:8080/swagger-ui.html


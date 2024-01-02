# EMPLOYEE CREATOR APP (SPRING BOOT REST API)

- Live: https://employee-creator.netlify.app/
- This is the backend of full stack app called Employee Creator App built on Spring boot with REST API.

## Purpose

- The purpose of the app is to perform CRUD operations on a database by allowing the user to create, read, update and delete employee information.

## Dependencies

- The Spring boot app has the following maven dependencies:
  -- Spring Web
  -- Spring Boot DevTools
  -- Lombok
  -- Validation
  -- MySQL Driver
  -- Spring Data JPA

- You need to have SQL server installed to run this app.

## Design Goals

- The goal was to build a REST API that will expose the database to CRUD operations and then link it with a frontend.

## Features

- On initialization the app creates a database called 'employees', then creates tables as defined by 'Employee' entity and populates them with fake data present in data.sql file.

- The following property in applications.properties defer the running of data.sql file until tables are created.

  `spring.jpa.defer-datasource-initialization=true`

- The user can then add more data or work with the intial data in the database.

- The automatic data initialization allows the user to start CRUD operaitons instantaneously without having to worry about adding data first.

- The API validates the data before accepting the payload through validation library.

- A Model Mapper maps the data into approriate types.

- A Gloabl Exceptions class allows the app to throw NotFoundException anywhere inside the app whenever data is not found in the database.

## Future Goals

- [ ] Add user authentication using JWT
- [ ] Add tests
- [x] Deploy the full stack app on cloud

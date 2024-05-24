# Project Title
Employee Management System
## Project Description
A Java Spring Boot project which able to perform CRUD operations on employee data.
## Software Required
* IDE (Intellij IDEA)
* Postman
* MySQL Workbench
## Run the Project
1. Open project with Intellij IDEA.
2. Check the database connection in src/main/resources/application.properties file.
3. Open MySQL Workbench.
4. Create a database named "employee_ms".
5. Navigate to com.example.employee_ms.EmployeeMsApplication. Right click it and hit Run.
6. Check if the localhost server is started successfully.
7. Open the Postman.
8. Create a new collections named "employee_ms".
9. Under the Authorization section, select Basic Auth and provide the username and password.
10. Right click the "employee_ms" and select "Add request".
11. Select the request method and provide the url accordingly.
## API endpoints
### Department:
* GET - "http://localhost:8080/department" - gets list of all departments
* GET - "http://localhost:8080/department/{id}" - gets department with selected id
* POST - "http://localhost:8080/department/create" - inserts into department
* PUT - "http://localhost:8080/department/update/{id}" - updates department with selected id
* DELETE - "http://localhost:8080/department/delete" - deletes all departments
* DELETE - "http://localhost:8080/department/delete/{id}" - deletes department with selected id
### Employee: 
* GET - "http://localhost:8080/employee" - gets list of all employees
* GET - "http://localhost:8080/employee/{id}" - gets employee with selected id
* POST - "http://localhost:8080/employee/create" - inserts into employee
* PUT - "http://localhost:8080/employee/update/{id}" - updates employee with selected id
* DELETE - "http://localhost:8080/employee/delete" - deletes all employees
* DELETE - "http://localhost:8080/employee/delete/{id}" - deletes employee with selected id
### Project:
* GET - "http://localhost:8080/project" - gets list of all projects
* GET - "http://localhost:8080/project/{id}" - gets project with selected id
* POST - "http://localhost:8080/project/create" - inserts into project
* PUT - "http://localhost:8080/project/update/{id}" - updates project with selected id
* DELETE - "http://localhost:8080/project/delete" - deletes all projects
* DELETE - "http://localhost:8080/project/delete/{id}" - deletes project with selected id

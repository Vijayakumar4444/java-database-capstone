SECTION : 1 ARCHITECHTURE SUMMARY
This Spring Boot app has two types of controllers – MVC and REST.
Thymeleaf templates are used for Admin and Doctor dashboards.
All other parts of the app use REST APIs.
The app connects to two databases – MySQL and MongoDB.
MySQL stores patient, doctor, appointment, and admin data.
MongoDB is used to save prescription details.
Controllers send requests to a shared service layer.
The service layer then talks to the correct database repositories.

SECTION : 2 NUMBERED FLOW OF DATA AND CONTROL
User opens Admin or Doctor dashboard, or other pages.
The request goes to the correct Thymeleaf or REST controller.
The controller sends the request to the service layer.
The service layer decides which database to use.
For patients, doctors, appointments, and admin data, it uses MySQL.
For prescriptions, it uses MongoDB.
The service layer gets or saves data using the repository.
The controller sends the response back to the user or dashboard page.

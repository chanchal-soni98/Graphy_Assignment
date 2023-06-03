# Graphy_Assignment
This is a Spring Boot application that reads emails of users from a large user database and sends them an email every 6 hours. It also logs the emails of users for which the emails are successfully sent in a CSV file.

Prerequisites
Before running the application, make sure you have the following installed:

1. Java Development Kit (JDK) 8 or higher
2. MySQL database (or any other supported database)

Configure the application properties:

Open the src/main/resources/application.properties file and update the following properties:

 #db specific properties
spring.datasource.url=jdbc:mysql://localhost:3306/graphyDb
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.username=root
spring.datasource.password=Soni@123

 #ORM s/w specific properties
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

 #For Swagger
spring.mvc.pathmatch.matching-strategy = ANT_PATH_MATCHER
spring.jpa.properties.hibernate.globally_quoted_identifiers=true


 #Email Config
spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=chanchalsoni19998@gmail.com
spring.mail.password=@Cs11955
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true

# Usage
Access the Swagger API documentation:

Open your web browser and navigate to http://localhost:8080/swagger-ui.html. This page provides a list of available endpoints and their descriptions.

Send Emails:

To send emails to users, you can use the provided API endpoint or schedule it using the built-in scheduler.

API Endpoint: Make a GET request to http://localhost:8080/emailSystem/send/{page}, where {page} is the page number of users to send emails to.

Scheduler: The application is configured to send emails every 6 hours automatically. You can modify the schedule by updating the fixedRate value in the EmailScheduler class.

Database Configuration: If you're using a different database, update the spring.datasource.* properties in the application.properties file with the appropriate values.

Email Server Configuration: If you're using a different email server, update the email.smtp.* and email.* properties in the application.properties file with the correct server details.

That's it!







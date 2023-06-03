# Graphy_Assignment
This is a Spring Boot application that reads emails of users from a large user database and sends them an email every 6 hours. It also logs the emails of users for which the emails are successfully sent in a CSV file.

Prerequisites
Before running the application, make sure you have the following installed:

1. Java Development Kit (JDK) 8 or higher
2. MySQL database (or any other supported database)

Configure the application properties:

Open the src/main/resources/application.properties file and update the following properties:

 #db specific properties
1. spring.datasource.url=jdbc:mysql://localhost:3306/graphyDb
2. spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
3. spring.datasource.username=root
4. spring.datasource.password=Soni@123

 #ORM s/w specific properties
1. spring.jpa.hibernate.ddl-auto=update
2. spring.jpa.show-sql=true

 #For Swagger
1. spring.mvc.pathmatch.matching-strategy = ANT_PATH_MATCHER
2. spring.jpa.properties.hibernate.globally_quoted_identifiers=true


 #Email Config
1. spring.mail.host=smtp.gmail.com
2. spring.mail.port=587
3. spring.mail.username=chanchalsoni19998@gmail.com
4. spring.mail.password=@Cs11955
5. spring.mail.properties.mail.smtp.auth=true
6. spring.mail.properties.mail.smtp.starttls.enable=true

# Instructions
Access the Swagger API documentation: http://localhost:8080/swagger-ui.html.

Send Emails:

API Endpoint: Make a GET request to http://localhost:8080/emailSystem/send/{page}, where {page} is the page number of users to send emails to.

Scheduler: The application is configured to send emails every 6 hours automatically. You can modify the schedule by updating the fixedRate value in the EmailScheduler class.

Email Server Configuration: If you're using a different email server, update the email.smtp.* and email.* properties in the application.properties file with the correct server details.

That's it!







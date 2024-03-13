# English Learn App Backend 

## Project Description:

*  The EngLearn project is a language learning application designed to help users improve their English language skills. It offers interactive lessons, quizzes, and vocabulary exercises to make language learning engaging and accessible. The project aims to provide a user-friendly interface and is accessible to a wide range of users. 
*  The README provides an overview of the project, installation instructions, usage guidelines, and other relevant information for developers and contributors.
    
## Motivation

*  The motivation behind this project is to provide a user-friendly language learning application that helps individuals improve their English language skills. By    offering interactive lessons, quizzes, and vocabulary exercises, EngLearn aims to make language learning engaging and accessible to a wide range of users.

## Project Features:

* Interactive lessons to improve English language skills
* Quizzes to test knowledge and track progress
* Vocabulary exercises to expand vocabulary
* User-friendly interface for easy navigation
* Accessible to a wide range of users

## Prerequisites

This project uses several libraries and tools to run the application:

- **Java**: The main programming language used in this project.
- **Spring Boot**: A framework used for creating stand-alone, production-grade Spring based applications.
- **Maven**: A build automation tool used primarily for Java projects. Maven addresses two aspects of building software: it describes how software is built, and it describes its dependencies.
- **MySQL**: An open-source relational database management system used for storing and retrieving data.
- **IntelliJ IDEA**: An integrated development environment (IDE) used for developing this project.

## Installation
### Way 1: Using Maven

To install the EngLearn project, follow these steps:
1. Clone the repository to your local machine using Git:
2. Navigate to the project directory:
3. Build the project using Maven:
4. Before running the application, make sure you have a MySQL server running. Update the `src/main/resources/application.properties` file with your MySQL server details.
5. Run the application using Maven: `mvn spring-boot:run`. The application should now be running on `localhost:8080`.

### Way 2: Using IntelliJ IDEA

To install the EngLearn project using IntelliJ IDEA, follow these steps:
1. Clone the repository to your local machine using Git:
2. Open the project in IntelliJ IDEA.
3. Update the `src/main/resources/application.properties` file with your MySQL server details.
4. Run the application using the `Run` button in IntelliJ IDEA. The application should now be running on `localhost:8080`.
5. The application should now be running on `localhost:8080`. 
6. To access the application, open a web browser and go to `http://localhost:8080`.
7. You should now see the EngLearn application running on your local machine.

## Update the application.properties file


```
# DataSource
spring.datasource.url=jdbc:uri
spring.datasource.username=username
spring.datasource.password=password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# MyBatis
mybatis.type-aliases-package=com.huuluc.englearn.model
mybatis.configuration.map-underscore-to-camel-case=true
mybatis.configuration.default-fetch-size=100
mybatis.configuration.default-statement-timeout=300

# Limit size file upload 5MB
spring.servlet.multipart.max-file-size=5MB
spring.servlet.multipart.max-request-size=5MB

# Logging
logging.level.org.springframework.web=info
logging.level.root=info
logging.file.name=logs/eng-learn-app.log

# JWT
englearn.app.jwtSecret= your-secret-key
# set 15 days
englearn.app.jwtExpirationMs=1296000000

# Mail
spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=youremail
spring.mail.password=yourapp-password
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true
```


## Contact

For any questions, issues, or suggestions related to this project, please feel free to contact the author:

- GitHub: [huuluc10](https://github.com/huuluc10)
- Email: lucnguyenhuu91@gmail.com

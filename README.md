# Instagram-Clone-Backend

This repository contains the backend code for an Instagram clone, designed as a portfolio project to demonstrate backend development skills using Spring Boot and related technologies.

## Project Overview

The Instagram clone backend is designed to support a web application where users can share images and interact through likes and comments, mimicking the functionality of the popular social media platform, Instagram. It utilizes Spring Boot, Spring Security for authentication, and JPA for data persistence.

## Prerequisites
Before setting up the project, ensure you have the following installed:

- **Java SDK: Version 17 or higher**: Version 20.12.2 or higher
- **Maven: Version 3.6 or higher**: Typically comes with Node.js
- **MySQL: Version 8.0 or higher**: Typically comes with Node.js

You can check your Node.js and npm versions by running:

- **java -version**
- **mvn -version**

# Installation
Follow these steps to set up the project locally.

## Step 1: Clone the Repository
- **git clone https://github.com/DAC-hub-101/Instagram-Clone-Frontend.git**

- **cd instagramclone**

## Step 2: Set Up MySQL Database
Create a MySQL database named instagram_clonedb and grant all privileges to a user specific to this database.

# 📦 MySQL Setup for `instagram_clonedb`

Follow these steps to set up the MySQL database for this project:

## 🔧 Step-by-Step Guide

1. **Log in to MySQL as root:**
   ```bash
   mysql -u root -p
   ```

2. **Create the database:**
   ```sql
   CREATE DATABASE instagram_clonedb;
   ```

3. **Create a new user:**
   ```sql
   CREATE USER 'insta_user'@'localhost' IDENTIFIED BY 'secure_password';
   ```
   > ⚠️ Replace `insta_user` and `secure_password` with your own values.

4. **Grant all privileges to the user on the new database:**
   ```sql
   GRANT ALL PRIVILEGES ON instagram_clonedb.* TO 'insta_user'@'localhost';
   ```

5. **Apply the changes:**
   ```sql
   FLUSH PRIVILEGES;
   ```

6. **(Optional) Confirm privileges:**
   ```sql
   SHOW GRANTS FOR 'insta_user'@'localhost';
   ```

## 🚀 One-liner Setup (for scripting)

If you'd like to run all steps in one go from the shell:

```bash
mysql -u root -p -e "CREATE DATABASE instagram_clonedb; CREATE USER 'insta_user'@'localhost' IDENTIFIED BY 'secure_password'; GRANT ALL PRIVILEGES ON instagram_clonedb.* TO 'insta_user'@'localhost'; FLUSH PRIVILEGES;"
```

## ✅ Security Best Practices

- Use environment variables or secrets management tools to avoid storing raw passwords in scripts
- Consider using a strong, randomly generated password for database users
- Limit database user privileges to only what is necessary for your application
## Step 3: Configure Application Properties
Navigate to src/main/resources and update the application.properties file with your specific MySQL user and password:

spring.datasource.username=your_db_username

spring.datasource.password=your_db_password


## Step 4: Build and Run the Application
From the project directory, run the following command to build the application:
mvnw clean install

Then, start the server by running:
mvnw spring-boot:run

The server will start on http://localhost:8080

## Available Scripts 
In the project directory, you can also run:

- **mvnw test**: Executes the test suite.
- **mvnw spring-boot:run**: Starts the application.
- **mvnw clean install**: Build the application.

## Browser Compatibility

The backend API is compatible with any client that supports HTTP requests and respects CORS policies.

## Troubleshooting
If you encounter any issues during installation or running the application, ensure your Java and Maven setups are correctly configured. For database connection issues, verify your MySQL service is running and credentials in application.properties are correct.

## Contributing
Contributions are welcome!

## License
This project is licensed under the GNU General Public License v3.0 - see the [LICENSE](LICENSE) file for details.

## Contact
If you need any help, please contact me at test@example.com

## Login Page:
![Login](./repositoryAssets/Instagram-Clone-Login.png)

## Register Page:
![Register](./repositoryAssets/Instagram-Clone-Register.png)

## Home Page:
![HomePage](./repositoryAssets/Instagram-Clone-HomePage.png)

## SearchBar:
![HomePage](./repositoryAssets/Instagram-Clone-SearchBar.png)

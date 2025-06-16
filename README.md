 🔐 Spring Security – API Key & Basic Auth Based Authentication
This project demonstrates a secure Spring Boot REST API using **both API Key Authentication** and **Basic Authentication**. It combines custom filters, authentication managers, and Spring Security's core components to protect endpoints with flexible strategies.
---
## ✅ Features

- API Key Authentication for specific endpoints (e.g. `/user`)
- Basic Authentication (Username & Password) for other endpoints (e.g. `/demo`)
- Custom `UserDetailsService` integrated with a database
- Modular architecture using Spring Security filters and custom authentication tokens
- Endpoints are protected and only accessible after proper authentication

---

## 🔧 Tech Stack

- Java 17+
- Spring Boot 3.x
- Spring Security
- MySql Database 
- Maven / Gradle

---
## 📂 Project Structure
src/
├── controller/ # API controllers (UserController)
├── entities/ # JPA entities (User.java)
├── repository/ # Spring Data repositories (UserRepo.java)
├── security/
│ ├── authentication/ # Custom ApiKeyAuthentication token
│ ├── filters/ # Custom ApiKeyFilter
│ ├── managers/ # ApiKeyManager for custom logic
│ ├── service/ # CustomUserDetailsService, UserDetails
│ └── SecurityConfiguration.java

---








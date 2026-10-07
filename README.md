# Servlet_Crud_Operation

# Servlet CRUD Operation

A simple **CRUD REST API application built using Java Servlets**.
This project demonstrates how to create a backend REST API using **Jakarta Servlet, Apache Tomcat, Maven, and Core Java**, without using Spring Boot.

The application performs basic **CRUD operations (Create, Read, Update, Delete)** for users and stores the data temporarily in an in-memory `HashMap`.

---

## 🚀 Project Overview

This project is created to understand how REST APIs work using **Java Servlet technology**.

The application provides APIs to:

* Create a new user
* Get all users
* Get a user by ID
* Update user information
* Delete a user
* Handle missing fields
* Handle user-not-found cases
* Return HTTP status codes
* Return JSON responses

---

## 🛠️ Technologies Used

| Technology            | Purpose                           |
| --------------------- | --------------------------------- |
| Java 26               | Programming language              |
| Jakarta Servlet       | Creating REST APIs                |
| Apache Tomcat 10.1.60 | Web/Servlet container             |
| Maven                 | Project and dependency management |
| IntelliJ IDEA         | Development IDE                   |
| Postman               | API testing                       |
| Git & GitHub          | Version control                   |

---

## 📂 Project Structure

```text
Servlat_Crud_Operation
│
├── src
│   └── main
│       └── java
│           └── udSah
│               └── practice
│                   │
│                   ├── Main.java
│                   │
│                   ├── Model
│                   │   └── User.java
│                   │
│                   ├── Services
│                   │   └── UserService.java
│                   │
│                   └── Servlet
│                       ├── HelloServlet.java
│                       └── UserServlet.java
│
├── pom.xml
├── .gitignore
└── README.md
```

---

# 🏗️ Project Architecture

The project follows a simple layered structure:

```text
Client / Postman
       │
       ▼
 UserServlet
       │
       ▼
 UserService
       │
       ▼
 HashMap<Long, User>
```

### 1. Client

Postman or any HTTP client sends requests to the Servlet API.

### 2. UserServlet

`UserServlet` handles HTTP requests such as:

* POST
* GET
* PUT
* DELETE

It also:

* Reads request parameters
* Validates input
* Calls the service layer
* Creates JSON responses
* Sets HTTP status codes

### 3. UserService

`UserService` contains the application logic.

It performs operations on the user data stored in:

```java
Map<Long, User> userDB = new HashMap<>();
```

### 4. User Model

The `User` class represents user data.

It contains:

```text
id
name
email
mobile
```

---

# 👤 User Model

The `User` class contains four properties:

```java
private long id;
private String name;
private String email;
private String mobile;
```

### Fields

| Field  | Data Type | Description          |
| ------ | --------- | -------------------- |
| id     | long      | Unique user ID       |
| name   | String    | User's name          |
| email  | String    | User's email         |
| mobile | String    | User's mobile number |

---

# 🔧 CRUD Operations

CRUD stands for:

```text
C → Create
R → Read
U → Update
D → Delete
```

---

# 1️⃣ Create User

### HTTP Method

```text
POST
```

### URL

```text
http://localhost:8080/Servlat_Crud_Operation/users
```

### Parameters

```text
id=1
name=Ujjawal
email=ujjawal@gmail.com
mobile=9800000000
```

### Postman

Select:

```text
POST
```

Go to:

```text
Body → x-www-form-urlencoded
```

Add:

| Key    | Value                                         |
| ------ | --------------------------------------------- |
| id     | 1                                             |
| name   | Ujjawal                                       |
| email  | [ujjawal@gmail.com](mailto:ujjawal@gmail.com) |
| mobile | 9800000000                                    |

### Response

```json
{
    "message": "User Added successfully"
}
```

### Status Code

```text
201 Created
```

---

# 2️⃣ Get All Users

### HTTP Method

```text
GET
```

### URL

```text
http://localhost:8080/Servlat_Crud_Operation/users
```

No `id` parameter is provided.

### Example Response

```json
[
    {
        "id": 1,
        "name": "Ujjawal",
        "email": "ujjawal@gmail.com",
        "mobile": "9800000000"
    },
    {
        "id": 2,
        "name": "Ram",
        "email": "ram@gmail.com",
        "mobile": "9811111111"
    }
]
```

### Status Code

```text
200 OK
```

---

# 3️⃣ Get User By ID

### HTTP Method

```text
GET
```

### URL

```text
http://localhost:8080/Servlat_Crud_Operation/users?id=1
```

### Response

```json
{
    "id": 1,
    "name": "Ujjawal",
    "email": "ujjawal@gmail.com",
    "mobile": "9800000000"
}
```

### Status Code

```text
200 OK
```

---

# 4️⃣ Update User

### HTTP Method

```text
PUT
```

### URL

```text
http://localhost:8080/Servlat_Crud_Operation/users?id=1
```

### Parameters

```text
name=Ujjawal Sah
email=ujjawalsah@gmail.com
mobile=9812345678
```

### Postman

Select:

```text
PUT
```

Go to:

```text
Body → x-www-form-urlencoded
```

Add:

| Key    | Value                                               |
| ------ | --------------------------------------------------- |
| name   | Ujjawal Sah                                         |
| email  | [ujjuwalsah@gmail.com](mailto:ujjuwalsah@gmail.com) |
| mobile | 9812345678                                          |

### Response

```json
{
    "message": "User updated successfully"
}
```

### Status Code

```text
200 OK
```

---

# 5️⃣ Delete User

### HTTP Method

```text
DELETE
```

### URL

```text
http://localhost:8080/Servlat_Crud_Operation/users?id=1
```

### Response

```json
{
    "message": "User deleted successfully"
}
```

### Status Code

```text
200 OK
```

---

# ❌ Error Handling

The application also handles common errors.

## Missing Fields

If required fields are missing:

```json
{
    "message": "Some fields are missing"
}
```

Status:

```text
400 Bad Request
```

---

## User Not Found

If a requested user does not exist:

```json
{
    "message": "User not found"
}
```

Status:

```text
404 Not Found
```

---

## Missing User ID

For PUT or DELETE requests without an ID:

```json
{
    "message": "User ID is required"
}
```

Status:

```text
400 Bad Request
```

---

# 🌐 API Summary

| Operation     | Method | Endpoint      | Status |
| ------------- | ------ | ------------- | ------ |
| Create User   | POST   | `/users`      | 201    |
| Get All Users | GET    | `/users`      | 200    |
| Get User      | GET    | `/users?id=1` | 200    |
| Update User   | PUT    | `/users?id=1` | 200    |
| Delete User   | DELETE | `/users?id=1` | 200    |

---

# 📦 Maven

The project uses Maven for dependency management.

The main Servlet dependency is:

```xml
<dependency>
    <groupId>jakarta.servlet</groupId>
    <artifactId>jakarta.servlet-api</artifactId>
    <version>6.0.0</version>
    <scope>provided</scope>
</dependency>
```

The `provided` scope is used because **Tomcat provides the Servlet API at runtime**.

---

# 🐱 Apache Tomcat Setup

This project runs on **Apache Tomcat 10.1.60**.

Tomcat acts as the Servlet container and manages the Servlet lifecycle.

The application can be started using Tomcat.

Example Tomcat directory:

```text
D:\JAVA\apache-tomcat-10.1.60\apache-tomcat-10.1.60
```

Start Tomcat from PowerShell:

```powershell
cd "D:\JAVA\apache-tomcat-10.1.60\apache-tomcat-10.1.60"
.\bin\catalina.bat run
```

---

# ☕ Java Configuration

Java version used:

```text
Java 26.0.1
```

Example `JAVA_HOME`:

```powershell
$env:JAVA_HOME="C:\Program Files\Java\jdk-26.0.1"
```

Check Java version:

```powershell
java -version
```

---

# 🧪 Testing With Postman

Postman is used to test all REST API endpoints.

### Create

```text
POST /users
```

### Read

```text
GET /users
GET /users?id=1
```

### Update

```text
PUT /users?id=1
```

### Delete

```text
DELETE /users?id=1
```

---

# 💾 Data Storage

This project currently uses an **in-memory HashMap** instead of a database.

```java
private Map<Long, User> userDB = new HashMap<>();
```

This means:

* Data is stored temporarily in memory.
* No MySQL/Oracle database is required.
* Data will be lost when the application/server stops.
* The project is mainly for learning Servlet CRUD concepts.

---

# 🔄 Request Flow

For example, when creating a user:

```text
Postman
   │
   │ POST /users
   ▼
UserServlet
   │
   │ Read request parameters
   ▼
UserService
   │
   │ createUser()
   ▼
HashMap
   │
   │ Store User
   ▼
UserServlet
   │
   │ JSON Response
   ▼
Postman
```

---

# 📚 Concepts Learned

This project demonstrates several important Java Web concepts:

* Java Servlet
* Jakarta Servlet API
* HTTP methods
* REST API
* CRUD operations
* `HttpServlet`
* `HttpServletRequest`
* `HttpServletResponse`
* `@WebServlet`
* Servlet URL mapping
* HTTP status codes
* Request parameters
* JSON response
* HashMap
* Java Collections
* Service layer
* Model classes
* Getter and Setter
* Maven
* Apache Tomcat
* Postman API testing
* Git and GitHub

---

# 🎯 Learning Objectives

The main purpose of this project is to understand:

1. How Java Servlets work.
2. How HTTP requests are received.
3. How request parameters are extracted.
4. How CRUD operations are implemented.
5. How a Servlet communicates with a service class.
6. How REST APIs return JSON responses.
7. How HTTP status codes are used.
8. How to deploy/run a Servlet application on Tomcat.
9. How to test APIs using Postman.
10. How to manage a Java project using Git and GitHub.

---

# 🚀 Future Improvements

The project can be improved by adding:

* MySQL database
* JDBC
* DAO layer
* Connection pooling
* Proper JSON library such as Jackson
* Input validation
* Exception handling
* Password authentication
* Login and registration
* Pagination
* Search functionality
* DTO classes
* Global error handling
* Database transactions
* Frontend application
* Docker deployment

---

# 🔮 Future Architecture

After adding a database, the architecture can become:

```text
Client / Postman
       │
       ▼
   Servlet
       │
       ▼
    Service
       │
       ▼
      DAO
       │
       ▼
     JDBC
       │
       ▼
    MySQL
```

This will make the project closer to a real-world backend application.

---

# 👨‍💻 Author

**Ujjawal Sah**

BSc CSIT Student
Nepal

---

# ⭐ Conclusion

This **Servlet CRUD Operation** project is a beginner-friendly Java backend project created to understand the fundamentals of building REST APIs using **Jakarta Servlets and Apache Tomcat**.

It provides a practical foundation before moving toward more advanced backend technologies such as:

```text
Core Java
     ↓
Servlet
     ↓
JDBC
     ↓
MySQL
     ↓
Spring Framework
     ↓
Spring Boot
     ↓
REST API
     ↓
Full-Stack Application
```

If you found this project useful, consider giving the repository a ⭐ on GitHub.

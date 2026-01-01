# Spring Boot JWT Role-Based Product Management API

A secure, enterprise-style REST API built using **Spring Boot**, featuring **JWT authentication**, **role-based authorization**, and **admin-restricted operations**.  
This project demonstrates real-world backend design patterns used in product-based companies.

---

## 🚀 Features

- JWT-based authentication
- Role-based authorization (USER / ADMIN)
- Secure login and signup
- Product CRUD operations
- Admin-only delete operations
- Admin user management (view users, change roles, register admin)
- BCrypt password encryption
- OAuth2 login support (optional)
- Clean REST API design
- Stateless backend (no sessions)

---

## 🛠️ Tech Stack

- **Java 17**
- **Spring Boot**
- **Spring Security**
- **JWT (JSON Web Tokens)**
- **Spring Data JPA**
- **Hibernate**
- **MySQL**
- **Maven**
- **Postman / Browser Fetch API**

---


## 🔐 Authentication Flow (JWT)

1. User logs in using username & password
2. Backend validates credentials
3. JWT token is generated and returned
4. Client stores JWT (localStorage)
5. JWT is sent in `Authorization` header for all protected requests
6. Backend validates JWT on every request

---

## 🔑 Roles & Access Control

| Feature | USER | ADMIN |
|------|------|-------|
| Login | ✅ | ✅ |
| Signup | ✅ | ✅ |
| View products | ✅ | ✅ |
| Add / Update product | ✅ | ✅ |
| Delete product | ❌ | ✅ |
| View users | ❌ | ✅ |
| Change user role | ❌ | ✅ |
| Register admin | ❌ | ✅ |

---

## 📡 API Endpoints

### 🔓 Public APIs

#### Login

POST /auth/login


```json
{
  "username": "admin", 
  "password": "******"
}
```

#### Signup

POST /signup/register


👤 User APIs (JWT Required)

| Method | Endpoint                                          |
| ------ | ------------------------------------------------- |
| GET    | /api/user/product                                 |
| GET    | /api/user/product/{id}                            |
| POST   | /api/user/product                                 |
| PUT    | /api/user/product                                 |
| GET    | /api/user/product/search?name=phone&minPrice=1000 |


#### Admin APIs (ADMIN Role Required)

| Method | Endpoint                   |
| ------ | -------------------------- |
| DELETE | /api/admin/product/{id}    |
| GET    | /api/admin/users           |
| PUT    | /api/admin/users/{id}/role |
| POST   | /api/admin/register        |


````json

{
  "role": "ROLE_ADMIN"
}
````

## ⚙️ Configuration

Sensitive configuration files are not committed.

Steps to run locally:
1. Copy `application.properties.example`
2. Rename it to `application.properties`
3. Update DB credentials & secrets
4. Run the application


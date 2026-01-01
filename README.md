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
## 🧱 Project Structure

com.prajjwal.SpringApplication
├── Controller
│ ├── AuthController.java
│ ├── ProductController.java
│ ├── AdminUserController.java
│ └── UserRegister.java
├── Services
│ ├── ProductService.java
│ └── UserService.java
├── Repository
│ ├── ProductRepository.java
│ └── UserRepository.java
├── Model
│ ├── UserEntity.java
│ ├── Product.java
│ ├── JwtFilter.java
│ └── JwtUtility.java
├── DTO
│ └── RoleUpdateRequest.java
├── config
│ └── SecurityConfig.java
└── resources
└── static


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

Get all products
GET /api/user/product

Get product by ID
GET /api/user/product/{id}

Add product
POST /api/user/product

Update product
PUT /api/user/product

Search product
GET /api/user/product/search?name=phone&minPrice=1000

#### Admin APIs (ADMIN Role Required)

Delete product
DELETE /api/admin/product/{id}

View all users
GET /api/admin/users

Change user role
PUT /api/admin/users/{id}/role

````json

{
  "role": "ROLE_ADMIN"
}
````

Register admin
POST /api/admin/register

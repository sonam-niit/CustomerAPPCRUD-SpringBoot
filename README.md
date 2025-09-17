# 🧑‍💻 Customer Management App (Spring Boot + ArrayList)

A simple **Customer Management Application** built with **Spring Boot**.  
It demonstrates **CRUD operations** using an **ArrayList** as the in-memory data store with proper **layered architecture**:

- **Entity Layer** → Defines the `Customer` object.  
- **Repository Layer** → Handles storage using `ArrayList`.  
- **Service Layer** → Business logic and communication between controller and repository.  
- **Controller Layer** → REST API endpoints for CRUD operations.  

This project also includes **Unit Tests** and **Integration Tests** for each layer.

---

## 📂 Project Structure

```
customer-app/
 ├── src/main/java/com/example/customerapp
 │    ├── entity
 │    │    └── Customer.java
 │    ├── repository
 │    │    └── CustomerRepository.java
 │    ├── service
 │    │    └── CustomerService.java
 │    ├── controller
 │    │    └── CustomerController.java
 │    └── CustomerAppApplication.java
 ├── src/test/java/com/example/customerapp
 │    ├── CustomerRepositoryTest.java   # Unit tests (Repository Layer)
 │    ├── CustomerServiceTest.java      # Unit tests (Service Layer with Mockito)
 │    └── CustomerControllerTest.java   # Integration tests (Controller Layer with MockMvc)
 └── pom.xml
```

---

## ⚙️ Setup & Run

### 1. Clone the repo
```bash
git clone https://github.com/your-username/customer-app.git
cd customer-app
```

### 2. Build the project
```bash
mvn clean install
```

### 3. Run the application
```bash
mvn spring-boot:run
```

App will start at:  
👉 [http://localhost:8080](http://localhost:8080)

---

## 🚀 REST API Endpoints

| Method | Endpoint          | Description            | Sample Payload |
|--------|------------------|------------------------|----------------|
| POST   | `/customers`     | Add a new customer     | `{ "id": 1, "name": "John", "email": "john@example.com" }` |
| GET    | `/customers`     | Get all customers      | - |
| GET    | `/customers/{id}`| Get customer by ID     | - |
| PUT    | `/customers/{id}`| Update a customer      | `{ "name": "John Updated", "email": "john.updated@example.com" }` |
| DELETE | `/customers/{id}`| Delete a customer      | - |

---

## 🧪 Testing

### Run all tests
```bash
mvn test
```

### Test Coverage
- ✅ **Repository Tests (`CustomerRepositoryTest`)**  
  - Tests in-memory `ArrayList` CRUD logic.  
- ✅ **Service Tests (`CustomerServiceTest`)**  
  - Uses **Mockito** to mock repository and test service logic.  
- ✅ **Controller Tests (`CustomerControllerTest`)**  
  - Uses **MockMvc** for integration testing of REST APIs.  

---

## 📝 Example Test Workflow

1. Run **Repository Tests** → Ensure basic ArrayList CRUD works.  
2. Run **Service Tests** → Ensure service correctly calls repository (mocked).  
3. Run **Controller Tests** → Ensure REST APIs work end-to-end.  

---

## 🎯 Learning Outcomes

- Understand layered architecture in Spring Boot.  
- Implement CRUD operations using an in-memory data store (`ArrayList`).  
- Learn **Unit Testing** (JUnit + Mockito).  
- Learn **Integration Testing** (Spring Boot + MockMvc).  
- Practice writing clean, maintainable code with **separation of concerns**.  

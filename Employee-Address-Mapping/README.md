
<h1 align="center"> Employee-Address Mapping Project </h1>
<p align="center">
<a href="Java url">
    <img alt="Java" src="https://img.shields.io/badge/Java->=8-darkblue.svg" />
</a>
    <a href="Maven url" >
    <img alt="Maven" src="https://img.shields.io/badge/maven-4.0-brightgreen.svg" />
</a>
<a href="Spring Boot url" >
    <img alt="Spring Boot" src="https://img.shields.io/badge/Spring Boot-3.1.4-brightgreen.svg" />
</a>
<a href="License url" >
    <img alt="BSD Clause 3" src="https://img.shields.io/badge/License-BSD_3--Clause-blue.svg"/>
</a>
</p>

---

<p align="left">

## Overview

This project, the "Employee-Address Mapping Project," is a Spring Boot application that demonstrates a one-to-one mapping between Employee and Address entities. It provides a set of RESTful API endpoints for creating, retrieving, updating, and deleting employees and addresses. This project serves as a foundation for managing employee data along with their corresponding addresses.

## Technologies Used

- **Framework:** Spring Boot
- **Language:** Java
- **Build Tool:** Maven

## Dependencies

The E-commerce API Application uses the following dependencies:

- **Spring Boot Starter Data JPA**
  - **Description:** Provides support for JPA (Java Persistence API) and simplifies database access using Spring Data repositories.
  - **Maven Dependency:**
    ```xml
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
    ```

- **Spring Boot Starter Web**
  - **Description:** Provides support for building web applications, including RESTful APIs.
  - **Maven Dependency:**
    ```xml
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    ```

- **MySQL Connector/J (Runtime Dependency)**
  - **Description:** The MySQL JDBC driver for connecting to MySQL databases.
  - **Maven Dependency:**
    ```xml
    <dependency>
        <groupId>com.mysql</groupId>
        <artifactId>mysql-connector-j</artifactId>
        <scope>runtime</scope>
    </dependency>
    ```

- **Project Lombok (Optional)**
  - **Description:** A library that simplifies Java code by reducing boilerplate code, such as getters and setters.
  - **Maven Dependency:**
    ```xml
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <optional>true</optional>
    </dependency>
    ```

- **Spring Boot Starter Test (For Testing)**
  - **Description:** Provides support for testing Spring Boot applications.
  - **Maven Dependency (Test Scope):**
    ```xml
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-test</artifactId>
        <scope>test</scope>
    </dependency>
    ```

- **Springdoc OpenAPI (Swagger UI)**
  - **Description:** Adds Swagger UI for documenting and testing your API endpoints.
  - **Maven Dependency:**
    ```xml
    <dependency>
        <groupId>org.springdoc</groupId>
        <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
        <version>2.1.0</version>
    </dependency>
    ```

- **Spring Boot Starter Validation**
  - **Description:** Includes validation support for request data binding and response data rendering.
  - **Maven Dependency:**
    ```xml
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-validation</artifactId>
    </dependency>
    ```

## Data Flow

In the Employee-Address Mapping Project, data flows through various components to handle employee and address operations. Here's an overview of the data flow:

1. **Employee Entity**

   - **Controller Layer**

     The `EmployeeController` handles HTTP requests related to employees and routes them to the `EmployeeService`.

     ```java
     // EmployeeController.java

     @RestController
     @RequestMapping("/employees")
     public class EmployeeController {
         // Define employee-related endpoints and methods
     }
     ```

   - **Service Layer**

     The `EmployeeService` contains business logic and interacts with the `EmployeeRepository` to perform CRUD operations on employee data.

     ```java
     // EmployeeService.java

     @Service
     public class EmployeeService {
         // Implement employee-related service methods
     }
     ```

   - **Repository Layer**

     The `EmployeeRepository` manages data access to the employee entity using Spring Data JPA.

     ```java
     // EmployeeRepository.java

     @Repository
     public interface EmployeeRepository extends JpaRepository<Employee, Long> {
         // Define custom queries or repository methods if needed
     }
     ```

   - **Employee Entity**

     The `Employee` entity represents the structure of employee data in the database.

     ```java
     // Employee.java (Employee Entity)

     @Entity
     public class Employee {
         // Define employee attributes, getters, setters, etc.
     }
     ```

2. **Address Entity**

   - **Controller Layer**

     The `AddressController` handles HTTP requests related to addresses and routes them to the `AddressService`.

     ```java
     // AddressController.java

     @RestController
     @RequestMapping("/addresses")
     public class AddressController {
         // Define address-related endpoints and methods
     }
     ```

   - **Service Layer**

     The `AddressService` contains business logic and interacts with the `AddressRepository` to perform CRUD operations on address data.

     ```java
     // AddressService.java

     @Service
     public class AddressService {
         // Implement address-related service methods
     }
     ```

   - **Repository Layer**

     The `AddressRepository` manages data access to the address entity using Spring Data JPA.

     ```java
     // AddressRepository.java

     @Repository
     public interface AddressRepository extends JpaRepository<Address, Long> {
         // Define custom queries or repository methods if needed
     }
     ```

   - **Address Entity**

     The `Address` entity represents the structure of address data in the database.

     ```java
     // Address.java (Address Entity)

     @Entity
     public class Address {
         // Define address attributes, getters, setters, etc.
     }
     ```

## Database Design

The project's database design includes tables for employees and addresses, each with specific fields. This design ensures data integrity and organized storage.

#### Employee Table

| Column Name | Data Type   | Description                            |
| ----------- | ----------- | -------------------------------------- |
| id          | BIGINT (Primary Key) | Unique identifier for each employee   |
| first_name  | VARCHAR(255) | First name of the employee              |
| last_name   | VARCHAR(255) | Last name of the employee               |

#### Address Table

| Column Name | Data Type   | Description                            |
| ----------- | ----------- | -------------------------------------- |
| id          | BIGINT (Primary Key) | Unique identifier for each address    |
| street      | VARCHAR(255) | Street address of the address           |
| city        | VARCHAR(255) | City where the address is located      |
| state       | VARCHAR(255) | State or region of the address         |
| zipcode     | VARCHAR(20)  | Postal code or ZIP code of the address |
| employee_id | BIGINT (Foreign Key) | Employee ID associated with the address |


## Data Structures

The project utilizes the following data structures to represent employees and address data:

#### Employee Class

The `Employee` class defines the structure for employee data and includes fields such as `id`, `first_name`, and `last_name`.

```java
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String first_name;
    private String last_name;

    @OneToOne(mappedBy = "employee", cascade = CascadeType.ALL)
    private Address address;
}
```

#### Address Class

The `Address` class defines the structure for address data and includes fields such as `id`, `street`, `city`, `state`, `zipcode`, and a reference to the associated `Employee`.

```java
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String street;
    private String city;
    private String state;
    private String zipcode;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private Employee employee;
}
```
#### ArrayList Usage

ArrayLists can be used to represent lists of items in your application. For example, you can use an ArrayList to represent a list of employees with their associated addresses.

```java
List<Employee> employees = new ArrayList<>();
```

## Database Configuration

The project is configured to connect to a MySQL database with the following properties:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/Employee
spring.datasource.username=Your_Username
spring.datasource.password=Your_Password
spring.datasource.driverClassName=com.mysql.cj.jdbc.Driver
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.show_sql=true
spring.jpa.properties.hibernate.use_sql_comments=true
spring.jpa.properties.hibernate.format_sql=true
```
```sql
mysql -u root -p;

GRANT ALL PRIVILEGES ON Employee.* TO 'root'@'localhost';

FLUSH PRIVILEGES;

CREATE DATABASE Employee;
```


Make sure your MySQL database is running, and the credentials match those provided in the configuration.

## Usage

1. Start your Spring Boot application.
2. Access the API endpoints to create, retrieve, update, and delete employees and addresses.

## License

This project is licensed under the [BSD 3-Clause License](LICENSE).

## Contact

For questions or feedback, please contact [Amit Ashok Swain](mailto:business.amitswain@gmail.com).


# Brewery

Brewery is a Spring Boot microservice providing a RESTful API for managing beer and customer resources in a brewery domain. The application leverages modern web technologies to create a comprehensive backend service, enabling complete management of beer products and customer data.

## 🚀 Features

### 🍺 Beer Management
- **Get Beer**: Retrieve beer details by ID
- **Create Beer**: Add new beers to the catalog
- **Update Beer**: Modify existing beer information
- **Delete Beer**: Remove beers from the catalog
- **API Versioning**: Support for multiple API versions (v1 and v2)

### 👤 Customer Management
- **Get Customer**: Retrieve customer information by ID
- **Create Customer**: Register new customers
- **Update Customer**: Update existing customer data
- **Delete Customer**: Remove customers from the database

### 🔧 Technical Features
- **Input Validation**: Bean validation for request data integrity
- **Error Handling**: Global exception handling with meaningful HTTP responses
- **Resource URIs**: RESTful resource location information
- **Response Status Codes**: Proper HTTP status codes for different operations

## 🛠 Technologies

- **Framework**: Spring Boot
- **Architecture**: RESTful API with versioning
- **Input Validation**: Spring Validation
- **Development**: Lombok for reduced boilerplate
- **Design Pattern**: Service layer pattern

## 🗂 Project Structure

### Main Components

#### Beer Module
- **API Layer**:
    - `BeerController.java` - REST controller for beer operations (v1)
    - `BeerControllerV2.java` - Updated version of beer endpoints (v2)

- **Service Layer**:
    - `BeerService.java` - Service interface defining beer operations
    - `BeerServiceImpl.java` - Implementation of beer service operations
    - `BeerServiceV2.java` - Version 2 of beer service interface
    - `BeerServiceV2Impl.java` - Implementation of version 2 beer operations

- **Model Layer**:
    - `BeerDto.java` - Data transfer object for beer information (v1)
    - `BeerDtoV2.java` - Updated beer DTO with enum beer style (v2)
    - `BeerStyleEnum.java` - Enumeration of beer styles

#### Customer Module
- **API Layer**:
    - `CustomerController.java` - REST controller for customer operations

- **Service Layer**:
    - `CustomerService.java` - Service interface defining customer operations
    - `CustomerServiceImpl.java` - Implementation of customer service operations

- **Model Layer**:
    - `CustomerDto.java` - Data transfer object for customer information

#### Cross-Cutting Concerns
- **Exception Handling**:
    - `MvcExceptionHandler.java` - Global exception handling for the API

## 📡 API Endpoints

### Beer API (v1)
- `GET /api/v1/beer/{beerId}` - Get beer by ID
- `POST /api/v1/beer` - Create new beer
- `PUT /api/v1/beer/{beerId}` - Update beer
- `DELETE /api/v1/beer/{beerId}` - Delete beer

### Beer API (v2)
- `GET /api/v2/beer/{beerId}` - Get beer by ID (with improved style enum)
- `POST /api/v2/beer` - Create new beer
- `PUT /api/v2/beer/{beerId}` - Update beer
- `DELETE /api/v2/beer/{beerId}` - Delete beer

### Customer API
- `GET /api/v1/customer/{customerId}` - Get customer by ID
- `POST /api/v1/customer` - Create new customer
- `PUT /api/v1/customer/{customerId}` - Update customer
- `DELETE /api/v1/customer/{customerId}` - Delete customer

## 🔄 Microservice Architecture

This service is part of a brewery microservice architecture:
- **Brewery** (this service): Core API for brewery data management
- **Brewery Client**: Client library for consuming the brewery API
- **Beer Service**: Specialized service for beer inventory management

## 🚀 Deployment

To run the application:
1. Ensure you have Java 11+ installed
2. Build with Maven: `mvn clean package`
3. Run the JAR file: `java -jar target/brewery-0.0.1-SNAPSHOT.jar`
4. The service will be available at `http://localhost:8080`

## 🔐 Security & Validation

- **Input Validation**: Required fields for beer and customer DTOs
- **Exception Handling**: Proper error responses for validation failures
- **Null Constraints**: Protection against invalid ID assignments

---

Brewery represents a modern approach to brewery data management, offering a clean, efficient REST API built on reliable Spring Boot technology. The system provides a comprehensive solution for businesses seeking an effective way to manage their beer products and customer information.

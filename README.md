# Spring Boot Banking API

This project showcases a simple yet robust Spring Boot API for managing banking operations.

## Features

- **Deposit:** Add funds to an account.
- **Withdraw:** Withdraw funds from an account.
- **Transfer:** Transfer funds between accounts.
- **Get All Accounts:** Retrieve a list of all accounts.
- **Get Users:** Fetch details of all users.
- **Get All Transactions:** Fetch all transactions for a user/account.

## Technologies Used
- Spring Boot
- PostgreSQL
- Lombok
- hibernate
- Mapstruct
- Postman

## Core Components

- **Controller:** Implements RESTful endpoints for handling HTTP requests.
- **Service:** Handles business logic and orchestrates interactions between components.
- **Repository:** Interacts with the database for CRUD operations.
- **DTOs (Data Transfer Objects):** Facilitate data exchange between layers.
- **Mappers:** Convert entities to DTOs and vice versa using mapstruct.
- **Exception Handling:** Custom exception handling for graceful error responses.
- **AOP (Aspect-Oriented Programming):** Global exception handler for centralized error management.

## Setup

1. Clone the repository.
2. Navigate to the project directory.
3. Run `mvn spring-boot:run` to start the application.
4. The API will be available at `http://localhost:8080`.

## Usage

### Deposit

```http
POST /transactions/deposit
{
    "transactionType" : "CREDIT",
    "amount": "12000",
    "accountId": "1"
}

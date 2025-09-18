# Expense Tracker Web Application

An Expense Tracker application built with **Spring Boot (Backend)**, **MySQL (Database)**, and a simple **Frontend (HTML/JS)**.  
This project helps users register, log in, add transactions, and view their expense history.

---

## Features
  **User Management**
  - Register new users
  - Fetch user details by username

  **Transaction Management**
  - Add new transactions
  - View transactions by user
  - Delete transactions

 **Cross-Origin Support**
  - Backend configured with CORS to connect easily with frontend

---

## Tech Stack
- **Backend:** Spring Boot  
- **Database:** MySQL  
- **Frontend:** HTML, CSS, JavaScript  
- **Build Tool:** Maven  
- **Containerization :** Docker  

---

## ⚙️ Project Structure
  ExpenseTracker/
├── src/main/java/com/example/expensetracker/
│   ├── UserController.java
│   ├── TransactionController.java
│   ├── UserService.java
│   ├── TransactionService.java
│   ├── User.java
│   └── Transaction.java
├── src/main/resources/
│   └── application.properties
├── frontend/
│   ├── index.html
│   ├── add-transaction.html
│   └── script.js
└── pom.xml

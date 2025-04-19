#  Finance Management System

This is a simple Java-based **Finance Management System** built as part of a case study project by Hexaware Technologies. It follows object-oriented programming principles and demonstrates key functionalities such as CRUD operations, SQL database interaction, custom exception handling, and unit testing.

---

##  Features

- **User Management**: Create and delete user accounts  
- **Expense Management**: Add, update, delete, and view expenses  
- **Categorization**: Assign expenses to different categories  
- **Reporting**: View all expenses per user  
- **User-defined Exceptions**: Handles specific error scenarios  
- **Unit Testing**: Validate core functions using JUnit  
- **Menu-driven Interface**: Command-line interaction for smooth user experience  

---

##  Project Structure

finance-management-system/
├── src/ │
├── app/ # Main driver class │
├── dao/ # Interfaces and DB interaction logic │
├── entity/ # Data models (User, Expense, Category) │
├── exception/ # Custom user-defined exceptions │
├── util/ # DB connection and property utilities
│ └── test/ # Unit test cases 
├── db.properties # Database configuration file 
├── README.md # Project documentation 
├── .gitignore # Git ignored files └── pom.xml # Maven configuration 


---

## ⚙️ Technologies Used

- Java (Core)
- JDBC
- MySQL (or any relational DB)
- JUnit 5
- Maven (optional)
- Git

---

## How to Run

### 1. Clone the Repository
```bash
git clone https://github.com/<your-username>/finance-management-system.git
cd finance-management-system

This project was developed for educational and case study purposes and is not licensed for commercial use.

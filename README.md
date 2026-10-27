# KIET Student Management System

A simple Student Academic Management REST API built using Java and Spring Boot. This project allows users to manage student records through REST API endpoints.

## Features

- View all students
- Search for a student by ID
- Add a new student
- Update student details
- Delete a student record
- Search students by branch and year
- Find students based on CGPA
- Display application startup messages

## Technologies Used

- Java
- Spring Boot
- Spring Web
- REST API
- Maven
- IntelliJ IDEA

## Project Structure

```text
student-academic-management
├── src
│   └── main
│       ├── java
│       │   └── com.kiet.student
│       │       ├── StudentApplication.java
│       │       ├── model
│       │       │   └── Student.java
│       │       └── controller
│       │           └── StudentController.java
│       └── resources
│           └── application.properties
├── pom.xml
└── README.md
```

## API Endpoints

| HTTP Method | Endpoint | Description |
|---|---|---|
| GET | `/students` | Get all students |
| GET | `/students/{studentId}` | Get a student by ID |
| POST | `/students` | Add a student |
| PUT | `/students/{studentId}` | Update a student |
| DELETE | `/students/{studentId}` | Delete a student |
| GET | `/students/search?branch=CSE&year=2` | Search students by branch and year |
| GET | `/students/topper?cgpa=9.0` | Find students with the specified minimum CGPA |

## How to Run the Project

1. Install Java and IntelliJ IDEA.
2. Open the project in IntelliJ IDEA.
3. Allow Maven to download the required dependencies.
4. Run `StudentApplication.java`.
5. The application runs on port `8080`.

Base URL:

```text
http://localhost:8080
```

## Example: Add a Student

**Method:** POST

**URL:** `http://localhost:8080/students`

**Request Body:**

```json
{
  "studentId": 106,
  "name": "Aarav",
  "email": "aarav@gmail.com",
  "branch": "AIML",
  "year": 2,
  "cgpa": 9.1
}
```

**Expected Response:**

```json
{
  "message": "Student added successfully"
}
```

## Data Storage

This project uses an in-memory list to store student records. Data is not permanently stored and resets when the application restarts.

## Author

Student Academic Management REST API Project

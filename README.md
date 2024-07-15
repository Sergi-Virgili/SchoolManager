![CI Spring Boot](https://github.com/Sergi-Virgili/SchoolManager/actions/workflows/spring-ci.yml/badge.svg)

# School Manager

[Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.3-green) ![Java](https://img.shields.io/badge/Java-21-blue) ![Maven](https://img.shields.io/badge/Maven-3.8.4-red) ![H2 Database](https://img.shields.io/badge/H2%20Database-1.4.200-blue)

School Manager is a sample project built with Spring Boot 3.3. It provides an API to manage courses and trainers. The project uses Maven for dependency management and an in-memory H2 database for data storage.

## Features

- Create a course: `/api/courses` (POST)
- Create a trainer: `/api/trainers` (POST)
- View all trainers: `/api/trainers` (GET)

## Getting Started

### Prerequisites

- Java 21
- Maven 3.8.4 or higher

### Installation

1. Clone the repository:
    ```bash
    git clone https://github.com/Sergi-Virgili/SchoolManager.git
    cd school-manager
    ```

2. Build the project with Maven:
    ```bash
    mvn clean install
    ```

3. Run the application:
    ```bash
    mvn spring-boot:run
    ```

The application will be available at `http://localhost:8080`.

## API Endpoints

### Create a Course

- **URL**: `/api/courses`
- **Method**: `POST`
- **Request Body**:
    ```json
    {
        "name": "Course Title",
        "description": "Course Description",
        "trainerId": 1
    }
    ```
- **Successful Response**:
    ```json
    {
        "id": 1,
        "title": "Course Title",
        "description": "Course Description",
        "trainer": {
            "id": 1,
            "name": "Trainer Name"
        }
    }
    ```

### Create a Trainer

- **URL**: `/api/trainers`
- **Method**: `POST`
- **Request Body**:
    ```json
    {
        "name": "Trainer Name"
    }
    ```
- **Successful Response**:
    ```json
    {
        "id": 1,
        "name": "Trainer Name"
    }
    ```

### View All Trainers

- **URL**: `/api/trainers`
- **Method**: `GET`
- **Successful Response**:
    ```json
    [
        {
            "id": 1,
            "name": "Trainer Name"  
        },
        {
            "id": 2,
            "name": "Another Trainer" 
        }
    ]
    ```

## Running Tests Locally

### Prerequisites

- Ensure you have Java 21 and Maven installed.

### Running Tests

1. Navigate to the project directory:
    ```bash
    cd school
    ```

2. Run the tests using Maven:
    ```bash
    mvn test
    ```

The test results will be displayed in the console.

## Contributing

If you wish to contribute to this project, please follow these steps:

1. Fork the repository.
2. Create a new branch (`git checkout -b feature/new-feature`).
3. Make your changes and commit them (`git commit -am 'Add new feature'`).
4. Push to the branch (`git push origin feature/new-feature`).
5. Open a Pull Request.

---

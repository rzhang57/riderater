# Amusement Park Ride Rater

A community-driven application that allows users to rate and review amusement park rides.

## Features

### Backend (Java Spring Boot)
- **RESTful API**: Handles CRUD operations for rides, ratings, users, and reviews.
- **Bidirectional Relationships**: Efficient data querying and management between `Attraction` and `Rating` entities.
- **PostgreSQL Database**: Utilizes a relational database for persistent data storage and efficient queries.
- **Authorization & Authentication**: Secured endpoints with layered security and Auth0 for user authentication.
- **Automated Testing**:
  - **Selenium**: Browser automation tests for end-to-end scenarios.
  - **JUnit**: Unit tests ensuring code reliability and functionality.

### Frontend (React + TypeScript)
- **Modern UI**: Built with React and TypeScript, providing a responsive interface for viewing and interacting with rides.
- **Frontend-Backend Communication**: Integrates with the backend via RESTful API calls using Axios.

## Getting Started

### Prerequisites
- Java 11+
- Node.js and npm
- PostgreSQL
- Auth0 Account (for authentication)

### Backend Setup
1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/ride-rater.git
   cd ride-rater/backend

# RideRater

## Description

**RideRater** is a full-stack web application designed to provide a centralized platform for rating and reviewing amusement park rides. Users can post ratings, leave comments, and view aggregated ratings for various attractions. Built with React for the frontend, Spring Boot for the backend, and PostgreSQL for database management, RideRater offers a streamlined and interactive experience for ride enthusiasts.

## Features

- **Ratings and Reviews**: Post ratings and comments for different attractions.
- **Dynamic Content**: View attractions and their ratings with live database updating.

## Features in progress

- **User Authentication and Authorization**: Users required to log in using social accounts to submit reviews

## Technologies

- **Frontend**: ReactJS
- **Backend**: Java Spring Boot
- **Database**: PostgreSQL
- **Containerization of Database**: Docker Desktop

## Prerequisites

- Java 17+
- Node.js 18+
- PostgreSQL

## Setup Instructions

### Cloning the Repository

1. Clone the repository to your local machine:
   ```bash
   git clone https://github.com/rzhang57/riderater.git

2. Navigate to the project directory:
   ```bash
   cd riderater

### Backend Setup
1. Navigate to the project directory:
   ```bash
   cd riderater-server

2. Install dependencies if not automatically done by IDE.

3. Modify/Create application.properties file and define your datasource with credentials
   ```bash
   spring.datasource.url=
   spring.datasource.username=
   spring.datasource.password=

4. Run RideRaterApplication.java to build and start the backend server

### Frontend Setup
1. Navigate to the project directory:
   ```bash
   cd riderater-client

2. Install dependencies using:
   ```bash
   npm install

3. Start development server:
   ```bash
   npm run dev



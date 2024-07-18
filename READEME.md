# Hotel Rating Service

This is a microservice architecture application designed for a hotel rating service. The application comprises three distinct services: Hotel, User, and Rating. Each of these services is registered with a Eureka service registry, facilitating service discovery and management.

## Services

### Hotel Service
- **Technology**: Spring Boot
- **Database**: PostgreSQL
- **Description**: Manages hotel data, including details about hotels, locations, and amenities.

### User Service
- **Technology**: Spring Boot
- **Database**: MySQL
- **Description**: Handles user data, including registration, authentication, and user profiles.

### Rating Service
- **Technology**: Node.js
- **Database**: MongoDB
- **Description**: Manages hotel ratings and reviews submitted by users.

## Service Registry

### Eureka Service Registry
- **Description**: All services register themselves with the Eureka server, allowing for easy discovery and load balancing.

## Getting Started

### Prerequisites
- Java 11 or higher
- Node.js 14 or higher
- PostgreSQL
- MySQL
- MongoDB
- Maven
- npm or yarn


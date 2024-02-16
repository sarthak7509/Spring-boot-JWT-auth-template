### JWT Token Auth Template in Spring Boot

This is a Spring Boot project template that provides a JWT-based authentication system. This README will guide you through the steps to install and use this template.

#### Installation:

1. Clone the repository:

   ```bash
   git clone https://github.com/sarthak7509/Spring-boot-JWT-auth-template.git
   ```

2. Navigate to the project directory:

   ```bash
   cd your-repository
   ```

3. Build the project:

   ```bash
   mvn clean install
   ```

4. Start the PostgreSQL database server:

   ```bash
   docker-compose up
   ```

#### Usage:

1. Start the Spring Boot application:

   ```bash
   mvn spring-boot:run
   ```

2. Register a new user:

    - Endpoint: `/api/v1/auth/register`
    - Method: `POST`
    - Request body:
      ```json
      {
        "firstName": "John",
        "lastName": "Doe",
        "email": "john.doe@example.com",
        "password": "password123"
      }
      ```
    - Response: JWT token will be placed in the `Authorization` header.

3. Authenticate a user:

    - Endpoint: `/api/v1/auth/authenticate`
    - Method: `POST`
    - Request body:
      ```json
      {
        "email": "john.doe@example.com",
        "password": "password123"
      }
      ```
    - Response: JWT token will be placed in the `Authorization` header.

#### Important Note:

- All requests to protected endpoints must include the JWT token in the `Authorization` header.
- If the token is expired or invalid, the server will respond with a `403 Unauthorized` status code.
- To access protected endpoints, make sure to include the `Authorization` header in the request with the value `Bearer <your-jwt-token>`, where `<your-jwt-token>` is the token obtained during registration or authentication.

#### Example:

To access a protected endpoint `/api/v1/demo`, send a `GET` request with the following header:

```
Authorization: Bearer <your-jwt-token>
```

Replace `<your-jwt-token>` with the JWT token obtained during registration or authentication.
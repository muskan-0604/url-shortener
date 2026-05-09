# URL Shortener API

A backend project built using Java, Spring Boot, PostgreSQL, and JPA that converts long URLs into short URLs and redirects users to the original website.

## Features

- Generate short URLs
- Redirect to original URLs
- Track click count
- Expiry time support
- Unique short code generation
- PostgreSQL database integration
- REST API architecture

## Tech Stack

- Java
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Maven
- Lombok

## API Endpoints

### Create Short URL 


POST /shorten

Request Body:
https://google.com

Response:
http://localhost:8080/abc123XY

---

### Redirect URL


GET /{shortCode}

Example:
http://localhost:8080/abc123XY

This redirects to the original URL.

## Database Fields

| Field | Description |
|------|------|
| id | Primary Key |
| originalUrl | Original long URL |
| shortUrl | Generated short code |
| createdTime | URL creation time |
| expiryTime | URL expiry time |
| clickCount | Number of clicks |

## Future Improvements

- Custom short URLs
- Redis caching
- Analytics dashboard
- Docker support
- JWT Authentication
- Rate limiting

## Run Project

```bash
mvn spring-boot:run

# User Service

User Micro service built using Spring Boot

## Table of Contents

- [Usage](#usage)
- [Endpoints](#endpoints)

## Usage

Here's how you can use this API for user management:

## Endpoints

- ### `/auth/login` (POST)

This endpoint allows user to login with email and password which appends JWT Bearer token in Authorization header.

**Request Parameters:**

- `email` (required): User email address.
- `password` (required): User password.

**Example Request:**

```http
POST /auth/login
Content-Type: application/json

{
  "email":"test@gmail.com",
  "password" : "12345"
}
```

**Response:**

```http

Authorization:	Bearer token_added_here
X-Content-Type-Options:	nosniff
X-XSS-Protection:	0
Cache-Control:	
no-cache, no-store, max-age=0, must-revalidate
Pragma:	no-cache
Expires:	0
X-Frame-Options:	DENY
Content-Type:	application/json
Transfer-Encoding:	chunked
Date:	
Tue, 14 Nov 2023 19:38:53 GMT-7m 12s
Keep-Alive:	timeout=60
Connection:	keep-alive
```

- ### `/auth/logout` (POST)

This endpoint allows user to logout removing the bearer token from request header.

**Request Parameters:**

- `token` (required): Session bearer token.

**Example Request:**

```http
POST /auth/logout
Content-Type: application/json

{
  "token":"session_bearer_token"
}
```

**Response:**

```http


Authorization:	Bearer
X-Content-Type-Options:	nosniff
X-XSS-Protection:	0
Cache-Control:	
no-cache, no-store, max-age=0, must-revalidate
Pragma:	no-cache
Expires:	0
X-Frame-Options:	DENY
Content-Length:	0 byte
Date:	
Tue, 14 Nov 2023 19:42:35 GMT-18m 50s
Keep-Alive:	timeout=60
Connection:	keep-alive
```
- ### `/auth/validate` (POST)

This endpoint allows to validate the session of a token.

**Request Parameters:**

- `token` (required): Session bearer token.

**Example Request:**

```http
POST /auth/validate
Content-Type: application/json

{
  "token":"session_bearer_token"
}
```

**Response:**

```http


{
    "status": "ENDED"   // ACTIVE | ENDED
}
```

- ### `/auth/signup` (POST)

This endpoint allows user to sign up with below details.

**Request Parameters:**

- `email` (required): User email address.
- `password` (required): User password.
- `phoneNumber` (required): User phoneNumber.
- `name` (required): User name.
- `address` (required): User address.

**Example Request:**

```http
POST /auth/signup
Content-Type: application/json

{
    "email": "test@gmail.com",
    "phoneNumber": "9876543210",
    "password": "12345",
    "name": "Test User",
    "address": "This is address line 123"
}
```

**Response:**

```http
{
    "email": "test@gmail.com",
    "phoneNumber": "9876543210",
    "roles": [],
    "name": "Test User",
    "address": "This is address line 123"
}
```

### `/user/{id}` (GET)

This endpoint fetches user details for the above ID.

**Request Parameters:**
- `id` (required): User id.


**Example Request:**

```http
GET /user/5abdfd4a-2c55-4199-9144-fe9cfda6e4db
```

**Response:**

```http
{
    "email": "test@gmail.com",
    "phoneNumber": "9876543210",
    "roles":[],
    "name": "Test User",
    "address": "This is address line 123"
}
```
- ### `/roles/create` (POST)

Used to .

**Request Parameters:**

- `name` (required): Create a unique role.

**Example Request:**

```http
POST /auth/validate
Content-Type: application/json

{
  "name":"USER"
}
```

**Response:**

```http
{
    "id": "cc3d85a6-818d-410c-b635-7fa6033d6b35",
    "role": "USER"
}
```

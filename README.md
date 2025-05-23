# Microservices Architecture Project

![Java](https://img.shields.io/badge/Java-21-blue)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-green)
![Spring Cloud](https://img.shields.io/badge/Spring_Cloud-2024-brightgreen)


A scalable e-commerce platform built with microservices architecture.

## 📦 Services Overview

| Service           | Description                          | Port  |
|-------------------|--------------------------------------|-------|
| config-service    | Centralized configuration server      | 8888  |
| Eureka-service    | Service registry (Eureka)             | 8761  |
| gateway-service   | API Gateway (Spring Cloud Gateway)    | 8080  |
| Patient-service   | Handles customer data                 | 8081  |
| Payment-service   | Manages product catalog               | 8082  |


## 🛠 Technologies

- *Core*: Java 21, Spring Boot 3.4, Spring Cloud 2024
- *Communication*: OpenFeign (REST), Spring Cloud Gateway (Routing)
- *Infrastructure*: Eureka (Service Discovery), Config Server
- *Database*: MySQL (Relational)
- *Resilience*: Circuit Breaker (Resilience4j)


## 🚀 Quick Start

### Prerequisites

- JDK 21+
- Maven 3.9+
- MySQL 8.0+


### Installation

#### Clone the project
```sh
https://github.com/abdelilahraees/projet-microservices-Docker_MySQL.git

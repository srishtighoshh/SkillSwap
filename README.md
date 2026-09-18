# SkillSwap - Peer-to-Peer Student Skill Exchange Platform

## 1. Overview

SkillSwap is a Java-based peer-to-peer student skill exchange platform. It helps students find other students who can teach skills they want to learn.

The system allows users to register, manage skills, find compatible skill partners, create exchange requests, schedule learning sessions, and provide ratings and feedback.

## 2. Problem Statement

Students often possess useful skills that their peers want to learn, but finding suitable peer mentors can be difficult.

SkillSwap provides a structured platform where students can exchange knowledge by connecting learners with students who can teach the required skills.

## 3. Objectives

- Provide a platform for peer-to-peer skill exchange.
- Allow students to specify skills they can teach and want to learn.
- Find compatible students using skill-based matching.
- Manage exchange requests and learning sessions.
- Collect ratings and feedback after learning sessions.
- Store application data using a relational SQLite database.

## 4. Major Features

1. User Registration and Authentication
2. Skill Management
3. User-Skill Mapping
4. Skill Matching
5. Exchange Requests
6. Learning Session Scheduling
7. Ratings and Feedback
8. SQLite Database Integration

## 5. Technologies Used

- Java 21
- Object-Oriented Programming
- JDBC
- SQLite
- Maven

## 6. Project Structure

```text
SkillSwap/
├── src/
│   └── main/
│       └── java/
│           └── com/
│               └── skillswap/
│                   ├── Main.java
│                   ├── model/
│                   ├── dao/
│                   ├── service/
│                   └── util/
├── database/
│   └── skillswap.db
├── docs/
│   ├── diagrams/
│   └── screenshots/
├── README.md
├── statement.md
└── pom.xml

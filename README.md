# Visitor Log System

A full-stack web application built with **Java Spring Boot** and **React** that allows organizations to log, monitor, and export visitor activity in real-time.

## Features

### Visitor Check-In

* Users can check in visitors by entering their name, phone, and purpose.
* Automatically logs check-in time.

### Visitor Check-Out

* Visitors can be checked out via a button.
* Logs the check-out time.

### Real-Time Log Table

* Displays all visitors with their check-in and check-out times.
* Data auto-refreshes after actions.

### CSV Export

* One-click button to download all visitor data as a CSV file.

## Tech Stack

### Backend

* Java 17
* Spring Boot 3.x
* Spring Data JPA
* H2 In-Memory DB (can be configured for persistence)
* RESTful API Design

### Frontend

* React (Create React App)
* Axios for API communication
* Functional Components + Hooks (useState, useEffect)

## Folder Structure

```
visitor/
├── backend/              # Spring Boot application
│   └── src/main/java/... # Controllers, Models, Repositories
├── visitor-log-ui/       # React frontend application
│   └── src/components/   # VisitorForm.js, VisitorList.js
```

## Setup Instructions

### Backend:

```bash
cd backend
mvn spring-boot:run
```

### Frontend:

```bash
cd visitor-log-ui
npm install
npm start
```

## CSV Export Endpoint

* URL: `GET /api/export/visitors`
* Returns downloadable `.csv` file with all visitor data.

## Live Preview (if deployed)

> *Add your deployment link here if hosting frontend/backend.*

## How to Extend

* Add authentication for admins
* Use MySQL/PostgreSQL for production
* Add date filters, search, pagination
* Deploy to Netlify + Render/Vercel

---
---

> Built in preparation for a technical interview to showcase full-stack development skills with Spring Boot and React.

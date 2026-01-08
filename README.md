# 🚗 Car Rental System

**Simplifying Travel Through Smart Technology**

Developed by **Sanjith MS**, a Final Year B.Tech IT student at Paavai Engineering College. This project is a comprehensive Java-based solution designed to streamline the car rental process, moving away from manual tracking to an automated, efficient system.

---

## 📖 Introduction
Booking a rental car should be easy and reliable, yet manual forms and confusing tracking often lead to frustration. This **Car Rental System** brings everything—browsing, booking, cost calculation, and fleet management—into a single, user-friendly interface. 

Whether you are a customer looking for a quick ride or an admin managing a large fleet, this system is engineered to provide clarity and efficiency.

---

## ✨ Key Features

### 👤 User Features
* **Smart Search:** Browse available cars in real-time.
* **Cost Estimator:** View rental duration and estimated costs instantly.
* **Date Selection:** Choose specific pickup and return dates.
* **Booking Management:** Easily return vehicles or cancel existing bookings.
* **Rental Summary:** Get a detailed receipt of your transaction.

### 🛠️ Admin Features
* **Inventory Management:** Add, update, or delete vehicle listings.
* **Fleet Monitoring:** Track current bookings and vehicle status.
* **Availability Control:** Manually manage car status.
* **Reporting:** Generate rental reports for business insights.

### ✅ System Validations
* **Security:** Proper Vehicle ID and License validation.
* **Conflict Checks:** Automatic booking date and availability verification.
* **Dynamic Pricing:** Automatic calculation based on the number of days.

---

## 🛠 Technology Stack
* **Frontend/UI:** Java (Swing / Console-based)
* **Backend Logic:** Java (Utilizing OOP concepts like Encapsulation and Inheritance)
* **Data Management:** File I/O (Optional Database integration)
* **Tools:** IntelliJ IDEA, Eclipse, Notepad++

---

## 🧠 What I Learned
Developing this project allowed me to strengthen my expertise in:
* **Object-Oriented Programming:** Structuring code for reusability and scalability.
* **DSA Concepts:** Efficiently managing data within the system.
* **Problem Solving:** Handling real-world logic like rental overlap and pricing tiers.
* **System Design:** Creating secure workflows for different user roles (Admin vs. Customer).

---
---

## 🖥️ Output Showcase

To provide a clear understanding of the system's workflow, here is a demonstration of the console-based interface in action.

### 📸 Execution Screenshot

![System Output](https://github.com/user-attachments/assets/52cb08bb-8cdf-4cfc-aab0-6b1749b5098a)

### 🔄 System Workflow Demonstration

1.  **Main Menu:** Upon launching, the user is presented with options to Rent, Return, or access the Admin Dashboard.
2.  **Car Selection:** The system displays a real-time list of available cars, filtered by their current status in the database/file system.
3.  **Customer Details:** The user provides their name and desired rental duration.
4.  **Instant Billing:** The system applies logic to calculate the total price: 
    $$Total = Base Price \times Number of Days$$
5.  **Transaction Completion:** Once confirmed, the car's status is updated to "Rented" to prevent duplicate bookings.

---

## 🛤️ Roadmap: What’s Next?
I plan to continue evolving this system with the following upgrades:
* [ ] **JavaFX GUI:** Moving from a basic UI to an interactive, modern interface.
* [ ] **GPS Integration:** Real-time vehicle tracking simulation.
* [ ] **Authentication:** Secure login/signup for personalized user profiles.
* [ ] **Payment Gateway:** A simulated digital payment gateway for a complete checkout experience.

---

## 🚀 Getting Started
1. **Clone the repo:** `git clone https://github.com/yourusername/car-rental-system.git`
2. **Open in IDE:** Import the project into IntelliJ or Eclipse.
3. **Run:** Execute the `Main.java` file to start the application.

---

**Developed with ❤️ by Sanjith MS**

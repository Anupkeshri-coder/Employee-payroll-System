# 💼 Employee Payroll Management System

![Java](https://img.shields.io/badge/Java-17%2B-orange?style=for-the-badge&logo=java)
![Architecture](https://img.shields.io/badge/Architecture-MVC--Layered-blue?style=for-the-badge)
![Status](https://img.shields.io/badge/Status-Active-brightgreen?style=for-the-badge)
![License](https://img.shields.io/badge/License-MIT-yellow?style=for-the-badge)

A fully functional **console-based Employee Payroll Management System** built using Core Java. It follows a clean layered (MVC-like) architecture and handles everything from employee records to automated payslip generation with Indian tax slab logic.

---

## 📸 Preview

```
════════════════════════════════════════════════════════════════════════════════
  WELCOME TO EMPLOYEE PAYROLL MANAGEMENT SYSTEM
════════════════════════════════════════════════════════════════════════════════
╔══════════════════════════════════╗
║         MAIN MENU                ║
╠══════════════════════════════════╣
║  1. View All Employees           ║
║  2. Add New Employee             ║
║  3. Update Employee              ║
║  4. Delete Employee              ║
║  5. Search Employee by ID        ║
║  6. Filter by Department         ║
║  7. Generate Payslip             ║
║  8. Payroll Summary              ║
║  0. Exit                         ║
╚══════════════════════════════════╝
```

---

## ✨ Features

- 👤 **Employee CRUD** — Add, View, Update, Delete employee records
- 🔍 **Search & Filter** — Search by ID or filter by department
- 🧾 **Payslip Generation** — Auto-calculates all components for any month/year
- 📊 **Payroll Summary** — Company-wide and department-wise salary breakdown
- 🇮🇳 **Indian Tax Logic** — Accurate income tax as per Indian slabs
- 📋 **Pre-loaded Sample Data** — 5 employees ready to test immediately

---

## 🛠️ Tech Stack

| Layer          | Technology                     |
|----------------|--------------------------------|
| Language       | Java 17+                       |
| Architecture   | Layered MVC (Model-Repository-Service-UI) |
| Data Storage   | In-Memory (Java HashMap)       |
| Build Tool     | Manual javac / Maven-ready     |
| IDE Support    | VS Code · IntelliJ IDEA · Eclipse |

---

## 📁 Project Structure

```
EmployeePayrollSystem/
└── src/
    └── main/
        └── java/
            └── com/payroll/
                ├── PayrollApp.java                ← Main entry point & Menu UI
                ├── model/
                │   ├── Employee.java              ← Employee entity class
                │   └── Payslip.java               ← Payslip entity class
                ├── repository/
                │   └── EmployeeRepository.java    ← Data access layer (in-memory DB)
                ├── service/
                │   └── EmployeeService.java       ← Business logic layer
                └── util/
                    ├── PayrollCalculator.java     ← Salary & tax computation engine
                    └── ConsoleDisplay.java        ← Formatted console output
```

---

## 💰 Salary Calculation Logic

### Earnings
| Component          | Calculation       |
|--------------------|-------------------|
| Basic Salary       | As entered        |
| HRA                | 40% of Basic      |
| Dearness Allowance | 20% of Basic      |
| Travel Allowance   | 10% of Basic      |
| Medical Allowance  | 5% of Basic       |
| **Gross Salary**   | Sum of all above  |

### Deductions
| Component        | Calculation            |
|------------------|------------------------|
| Provident Fund   | 12% of Basic           |
| Professional Tax | ₹200/month (fixed)     |
| Income Tax       | As per Indian IT slabs |

### Indian Income Tax Slabs (Annual)
| Annual Income              | Tax Rate |
|----------------------------|----------|
| Up to ₹2,50,000            | 0%       |
| ₹2,50,001 – ₹5,00,000     | 5%       |
| ₹5,00,001 – ₹10,00,000    | 20%      |
| Above ₹10,00,000           | 30%      |

---

## ▶️ How to Run

### Option 1 — VS Code (Recommended)
1. Install [JDK 17+](https://adoptium.net)
2. Install the **Extension Pack for Java** in VS Code
3. Open the `EmployeePayrollSystem` folder in VS Code
4. Open `PayrollApp.java` → Click the **▶ Run** button above `main()`

### Option 2 — Terminal / Command Line
```bash
# Step 1: Compile all Java files
javac -d out src/main/java/com/payroll/model/*.java \
             src/main/java/com/payroll/repository/*.java \
             src/main/java/com/payroll/service/*.java \
             src/main/java/com/payroll/util/*.java \
             src/main/java/com/payroll/PayrollApp.java

# Step 2: Run the application
java -cp out com.payroll.PayrollApp
```

### Option 3 — IntelliJ IDEA
1. `File > Open` → Select `EmployeePayrollSystem` folder
2. Right-click `src/main/java` → Mark as **Sources Root**
3. Right-click `PayrollApp.java` → **Run**

---

## 🧪 Sample Data (Pre-loaded)

| ID | Name          | Department  | Designation        | Basic Salary |
|----|---------------|-------------|--------------------|--------------|
| 1  | Rahul Sharma  | Engineering | Software Developer | ₹55,000      |
| 2  | Priya Nair    | HR          | HR Manager         | ₹65,000      |
| 3  | Amit Patel    | Finance     | Financial Analyst  | ₹60,000      |
| 4  | Sneha Reddy   | Engineering | Senior Developer   | ₹80,000      |
| 5  | Vikram Singh  | Sales       | Sales Executive    | ₹45,000      |

> Try generating a payslip for Employee ID `4` to see the full salary breakdown.

---

## 🔮 Future Enhancements

- [ ] MySQL database integration via JDBC
- [ ] Spring Boot REST API layer
- [ ] PDF payslip export using iText library
- [ ] Swing / JavaFX GUI
- [ ] JWT-based login & authentication
- [ ] Maven build configuration

---

## 🧠 Concepts Used

`Object-Oriented Programming` &nbsp;·&nbsp; `Collections (HashMap, ArrayList)` &nbsp;·&nbsp; `Exception Handling` &nbsp;·&nbsp; `Layered Architecture` &nbsp;·&nbsp; `Static Factory Methods` &nbsp;·&nbsp; `Java Streams` &nbsp;·&nbsp; `Scanner (Console I/O)`

---

## 👨‍💻 Author

**Your Name Here**
- GitHub: [@yourusername](https://github.com/yourusername)
- LinkedIn: [linkedin.com/in/yourprofile](https://linkedin.com/in/yourprofile)

---

## 📄 License

This project is licensed under the [MIT License](LICENSE).

---

> ⭐ If you found this project helpful, please give it a star on GitHub!

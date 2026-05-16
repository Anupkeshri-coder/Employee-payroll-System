# Employee Payroll Management System

A console-based Employee Payroll Management System built with Core Java following
industry-standard layered architecture (Model → Repository → Service → Controller/UI).

---

## 📌 Features

- **Employee Management** — Add, Update, Delete, Search employees
- **Department Filter** — View employees by department
- **Payslip Generation** — Auto-calculates HRA, DA, TA, PF, Income Tax
- **Payroll Summary** — Total salary expense, department-wise breakdown
- **Indian Tax Slabs** — Realistic income tax calculation logic

---

## 🛠️ Tech Stack

| Layer        | Technology              |
|--------------|-------------------------|
| Language     | Java 17+                |
| Architecture | Layered (MVC-like)      |
| Storage      | In-Memory (HashMap)     |
| Build Tool   | Manual / Maven          |
| IDE          | IntelliJ IDEA / Eclipse |

---

## 📁 Project Structure

```
EmployeePayrollSystem/
└── src/main/java/com/payroll/
    ├── PayrollApp.java                  ← Main entry point (UI/Controller)
    ├── model/
    │   ├── Employee.java                ← Employee entity
    │   └── Payslip.java                 ← Payslip entity
    ├── repository/
    │   └── EmployeeRepository.java      ← Data access layer (in-memory DB)
    ├── service/
    │   └── EmployeeService.java         ← Business logic layer
    └── util/
        ├── PayrollCalculator.java       ← Salary & tax computation
        └── ConsoleDisplay.java          ← Formatted console output
```

---

## 💰 Salary Calculation Logic

### Earnings
| Component         | Calculation          |
|-------------------|----------------------|
| Basic Salary      | As entered           |
| HRA               | 40% of Basic         |
| Dearness Allowance| 20% of Basic         |
| Travel Allowance  | 10% of Basic         |
| Medical Allowance | 5% of Basic          |
| **Gross Salary**  | Sum of all above     |

### Deductions
| Component         | Calculation          |
|-------------------|----------------------|
| Provident Fund    | 12% of Basic         |
| Professional Tax  | ₹200 (fixed/month)   |
| Income Tax        | As per Indian slabs  |

### Indian Income Tax Slabs (Annual)
| Income Range         | Tax Rate |
|----------------------|----------|
| Up to ₹2,50,000      | 0%       |
| ₹2,50,001 – ₹5,00,000 | 5%     |
| ₹5,00,001 – ₹10,00,000| 20%    |
| Above ₹10,00,000     | 30%      |

---

## ▶️ How to Run

### Option 1 — Using Terminal
```bash
# Compile
javac -d out src/main/java/com/payroll/**/*.java src/main/java/com/payroll/*.java

# Run
java -cp out com.payroll.PayrollApp
```

### Option 2 — Using IntelliJ IDEA
1. Open IntelliJ → `File > Open` → Select the `EmployeePayrollSystem` folder
2. Mark `src/main/java` as Sources Root
3. Run `PayrollApp.java`

---

## 👤 Sample Data (Pre-loaded)

| ID | Name          | Department  | Designation        | Basic Salary |
|----|---------------|-------------|--------------------|--------------|
| 1  | Rahul Sharma  | Engineering | Software Developer | ₹55,000      |
| 2  | Priya Nair    | HR          | HR Manager         | ₹65,000      |
| 3  | Amit Patel    | Finance     | Financial Analyst  | ₹60,000      |
| 4  | Sneha Reddy   | Engineering | Senior Developer   | ₹80,000      |
| 5  | Vikram Singh  | Sales       | Sales Executive    | ₹45,000      |

---

## 📄 CV Description (Copy-Paste Ready)

**Employee Payroll Management System** | Java, OOP, Collections, Exception Handling

Developed a console-based payroll management system featuring complete employee CRUD
operations, automated salary computation with HRA/DA/TA allowances, Indian income tax
slab calculations, and payslip generation. Implemented a layered MVC-like architecture
(Model, Repository, Service, UI) with in-memory data storage using Java Collections.

---

## 🔮 Future Enhancements

- [ ] MySQL database integration using JDBC
- [ ] Spring Boot REST API conversion
- [ ] PDF payslip generation using iText
- [ ] Swing/JavaFX GUI
- [ ] JWT-based authentication

---

## 👨‍💻 Author

Built for TCS Campus Hiring Portfolio

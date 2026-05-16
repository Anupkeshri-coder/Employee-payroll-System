package com.payroll;

import com.payroll.model.Employee;
import com.payroll.model.Payslip;
import com.payroll.service.EmployeeService;
import com.payroll.util.ConsoleDisplay;

import java.util.*;

public class PayrollApp {

    private static final EmployeeService service = new EmployeeService();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ConsoleDisplay.printHeader("Welcome to Employee Payroll Management System");
        System.out.println("  Company: TechCorp Pvt. Ltd.");

        boolean running = true;
        while (running) {
            printMainMenu();
            int choice = readInt("  Enter your choice: ");

            switch (choice) {
                case 1 -> viewAllEmployees();
                case 2 -> addEmployee();
                case 3 -> updateEmployee();
                case 4 -> deleteEmployee();
                case 5 -> searchEmployee();
                case 6 -> filterByDepartment();
                case 7 -> generatePayslip();
                case 8 -> viewSummary();
                case 0 -> {
                    System.out.println("\n  Thank you for using Payroll System. Goodbye!");
                    running = false;
                }
                default -> ConsoleDisplay.printError("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }

    private static void printMainMenu() {
        System.out.println("\n╔══════════════════════════════════╗");
        System.out.println("║         MAIN MENU                ║");
        System.out.println("╠══════════════════════════════════╣");
        System.out.println("║  1. View All Employees           ║");
        System.out.println("║  2. Add New Employee             ║");
        System.out.println("║  3. Update Employee              ║");
        System.out.println("║  4. Delete Employee              ║");
        System.out.println("║  5. Search Employee by ID        ║");
        System.out.println("║  6. Filter by Department         ║");
        System.out.println("║  7. Generate Payslip             ║");
        System.out.println("║  8. Payroll Summary              ║");
        System.out.println("║  0. Exit                         ║");
        System.out.println("╚══════════════════════════════════╝");
    }

    // ─── 1. View All Employees ────────────────────────────────────────────────
    private static void viewAllEmployees() {
        ConsoleDisplay.printHeader("All Employees");
        List<Employee> employees = service.getAllEmployees();
        ConsoleDisplay.printEmployeeTable(employees);
    }

    // ─── 2. Add Employee ──────────────────────────────────────────────────────
    private static void addEmployee() {
        ConsoleDisplay.printHeader("Add New Employee");
        try {
            System.out.print("  Name          : ");
            String name = scanner.nextLine().trim();

            System.out.print("  Department    : ");
            String dept = scanner.nextLine().trim();

            System.out.print("  Designation   : ");
            String desig = scanner.nextLine().trim();

            double salary = readDouble("  Basic Salary  : ₹");

            System.out.print("  Email         : ");
            String email = scanner.nextLine().trim();

            System.out.print("  Phone         : ");
            String phone = scanner.nextLine().trim();

            System.out.print("  Joining Date  (YYYY-MM-DD): ");
            String doj = scanner.nextLine().trim();

            Employee emp = service.addEmployee(name, dept, desig, salary, email, phone, doj);
            ConsoleDisplay.printSuccess("Employee added successfully! Assigned ID: " + emp.getId());

        } catch (IllegalArgumentException e) {
            ConsoleDisplay.printError(e.getMessage());
        }
    }

    // ─── 3. Update Employee ───────────────────────────────────────────────────
    private static void updateEmployee() {
        ConsoleDisplay.printHeader("Update Employee");
        int id = readInt("  Enter Employee ID to update: ");

        Optional<Employee> existing = service.getEmployeeById(id);
        if (existing.isEmpty()) {
            ConsoleDisplay.printError("Employee with ID " + id + " not found.");
            return;
        }

        Employee emp = existing.get();
        System.out.println("  Current details:");
        ConsoleDisplay.printEmployeeDetails(emp);
        System.out.println("  Enter new details (press Enter to keep current value):");

        try {
            System.out.print("  Name [" + emp.getName() + "]: ");
            String name = scanner.nextLine().trim();
            if (name.isEmpty()) name = emp.getName();

            System.out.print("  Department [" + emp.getDepartment() + "]: ");
            String dept = scanner.nextLine().trim();
            if (dept.isEmpty()) dept = emp.getDepartment();

            System.out.print("  Designation [" + emp.getDesignation() + "]: ");
            String desig = scanner.nextLine().trim();
            if (desig.isEmpty()) desig = emp.getDesignation();

            System.out.print("  Basic Salary [" + emp.getBasicSalary() + "]: ₹");
            String salaryInput = scanner.nextLine().trim();
            double salary = salaryInput.isEmpty() ? emp.getBasicSalary() : Double.parseDouble(salaryInput);

            System.out.print("  Email [" + emp.getEmail() + "]: ");
            String email = scanner.nextLine().trim();
            if (email.isEmpty()) email = emp.getEmail();

            System.out.print("  Phone [" + emp.getPhone() + "]: ");
            String phone = scanner.nextLine().trim();
            if (phone.isEmpty()) phone = emp.getPhone();

            System.out.print("  Joining Date [" + emp.getJoiningDate() + "]: ");
            String doj = scanner.nextLine().trim();
            if (doj.isEmpty()) doj = emp.getJoiningDate();

            service.updateEmployee(id, name, dept, desig, salary, email, phone, doj);
            ConsoleDisplay.printSuccess("Employee ID " + id + " updated successfully!");

        } catch (Exception e) {
            ConsoleDisplay.printError("Update failed: " + e.getMessage());
        }
    }

    // ─── 4. Delete Employee ───────────────────────────────────────────────────
    private static void deleteEmployee() {
        ConsoleDisplay.printHeader("Delete Employee");
        int id = readInt("  Enter Employee ID to delete: ");

        Optional<Employee> emp = service.getEmployeeById(id);
        if (emp.isEmpty()) {
            ConsoleDisplay.printError("Employee with ID " + id + " not found.");
            return;
        }

        System.out.println("  Employee to delete:");
        ConsoleDisplay.printEmployeeDetails(emp.get());
        System.out.print("  Confirm delete? (yes/no): ");
        String confirm = scanner.nextLine().trim();

        if (confirm.equalsIgnoreCase("yes")) {
            service.removeEmployee(id);
            ConsoleDisplay.printSuccess("Employee ID " + id + " deleted successfully.");
        } else {
            System.out.println("  Delete cancelled.");
        }
    }

    // ─── 5. Search Employee ───────────────────────────────────────────────────
    private static void searchEmployee() {
        ConsoleDisplay.printHeader("Search Employee");
        int id = readInt("  Enter Employee ID: ");
        Optional<Employee> emp = service.getEmployeeById(id);

        if (emp.isPresent()) {
            ConsoleDisplay.printEmployeeDetails(emp.get());
        } else {
            ConsoleDisplay.printError("Employee with ID " + id + " not found.");
        }
    }

    // ─── 6. Filter by Department ──────────────────────────────────────────────
    private static void filterByDepartment() {
        ConsoleDisplay.printHeader("Filter by Department");
        System.out.print("  Enter Department name: ");
        String dept = scanner.nextLine().trim();
        List<Employee> employees = service.getEmployeesByDepartment(dept);

        if (employees.isEmpty()) {
            System.out.println("  No employees found in department: " + dept);
        } else {
            System.out.println("  Employees in " + dept + " department:");
            ConsoleDisplay.printEmployeeTable(employees);
        }
    }

    // ─── 7. Generate Payslip ──────────────────────────────────────────────────
    private static void generatePayslip() {
        ConsoleDisplay.printHeader("Generate Payslip");
        int id = readInt("  Enter Employee ID: ");

        String[] months = {"January", "February", "March", "April", "May", "June",
                           "July", "August", "September", "October", "November", "December"};
        System.out.println("  Months: 1-Jan  2-Feb  3-Mar  4-Apr  5-May  6-Jun");
        System.out.println("          7-Jul  8-Aug  9-Sep  10-Oct  11-Nov  12-Dec");
        int monthNum = readInt("  Enter Month (1-12): ");

        if (monthNum < 1 || monthNum > 12) {
            ConsoleDisplay.printError("Invalid month number.");
            return;
        }

        int year = readInt("  Enter Year (e.g. 2024): ");

        try {
            Payslip payslip = service.generatePayslip(id, months[monthNum - 1], year);
            ConsoleDisplay.printPayslip(payslip);
        } catch (IllegalArgumentException e) {
            ConsoleDisplay.printError(e.getMessage());
        }
    }

    // ─── 8. Summary ───────────────────────────────────────────────────────────
    private static void viewSummary() {
        ConsoleDisplay.printHeader("Payroll Summary");
        int total = service.getTotalEmployeeCount();
        double totalSalary = service.getTotalMonthlySalaryExpense();

        System.out.printf("  Total Employees          : %d%n", total);
        System.out.printf("  Total Basic Salary/Month : ₹%.2f%n", totalSalary);
        System.out.printf("  Average Basic Salary     : ₹%.2f%n", total > 0 ? totalSalary / total : 0);

        System.out.println("\n  Department Breakdown:");
        List<String> departments = Arrays.asList("Engineering", "HR", "Finance", "Sales", "Marketing", "Operations");
        for (String dept : departments) {
            List<Employee> deptEmps = service.getEmployeesByDepartment(dept);
            if (!deptEmps.isEmpty()) {
                double deptTotal = deptEmps.stream().mapToDouble(Employee::getBasicSalary).sum();
                System.out.printf("  %-15s : %d employees  |  ₹%.2f/month%n", dept, deptEmps.size(), deptTotal);
            }
        }
    }

    // ─── Helpers ──────────────────────────────────────────────────────────────
    private static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("  Please enter a valid number.");
            }
        }
    }

    private static double readDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Double.parseDouble(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("  Please enter a valid amount.");
            }
        }
    }
}

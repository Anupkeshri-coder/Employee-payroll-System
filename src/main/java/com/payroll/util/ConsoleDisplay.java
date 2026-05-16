package com.payroll.util;

import com.payroll.model.Employee;
import com.payroll.model.Payslip;

import java.util.List;

public class ConsoleDisplay {

    private static final String LINE = "─".repeat(80);
    private static final String DOUBLE_LINE = "═".repeat(80);

    public static void printHeader(String title) {
        System.out.println("\n" + DOUBLE_LINE);
        System.out.printf("  %-76s%n", title.toUpperCase());
        System.out.println(DOUBLE_LINE);
    }

    public static void printEmployeeTable(List<Employee> employees) {
        if (employees.isEmpty()) {
            System.out.println("  No employees found.");
            return;
        }
        System.out.println(LINE);
        System.out.printf("  %-5s %-20s %-15s %-22s %-12s%n",
                "ID", "Name", "Department", "Designation", "Basic Salary");
        System.out.println(LINE);
        for (Employee e : employees) {
            System.out.printf("  %-5d %-20s %-15s %-22s ₹%-11.2f%n",
                    e.getId(), e.getName(), e.getDepartment(), e.getDesignation(), e.getBasicSalary());
        }
        System.out.println(LINE);
    }

    public static void printEmployeeDetails(Employee e) {
        System.out.println(LINE);
        System.out.printf("  Employee ID   : %d%n", e.getId());
        System.out.printf("  Name          : %s%n", e.getName());
        System.out.printf("  Department    : %s%n", e.getDepartment());
        System.out.printf("  Designation   : %s%n", e.getDesignation());
        System.out.printf("  Basic Salary  : ₹%.2f%n", e.getBasicSalary());
        System.out.printf("  Email         : %s%n", e.getEmail());
        System.out.printf("  Phone         : %s%n", e.getPhone());
        System.out.printf("  Joining Date  : %s%n", e.getJoiningDate());
        System.out.println(LINE);
    }

    public static void printPayslip(Payslip p) {
        System.out.println("\n" + DOUBLE_LINE);
        System.out.println("                     EMPLOYEE PAYSLIP");
        System.out.println("                     TechCorp Pvt. Ltd.");
        System.out.println(DOUBLE_LINE);
        System.out.printf("  Employee ID  : %-10d   Month  : %s %d%n",
                p.getEmployeeId(), p.getMonth(), p.getYear());
        System.out.printf("  Name         : %-30s%n", p.getEmployeeName());
        System.out.printf("  Department   : %-20s   Desgn  : %s%n",
                p.getDepartment(), p.getDesignation());
        System.out.println(LINE);

        // Earnings | Deductions side by side
        System.out.printf("  %-38s %-38s%n", "EARNINGS", "DEDUCTIONS");
        System.out.println(LINE);
        System.out.printf("  %-28s ₹%-8.2f   %-22s ₹%-8.2f%n",
                "Basic Salary", p.getBasicSalary(), "Provident Fund (12%)", p.getProvidentFund());
        System.out.printf("  %-28s ₹%-8.2f   %-22s ₹%-8.2f%n",
                "HRA (40%)", p.getHra(), "Professional Tax", p.getProfessionalTax());
        System.out.printf("  %-28s ₹%-8.2f   %-22s ₹%-8.2f%n",
                "DA (20%)", p.getDa(), "Income Tax", p.getIncomeTax());
        System.out.printf("  %-28s ₹%-8.2f%n", "Travel Allowance (10%)", p.getTa());
        System.out.printf("  %-28s ₹%-8.2f%n", "Medical Allowance (5%)", p.getMedicalAllowance());
        System.out.println(LINE);
        System.out.printf("  %-28s ₹%-8.2f   %-22s ₹%-8.2f%n",
                "GROSS SALARY", p.getGrossSalary(), "TOTAL DEDUCTIONS", p.getTotalDeductions());
        System.out.println(DOUBLE_LINE);
        System.out.printf("  NET SALARY PAYABLE : ₹%.2f%n", p.getNetSalary());
        System.out.println(DOUBLE_LINE);
    }

    public static void printSuccess(String message) {
        System.out.println("\n  ✔ " + message);
    }

    public static void printError(String message) {
        System.out.println("\n  ✘ ERROR: " + message);
    }
}

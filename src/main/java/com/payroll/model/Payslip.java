package com.payroll.model;

public class Payslip {
    private int employeeId;
    private String employeeName;
    private String department;
    private String designation;
    private String month;
    private int year;

    // Earnings
    private double basicSalary;
    private double hra;           // House Rent Allowance (40% of basic)
    private double da;            // Dearness Allowance (20% of basic)
    private double ta;            // Travel Allowance (10% of basic)
    private double medicalAllowance; // 5% of basic
    private double grossSalary;

    // Deductions
    private double providentFund; // 12% of basic
    private double professionalTax;
    private double incomeTax;
    private double totalDeductions;

    // Net Pay
    private double netSalary;

    public Payslip() {}

    // Getters and Setters
    public int getEmployeeId() { return employeeId; }
    public void setEmployeeId(int employeeId) { this.employeeId = employeeId; }

    public String getEmployeeName() { return employeeName; }
    public void setEmployeeName(String employeeName) { this.employeeName = employeeName; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public String getDesignation() { return designation; }
    public void setDesignation(String designation) { this.designation = designation; }

    public String getMonth() { return month; }
    public void setMonth(String month) { this.month = month; }

    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }

    public double getBasicSalary() { return basicSalary; }
    public void setBasicSalary(double basicSalary) { this.basicSalary = basicSalary; }

    public double getHra() { return hra; }
    public void setHra(double hra) { this.hra = hra; }

    public double getDa() { return da; }
    public void setDa(double da) { this.da = da; }

    public double getTa() { return ta; }
    public void setTa(double ta) { this.ta = ta; }

    public double getMedicalAllowance() { return medicalAllowance; }
    public void setMedicalAllowance(double medicalAllowance) { this.medicalAllowance = medicalAllowance; }

    public double getGrossSalary() { return grossSalary; }
    public void setGrossSalary(double grossSalary) { this.grossSalary = grossSalary; }

    public double getProvidentFund() { return providentFund; }
    public void setProvidentFund(double providentFund) { this.providentFund = providentFund; }

    public double getProfessionalTax() { return professionalTax; }
    public void setProfessionalTax(double professionalTax) { this.professionalTax = professionalTax; }

    public double getIncomeTax() { return incomeTax; }
    public void setIncomeTax(double incomeTax) { this.incomeTax = incomeTax; }

    public double getTotalDeductions() { return totalDeductions; }
    public void setTotalDeductions(double totalDeductions) { this.totalDeductions = totalDeductions; }

    public double getNetSalary() { return netSalary; }
    public void setNetSalary(double netSalary) { this.netSalary = netSalary; }
}

package com.payroll.model;

public class Employee {
    private int id;
    private String name;
    private String department;
    private String designation;
    private double basicSalary;
    private String email;
    private String phone;
    private String joiningDate;

    public Employee() {}

    public Employee(int id, String name, String department, String designation,
                    double basicSalary, String email, String phone, String joiningDate) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.designation = designation;
        this.basicSalary = basicSalary;
        this.email = email;
        this.phone = phone;
        this.joiningDate = joiningDate;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public String getDesignation() { return designation; }
    public void setDesignation(String designation) { this.designation = designation; }

    public double getBasicSalary() { return basicSalary; }
    public void setBasicSalary(double basicSalary) { this.basicSalary = basicSalary; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getJoiningDate() { return joiningDate; }
    public void setJoiningDate(String joiningDate) { this.joiningDate = joiningDate; }

    @Override
    public String toString() {
        return String.format("Employee{id=%d, name='%s', dept='%s', designation='%s', salary=%.2f}",
                id, name, department, designation, basicSalary);
    }
}

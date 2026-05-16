package com.payroll.service;

import com.payroll.model.Employee;
import com.payroll.model.Payslip;
import com.payroll.repository.EmployeeRepository;
import com.payroll.util.PayrollCalculator;

import java.util.List;
import java.util.Optional;

public class EmployeeService {

    private final EmployeeRepository repository;

    public EmployeeService() {
        this.repository = new EmployeeRepository();
    }

    public Employee addEmployee(String name, String department, String designation,
                                 double basicSalary, String email, String phone, String joiningDate) {
        if (name == null || name.trim().isEmpty()) throw new IllegalArgumentException("Employee name cannot be empty.");
        if (basicSalary <= 0) throw new IllegalArgumentException("Basic salary must be greater than 0.");

        Employee employee = new Employee(0, name.trim(), department.trim(), designation.trim(),
                basicSalary, email.trim(), phone.trim(), joiningDate.trim());
        return repository.save(employee);
    }

    public Employee updateEmployee(int id, String name, String department, String designation,
                                    double basicSalary, String email, String phone, String joiningDate) {
        Optional<Employee> existing = repository.findById(id);
        if (existing.isEmpty()) throw new IllegalArgumentException("Employee with ID " + id + " not found.");

        Employee employee = existing.get();
        employee.setName(name.trim());
        employee.setDepartment(department.trim());
        employee.setDesignation(designation.trim());
        employee.setBasicSalary(basicSalary);
        employee.setEmail(email.trim());
        employee.setPhone(phone.trim());
        employee.setJoiningDate(joiningDate.trim());

        return repository.save(employee);
    }

    public boolean removeEmployee(int id) {
        if (!repository.existsById(id)) throw new IllegalArgumentException("Employee with ID " + id + " not found.");
        return repository.deleteById(id);
    }

    public Optional<Employee> getEmployeeById(int id) {
        return repository.findById(id);
    }

    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    public List<Employee> getEmployeesByDepartment(String department) {
        return repository.findByDepartment(department);
    }

    public Payslip generatePayslip(int employeeId, String month, int year) {
        Optional<Employee> emp = repository.findById(employeeId);
        if (emp.isEmpty()) throw new IllegalArgumentException("Employee with ID " + employeeId + " not found.");
        return PayrollCalculator.generatePayslip(emp.get(), month, year);
    }

    public int getTotalEmployeeCount() {
        return repository.count();
    }

    public double getTotalMonthlySalaryExpense() {
        return repository.findAll().stream()
                .mapToDouble(Employee::getBasicSalary)
                .sum();
    }
}

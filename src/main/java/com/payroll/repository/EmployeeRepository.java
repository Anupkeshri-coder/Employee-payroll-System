package com.payroll.repository;

import com.payroll.model.Employee;
import java.util.*;

public class EmployeeRepository {

    private static final Map<Integer, Employee> employeeDB = new LinkedHashMap<>();
    private static int autoIncrement = 1;

    // Pre-load sample data
    static {
        employeeDB.put(1, new Employee(1, "Rahul Sharma", "Engineering", "Software Developer", 55000, "rahul.sharma@company.com", "9876543210", "2022-01-15"));
        employeeDB.put(2, new Employee(2, "Priya Nair", "HR", "HR Manager", 65000, "priya.nair@company.com", "9876543211", "2021-06-01"));
        employeeDB.put(3, new Employee(3, "Amit Patel", "Finance", "Financial Analyst", 60000, "amit.patel@company.com", "9876543212", "2020-03-20"));
        employeeDB.put(4, new Employee(4, "Sneha Reddy", "Engineering", "Senior Developer", 80000, "sneha.reddy@company.com", "9876543213", "2019-09-10"));
        employeeDB.put(5, new Employee(5, "Vikram Singh", "Sales", "Sales Executive", 45000, "vikram.singh@company.com", "9876543214", "2023-02-28"));
        autoIncrement = 6;
    }

    public Employee save(Employee employee) {
        if (employee.getId() == 0) {
            employee.setId(autoIncrement++);
        }
        employeeDB.put(employee.getId(), employee);
        return employee;
    }

    public Optional<Employee> findById(int id) {
        return Optional.ofNullable(employeeDB.get(id));
    }

    public List<Employee> findAll() {
        return new ArrayList<>(employeeDB.values());
    }

    public List<Employee> findByDepartment(String department) {
        List<Employee> result = new ArrayList<>();
        for (Employee e : employeeDB.values()) {
            if (e.getDepartment().equalsIgnoreCase(department)) {
                result.add(e);
            }
        }
        return result;
    }

    public boolean deleteById(int id) {
        return employeeDB.remove(id) != null;
    }

    public boolean existsById(int id) {
        return employeeDB.containsKey(id);
    }

    public int count() {
        return employeeDB.size();
    }
}

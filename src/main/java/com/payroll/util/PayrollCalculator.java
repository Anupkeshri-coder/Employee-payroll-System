package com.payroll.util;

import com.payroll.model.Employee;
import com.payroll.model.Payslip;

public class PayrollCalculator {

    // Allowance percentages
    private static final double HRA_PERCENT        = 0.40; // 40% of basic
    private static final double DA_PERCENT         = 0.20; // 20% of basic
    private static final double TA_PERCENT         = 0.10; // 10% of basic
    private static final double MEDICAL_PERCENT    = 0.05; // 5% of basic

    // Deduction percentages
    private static final double PF_PERCENT         = 0.12; // 12% of basic
    private static final double PROFESSIONAL_TAX   = 200;  // Fixed Rs. 200/month

    public static Payslip generatePayslip(Employee employee, String month, int year) {
        Payslip payslip = new Payslip();

        // Basic info
        payslip.setEmployeeId(employee.getId());
        payslip.setEmployeeName(employee.getName());
        payslip.setDepartment(employee.getDepartment());
        payslip.setDesignation(employee.getDesignation());
        payslip.setMonth(month);
        payslip.setYear(year);

        double basic = employee.getBasicSalary();
        payslip.setBasicSalary(basic);

        // Calculate Earnings
        double hra     = Math.round(basic * HRA_PERCENT * 100.0) / 100.0;
        double da      = Math.round(basic * DA_PERCENT * 100.0) / 100.0;
        double ta      = Math.round(basic * TA_PERCENT * 100.0) / 100.0;
        double medical = Math.round(basic * MEDICAL_PERCENT * 100.0) / 100.0;

        payslip.setHra(hra);
        payslip.setDa(da);
        payslip.setTa(ta);
        payslip.setMedicalAllowance(medical);

        double gross = basic + hra + da + ta + medical;
        payslip.setGrossSalary(Math.round(gross * 100.0) / 100.0);

        // Calculate Deductions
        double pf = Math.round(basic * PF_PERCENT * 100.0) / 100.0;
        payslip.setProvidentFund(pf);
        payslip.setProfessionalTax(PROFESSIONAL_TAX);

        double incomeTax = calculateIncomeTax(gross * 12) / 12; // Monthly income tax
        incomeTax = Math.round(incomeTax * 100.0) / 100.0;
        payslip.setIncomeTax(incomeTax);

        double totalDeductions = pf + PROFESSIONAL_TAX + incomeTax;
        payslip.setTotalDeductions(Math.round(totalDeductions * 100.0) / 100.0);

        // Net Salary
        double net = gross - totalDeductions;
        payslip.setNetSalary(Math.round(net * 100.0) / 100.0);

        return payslip;
    }

    // Simplified Indian income tax slab (annual)
    private static double calculateIncomeTax(double annualGross) {
        if (annualGross <= 250000) return 0;
        else if (annualGross <= 500000) return (annualGross - 250000) * 0.05;
        else if (annualGross <= 1000000) return 12500 + (annualGross - 500000) * 0.20;
        else return 112500 + (annualGross - 1000000) * 0.30;
    }
}

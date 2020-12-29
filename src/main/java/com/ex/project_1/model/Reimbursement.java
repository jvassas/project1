package com.ex.project_1.model;

import javax.persistence.*;

/**
 * Reimbursement model class using Object Relational Mapping (ORM) to map Java
 * objects to database entities (Hibernate)
 */
@Entity(name="requests")
@Table(name="requests", schema="\"Project_1\"")
public class Reimbursement {

    @Id
    @Column(name="expense_id", columnDefinition="serial primary key")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int expenseId;

    @Column(name="employee_id")
    private int employeeId;

    @Column(name="employee_email")
    private String employeeEmail;


    @Column(name="description")
    private String description;

    @Column(name="amount")
    private long amount;


    @Column(name="approved")
    private boolean approved;

    public Reimbursement() {
    }

    public Reimbursement(int employeeId, String employeeEmail, String description, long amount,  boolean approved) {
        this.employeeId = employeeId;
        this.employeeEmail = employeeEmail;
        this.description = description;
        this.amount = amount;
        this.approved = approved;
    }

    public int getExpenseId() {
        return expenseId;
    }

    public void setExpenseId(int expenseId) {
        this.expenseId = expenseId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    @Override
    public String toString() {
        return "Reimbursement{" +
                "expenseId=" + expenseId +
                ", employeeId=" + employeeId +
                ", employeeEmail='" + employeeEmail + '\'' +
                ", description='" + description + '\'' +
                ", amount=" + amount +
                ", approved=" + approved +
                '}';
    }
}

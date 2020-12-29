package com.ex.project_1.dao;

import com.ex.project_1.model.Reimbursement;

import java.util.List;

/**
 * Interface for Data Access Objects to handle database queries
 * for Reimbursement Requests
 */
public interface ReimbursementDAO {

    public List<Reimbursement> getAllReimbursements();
    public List<Reimbursement> getReimbursementById(int employeeId);
    public List<Reimbursement> getPendingReimbursements();
    public List<Reimbursement> getResolvedReimbursements();
    public List<Reimbursement> getReimbursementByAmount(int amount);



    public boolean addReimbursement(Reimbursement reimbursement);
    public boolean deleteReimbursement(int expenseId);

}

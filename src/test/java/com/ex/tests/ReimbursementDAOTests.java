package com.ex.tests;

import com.ex.project_1.dao.ReimbursementDAOImpl;
import com.ex.project_1.model.Reimbursement;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class ReimbursementDAOTests {

    ReimbursementDAOImpl rDao = new ReimbursementDAOImpl();

    @Test
    public void shouldGetReimbursements() {
        List<Reimbursement> reimbursements = null;
        reimbursements = rDao.getAllReimbursements();
        Assert.assertNotNull(reimbursements);
    }

    @Test
    public void shouldGetReimbursementsById() {
        List<Reimbursement> reimbursements = null;
        reimbursements = rDao.getReimbursementById(14);
        Assert.assertNotNull(reimbursements);
    }

    @Test
    public void shouldGetPendingReimbursements() {
        List<Reimbursement> reimbursements = null;
        reimbursements = rDao.getPendingReimbursements();
        Assert.assertNotNull(reimbursements);
    }

    @Test
    public void shouldGetResolvedReimbursements() {
        List<Reimbursement> reimbursements = null;
        reimbursements = rDao.getResolvedReimbursements();
        Assert.assertNotNull(reimbursements);
    }

    @Test
    public void shouldGetReimbursementsByAmount() {
        List<Reimbursement> reimbursements = null;
        reimbursements = rDao.getReimbursementByAmount(75);
        Assert.assertNotNull(reimbursements);
    }


    @Test
    public void shouldDeleteReimbursement() {
        Assert.assertTrue(rDao.deleteReimbursement(2));
    }

    @Test
    public void shouldAddReimbursementRequest() {
        Assert.assertTrue(rDao.addReimbursement(new Reimbursement(
                1,
                "test@email.com",
                "test description",
                100,
                false

        )));
    }

}

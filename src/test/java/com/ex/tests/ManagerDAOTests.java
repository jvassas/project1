package com.ex.tests;

import com.ex.project_1.dao.ManagerDAOImpl;
import org.junit.Test;

public class ManagerDAOTests {

    ManagerDAOImpl mDao = new ManagerDAOImpl();

    @Test
    public void shouldGetManagerByEmail() {
        mDao.getManagerByEmail("mgr@test.com");
    }

    @Test
    public void shouldAuthenticate() {
        mDao.authenticate("mgr@test.com", "password");
    }
}

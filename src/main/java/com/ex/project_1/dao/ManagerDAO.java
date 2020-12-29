package com.ex.project_1.dao;

import com.ex.project_1.model.Manager;

/**
 * Interface for Data Access Objects to handle database queries
 * for Managers
 */

public interface ManagerDAO {

   public Manager getManagerByEmail(String email);
   public boolean authenticate(String email, String password);
}

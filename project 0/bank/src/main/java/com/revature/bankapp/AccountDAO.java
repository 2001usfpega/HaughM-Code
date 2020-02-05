package com.revature.bankapp;

import java.util.List;

public interface AccountDAO {

    List<Account> findAll();
    List<Account> findByName(String name);
    boolean updateAccount(Account account);
    boolean deleteAccount(Account account);
	List<Account> findById(int id);
	boolean insertAccount(double openingvalue, String user);

}
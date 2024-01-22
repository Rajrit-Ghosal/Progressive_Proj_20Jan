package com.wecp.progressive.dao;


import com.wecp.progressive.entity.Accounts;
<<<<<<< HEAD
=======
import com.wecp.progressive.exception.AccountNotFoundException;
>>>>>>> 8b7fdd6bb3e20280a92e6bcbce26f4bebc1c8b16

import java.util.List;

public interface AccountDAO {
    int addAccount(Accounts accounts);
    Accounts getAccountById(int accountId);
    void updateAccount(Accounts accounts);
    void deleteAccount(int accountId);
    List<Accounts> getAllAccounts();
}
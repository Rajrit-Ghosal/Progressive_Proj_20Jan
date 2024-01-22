package com.wecp.progressive.dao;

import com.wecp.progressive.entity.Transactions;

<<<<<<< HEAD
import java.sql.SQLException;
import java.util.List;
=======
import java.sql.*;
import java.util.*;
>>>>>>> 8b7fdd6bb3e20280a92e6bcbce26f4bebc1c8b16

public interface TransactionDAO {
    int addTransaction(Transactions transaction);
    Transactions getTransactionById(int transactionId);
    void updateTransaction(Transactions transaction);
    void deleteTransaction(int transactionId) ;
    List<Transactions> getAllTransactions();
}

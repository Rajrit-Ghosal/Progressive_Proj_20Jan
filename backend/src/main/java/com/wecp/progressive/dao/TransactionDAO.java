package com.wecp.progressive.dao;

import com.wecp.progressive.entity.Transactions;

import java.sql.*;
import java.util.*;

public interface TransactionDAO {
    int addTransaction(Transactions transaction);
    Transactions getTransactionById(int transactionId);
    void updateTransaction(Transactions transaction);
    void deleteTransaction(int transactionId) ;
    List<Transactions> getAllTransactions();
}

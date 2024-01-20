package com.wecp.progressive.dao;
import java.util.*;

import com.wecp.progressive.config.DatabaseConnectionManager;
import com.wecp.progressive.entity.Accounts;
import com.wecp.progressive.exception.AccountNotFoundException;

import java.sql.*;

public class AccountDAOImpl implements AccountDAO{

    private Connection con;
    public AccountDAOImpl(){
        try{
            con=DatabaseConnectionManager.getConnection();
        }catch(SQLException e)
        {
            e.printStackTrace();
        }
    }

    public int addAccount(Accounts accounts)
    {
        String sql="insert into accounts (customer_id,balance) values (?,?)";
        int count=0;
        try(PreparedStatement pst=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS))
        {
            //Statement.RETURN_GENERATED_KEYS;
            pst.setInt(1,accounts.getCustomer_id());
            pst.setDouble(2, accounts.getBalance());
            count=pst.executeUpdate();

            ResultSet rs=pst.getGeneratedKeys();
            while(rs.next())
            {
                accounts.setAccount_id(rs.getInt(1));
            }
           return count;

        }catch(SQLException e)
        {
            e.printStackTrace();
            
        }
        return 0;

    }


    public Accounts getAccountById(int accountId) throws AccountNotFoundException{ //Problem 11
        String sql="select * from accounts where account_id=?";
        try(PreparedStatement pst=con.prepareStatement(sql)){
            pst.setInt(1,accountId);
            ResultSet rs=pst.executeQuery();

            if(rs.next())
            {
                Accounts ac=new Accounts();
                ac.setAccount_id(rs.getInt(1));
                ac.setCustomer_id(rs.getInt(2));
                ac.setBalance(rs.getDouble(3));
                return ac;

            }
            else{
                throw new AccountNotFoundException("ACCOUNT with ID:"+accountId+"not found!!");
            }

        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public void updateAccount(Accounts accounts){
        String sql="update accounts set customer_id=?,balance=? where account_id=? ";

        try(PreparedStatement pst=con.prepareStatement(sql))
        {
          pst.setInt(1,accounts.getCustomer_id());
          pst.setDouble(2,accounts.getBalance());
          pst.setInt(3,accounts.getAccount_id());
        
          pst.executeUpdate();

         }catch(SQLException e)
        {
            e.printStackTrace();
        }
    }



    public void deleteAccount(int accountId){
        String sql="delete from accounts where account_id=?";
        try(PreparedStatement pst=con.prepareStatement(sql))
        {
            pst.setInt(1,accountId);
            int count=pst.executeUpdate();

        }catch(SQLException e)
        {
            e.printStackTrace();
        }
    }

    public List<Accounts> getAllAccounts(){
        
        
        List<Accounts> aa= new ArrayList<>();
        String sql="select * from accounts";
        try(PreparedStatement pst=con.prepareStatement(sql))
        {
            
            ResultSet rs=pst.executeQuery();
            while(rs.next())
            {
                Accounts acc=new Accounts();
                acc.setAccount_id(rs.getInt(1));
                acc.setCustomer_id(rs.getInt(2));
                acc.setBalance(rs.getDouble(3));
                aa.add(acc);
                return aa;
            }

        }catch(SQLException e)
        {
            e.printStackTrace();
            
        }

        return null;

    }


    public void close()
    {
       // close database connection
       try{
           if(con!=null)
           {
               con.close();
           }
       }catch(SQLException e)
       {
           e.printStackTrace();
       }
   }
}

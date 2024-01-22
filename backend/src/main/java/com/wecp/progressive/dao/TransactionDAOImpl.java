package com.wecp.progressive.dao;
<<<<<<< HEAD


public class TransactionDAOImpl {



=======
import java.util.*;

import com.wecp.progressive.config.DatabaseConnectionManager;
import com.wecp.progressive.entity.Transactions;

import java.sql.*;


public class TransactionDAOImpl implements TransactionDAO {

    private Connection con;

    public TransactionDAOImpl(){
        try {
            con=DatabaseConnectionManager.getConnection();
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
    
    
    
    
    public int addTransaction(Transactions transaction){
        String sql="insert into transactions (account_id,amount,transaction_date,transaction_type) values (?,?,?,?)";
        int count=0;
        try(PreparedStatement pst=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS))
        {
            //Statement.RETURN_GENERATED_KEYS;
            pst.setInt(1,transaction.getAccount_id());
            pst.setDouble(2, transaction.getAmount());
            pst.setDate(3, transaction.getTransaction_date());
            pst.setString(4, transaction.getTransaction_type());
            count=pst.executeUpdate();

            ResultSet rs=pst.getGeneratedKeys();
            while(rs.next())
            {
                transaction.setTransaction_id(rs.getInt(1));
            }
           return count;

        }catch(SQLException e)
        {
            e.printStackTrace();
            
        }
        return 0;


    }
    public Transactions getTransactionById(int transactionId){

        String sql="select * from transactions where transaction_id=?";
        try(PreparedStatement pst=con.prepareStatement(sql)){
            pst.setInt(1,transactionId);
            ResultSet rs=pst.executeQuery();

            if(rs.next())
            {
                Transactions tc=new Transactions();
                tc.setTransaction_id(rs.getInt(1));
                tc.setAccount_id(rs.getInt(2));
                tc.setAmount(rs.getDouble(3));
                tc.setTransaction_date(rs.getDate(4));
                return tc;

            }
         }
        catch(SQLException e)
        {
            e.printStackTrace();
            
        }
        return null;

    }
    public void updateTransaction(Transactions transaction){
        String sql="update accounts set account_id=?,amount=?,transaction_date=?,transaction_type=? where transaction_id=? ";

        try(PreparedStatement pst=con.prepareStatement(sql))
        {
          pst.setInt(1,transaction.getAccount_id());
          pst.setDouble(2,transaction.getAmount());
          pst.setDate(3, transaction.getTransaction_date());
          pst.setString(4, transaction.getTransaction_type());
          pst.setInt(5, transaction.getTransaction_id());
          pst.executeUpdate();

         }catch(SQLException e)
        {
            e.printStackTrace();
        }

    }
   public  void deleteTransaction(int transactionId) {

    String sql="delete from transactions where transaction_id=?";
    try(PreparedStatement pst=con.prepareStatement(sql)){
        pst.setInt(1,transactionId);
        pst.executeUpdate();

     } catch (SQLException e) {
        // TODO: handle exception
        e.printStackTrace();
    }

    }
    public List<Transactions> getAllTransactions(){
        List<Transactions> tt=new ArrayList<>();

        String sql="select * from transactions";
        try(Statement st=con.createStatement())
        {
            ResultSet rs=st.executeQuery(sql);
            
            while(rs.next()){
            Transactions tr=new Transactions();
            tr.setTransaction_id(rs.getInt(1));
            tr.setAmount(rs.getDouble(2));
            tr.setTransaction_date(rs.getDate(3));
            tr.setTransaction_type(rs.getString(4));
            tt.add(tr);

            return tt;
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
>>>>>>> 8b7fdd6bb3e20280a92e6bcbce26f4bebc1c8b16
}

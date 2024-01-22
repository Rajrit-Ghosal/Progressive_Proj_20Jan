package com.wecp.progressive.dao;
<<<<<<< HEAD

public class CustomerDAOImpl {

}
=======
import java.util.*;

import com.wecp.progressive.config.DatabaseConnectionManager;
import com.wecp.progressive.dto.CustomerAccountInfo;
import com.wecp.progressive.entity.Customers;

import java.sql.*;

public class CustomerDAOImpl implements CustomerDAO {

    // private Connection con;

    // public CustomerDAOImpl(){
    //     try {
    //         con=DatabaseConnectionManager.getConnection();
            
    //     } catch (SQLException e) {
    //         // TODO: handle exception
    //         e.printStackTrace();
    //     }
    // }


    // public int addCustomer(Customers customers){
    //     String sql="insert into customers (name,email,username,password,role) values (?,?,?,?,?)";
    //     int count=0;
    //     try(PreparedStatement pst=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS))
    //     {
    //         //Statement.RETURN_GENERATED_KEYS;
    //         pst.setString(1,customers.getName());
    //         pst.setString(2, customers.getEmail());
    //         pst.setString(3, customers.getUsername());
    //         pst.setString(4, customers.getPassword());
    //         pst.setString(5, customers.getRole());
    //         count=pst.executeUpdate();

    //         ResultSet rs=pst.getGeneratedKeys();
    //         while(rs.next())
    //         {
    //             customers.setCustomer_id(rs.getInt(1));
    //         }
    //        return count;

    //     }catch(SQLException e)
    //     {
    //         e.printStackTrace();
            
    //     }
    //     return 0;

    // }
    // public Customers getCustomerById(int customerId){
    //     String sql="select * from accounts where customer_id=?";
    //     try(PreparedStatement pst=con.prepareStatement(sql)){
    //         pst.setInt(1,customerId);
    //         ResultSet rs=pst.executeQuery();

    //         if(rs.next())
    //         {
    //             Customers ac=new Customers();
    //             ac.setCustomer_id(rs.getInt(1));
    //             ac.setName(rs.getString(2));
    //             ac.setEmail(rs.getString(3));
    //             ac.setUsername(rs.getString(4));
    //             ac.setPassword(rs.getString(5));
    //             ac.setRole(rs.getString(6));
    //             return ac;
    //         }
    //     }
    //     catch(SQLException e)
    //     {
    //         e.printStackTrace();
            
    //     }
    //     return null;

    // }
    // public void updateCustomer(Customers customers){
    //     String sql="update customers set name=?,email=?,username=?,password=?,role=? where customer_id=? ";

    //     try(PreparedStatement pst=con.prepareStatement(sql))
    //     {
    //       pst.setString(1,customers.getName());
    //       pst.setString(2,customers.getEmail());
    //       pst.setString(3,customers.getUsername());
    //       pst.setString(4,customers.getPassword());
    //       pst.setString(5,customers.getRole());
    //       pst.setInt(6,customers.getCustomer_id());
           
        
    //       pst.executeUpdate();

    //      }catch(SQLException e)
    //     {
    //         e.printStackTrace();
    //     }

    // }
    // public void deleteCustomer(int customerId){
    //     String sql="delete from customers where customer_id=?";
    //     try(PreparedStatement pst=con.prepareStatement(sql))
    //     {
    //         pst.setInt(1,customerId);
    //         int count=pst.executeUpdate();

    //     }catch(SQLException e)
    //     {
    //         e.printStackTrace();
    //     }

    // }
    // public List<Customers> getAllCustomers(){
    //     List<Customers> aa= new ArrayList<>();
    //     String sql="select * from customers";
    //     try(PreparedStatement pst=con.prepareStatement(sql))
    //     {
            
    //         ResultSet rs=pst.executeQuery();
    //         while(rs.next())
    //         {
    //             Customers acc=new Customers();
    //             acc.setCustomer_id(rs.getInt(1));
    //             acc.setName(rs.getString(2));
    //             acc.setEmail(rs.getString(3));
    //             acc.setUsername(rs.getString(4));
    //             acc.setPassword(rs.getString(5));
    //             acc.setRole(rs.getString(6));
    //             aa.add(acc);
    //             return aa;
    //         }

    //     }catch(SQLException e)
    //     {
    //         e.printStackTrace();
            
    //     }

    //     return null;

    // }
    // public CustomerAccountInfo getCustomerAccountInfo(int customerId){

        
    //     String sql="select * from customers";
    //     try(PreparedStatement pst=con.prepareStatement(sql))
    //     {
            
    //         ResultSet rs=pst.executeQuery();
    //         while(rs.next())
    //         {
    //             CustomerAccountInfo acc=new CustomerAccountInfo();
    //             /*private int customerId;
    // private String customerName;
    // private String email;
    // private int accountId;
    // private double balance; */
    //             acc.setCustomerId(rs.getInt(1));
    //             acc.setCustomerName(rs.getString(2));
    //             acc.setEmail(rs.getString(3));
    //             acc.setAccountId(rs.getInt(4));
    //       b      acc.setBalance(rs.getDouble(5));
    //             //acc.setRole(rs.getString(6));
    //             //aa.add(acc);
    //             return acc;
    //         }

    //     }catch(SQLException e)
    //     {
    //         e.printStackTrace();
            
    //     }

    //     return null;

    // }

    private List<Customers> customers;
    private List<CustomerAccountInfo> accountInfos;

    CustomerDAOImpl() {
        this.customers = new ArrayList<>();
        accountInfos=new ArrayList<>();
    }

    @Override
    public int addCustomer(Customers customer) {
        if(customers.contains(customer))
        {
            return 0;
        }
        else{
        customers.add(customer);
        }

        Collections.sort(customers); // Sort by name after adding
        return 1;
    }

    @Override
    public Customers getCustomerById(int customerId) {
        for (Customers customer : customers) {
            if (customer.getCustomer_id() == customerId) {
                return customer;
            }
        }
        return null; // Customer not found
    }

    @Override
    public void updateCustomer(Customers Customer) {
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getCustomer_id() == Customer.getCustomer_id()) {
                customers.set(i, Customer);
                Collections.sort(customers); // Sort by name after updating
                break;
            }
        }
    }

    @Override
    public void deleteCustomer(int customerId) {
        ListIterator<Customers> lst=customers.listIterator();
        while(lst.hasNext())
        {
            
        }
    }

    @Override
    public List<Customers> getAllCustomers() {
        return new ArrayList<>(customers);
    }

    public CustomerAccountInfo getCustomerAccountInfo(int customerId){
        for (CustomerAccountInfo accountInfo : accountInfos) {
            if (accountInfo.getCustomerId() == customerId) {
                return accountInfo;
            }
        }
        return null; // Customer account info not found
    }
    }
   
    
    


>>>>>>> 8b7fdd6bb3e20280a92e6bcbce26f4bebc1c8b16

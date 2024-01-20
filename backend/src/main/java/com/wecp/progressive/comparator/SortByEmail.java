package com.wecp.progressive.comparator;

import java.util.Comparator;

import com.wecp.progressive.entity.Customers;

public class SortByEmail implements Comparator<Customers>{
    public int compare(Customers c1,Customers c2)
    {
        return c1.getEmail().compareTo(c2.getEmail());
    }

    
    
}

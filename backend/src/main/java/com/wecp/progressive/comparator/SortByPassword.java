package com.wecp.progressive.comparator;

import java.util.Comparator;

import com.wecp.progressive.entity.Customers;

public class SortByPassword implements Comparator<Customers>{

    public int compare(Customers c1,Customers c2)
    {
        return c1.getPassword().compareTo(c2.getPassword());
    }
    
}

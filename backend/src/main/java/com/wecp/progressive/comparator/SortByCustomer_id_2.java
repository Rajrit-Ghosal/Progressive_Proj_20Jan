package com.wecp.progressive.comparator;

import java.util.Comparator;

import com.wecp.progressive.entity.Customers;

public class SortByCustomer_id_2 implements Comparator<Customers> {

    public int compare(Customers c1,Customers c2)
    {
        return c1.getCustomer_id()-c2.getCustomer_id();
    }
}

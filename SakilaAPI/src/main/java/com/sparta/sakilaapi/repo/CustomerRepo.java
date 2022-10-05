package com.sparta.sakilaapi.repo;

import com.sparta.sakilaapi.entity.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerRepo {
    private List<Customer> list = null;
    private static CustomerRepo repo = null;
    public static CustomerRepo getInstance(){
        if(repo == null) {
            repo = new CustomerRepo();
            repo.list = new ArrayList<>();
        }
        return repo;
    }
    private CustomerRepo(){}
    public void add(Customer c){
        list.add(c);
    }

    public Customer get(int index){
        try {
            return list.get(index);
        } catch(IndexOutOfBoundsException e){
            return null;
        }
    }
    public String toString(){
        return list.toString();

    }
    public List<Customer> getList(){
        return list;
    }
}

package com.java.springboot.service;

import java.util.List;

import com.java.springboot.pojo.Customer;

public interface CustomerService {
	List<Customer> findAll();
	
	void delete(int id);
	void addCustomer(Customer customer);
	Customer findId(int id);
	void update(Customer customer);
	List<Customer> selectByLimit(int currentPage,int pageSize,String searchName);
	int getCount();
	
}

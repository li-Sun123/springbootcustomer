package com.java.springboot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.springboot.mapper.CustomerMapper;
import com.java.springboot.pojo.Customer;
import com.java.springboot.pojo.CustomerExample;
import com.java.springboot.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{
	@Autowired
	private CustomerMapper c;
	@Override
	public List<Customer> findAll() {
		CustomerExample example = new CustomerExample();
		List<Customer> list = c.selectByExample(example);
		return list;
	}
	@Override
	public void delete(int id) {
		c.deleteByPrimaryKey(id);
		
	}
	@Override
	public void addCustomer(Customer customer) {
		c.insertSelective(customer);
		
	}
	@Override
	public Customer findId(int id) {
		Customer customer = c.selectByPrimaryKey(id);
		return customer;
	}
	@Override
	public void update(Customer customer) {
		c.updateByPrimaryKey(customer);
		
	}
	@Override
	public List<Customer> selectByLimit(int currentPage, int pageSize,String searchName) {
		
		return c.selectByLimit((currentPage-1)*pageSize, pageSize,searchName);
	}
	@Override
	public int getCount() {
		CustomerExample example = new CustomerExample();
		int count = c.countByExample(example);
		return count;
	}
	

	
}

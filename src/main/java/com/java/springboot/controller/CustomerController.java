package com.java.springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.java.springboot.pojo.Customer;
import com.java.springboot.service.CustomerService;

@RequestMapping("/customerController")
@RestController
public class CustomerController {
	@Autowired
	private CustomerService cs;
	@RequestMapping("/findAll")
	public List<Customer> findAll(){
		
		List<Customer> list = cs.findAll();
		
		return list;
	}
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable("id") int id){
		cs.delete(id);
		return "Delete Success";
	}
	@RequestMapping("/add")
	public String add(Customer customer){
		cs.addCustomer(customer);
		return "Add Success";
		
	}
	@RequestMapping("/getCustomer")
	public Map<String,Object> getCustomer(@RequestParam("currentPage") Integer currentPage , @RequestParam("pageSize")Integer pageSize , @RequestParam("searchName")String searchName){
		List<Customer> list = cs.selectByLimit(currentPage, pageSize,searchName);
		int count = cs.getCount();
		int countPage = count % pageSize == 0?count/pageSize:(count/pageSize)+1;
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("countPage",countPage);
		map.put("list", list);
		
		return map;
		
	}
}

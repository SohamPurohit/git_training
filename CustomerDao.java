package com.cg.customerApp.dao;

import com.cg.customerApp.dto.CustomerDTO;

public interface CustomerDao
{
	String addCustomer(CustomerDTO customer);
	String delCustomer(int customerId);
	String delAllCustomers();
	String updatePhoneNo(int customerId,long customerPhoneNo);
	String fetchAllCustomers();
	String fetchOnName(String customerName);
	String fetchOnId(int customerId);
}

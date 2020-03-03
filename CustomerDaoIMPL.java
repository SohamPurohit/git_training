package com.cg.customerApp.dao;
import java.util.Collection;
import java.util.Scanner;


import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.cg.customerApp.dto.CustomerDTO;

public class CustomerDaoIMPL implements CustomerDao
{
	Scanner sc=new Scanner(System.in);
	CustomerDTO customer=new CustomerDTO();
	Logger logger=Logger.getRootLogger();
	
	
	
	
	public CustomerDaoIMPL() 
	{
		PropertyConfigurator.configure("resource/customerlog.properties");
	}
	@Override
	public String delCustomer(int customerId) 
	{
		
		if(StaticCustomerDB.getCustomerDB().containsKey(customerId)){
			StaticCustomerDB.getCustomerDB().remove(customerId);
			logger.info("Customer deleted");
			return "Customer has been Deleted\n";
		}else{
			logger.info("Customer not Found");
			return "Customer Not Found";
		}	
	}
	
	@Override
	public String delAllCustomers()
	{
		if(StaticCustomerDB.getCustomerDB().isEmpty())
		{
			logger.info("All Customer deleted");
			return "No Customer Records Found";
		}
		else
		{
			StaticCustomerDB.getCustomerDB().clear();
			return "ALL Customers DELETED";
		}		
	}
	@Override
	public String fetchAllCustomers() 
	{
		
		String customer="";
		Collection<CustomerDTO> collection=StaticCustomerDB.getCustomerDB().values();
		if(StaticCustomerDB.getCustomerDB().isEmpty())
		{
			logger.info("All Detials Fetched");
			return "No Customer Records Found" ;
		}
		else
		{
			for(CustomerDTO customer1:collection){
				customer+=customer1.toString();
			}return customer;
			
		}	
	}
	
	
	@Override
	public String fetchOnName(String customerName) 
	{
		int flag=0;
		String customer="";
		Collection<CustomerDTO> collection=StaticCustomerDB.getCustomerDB().values();
		
			for(CustomerDTO customer1:collection){
				if(customer1.getCustomerName().equals(customerName)){
					customer+=customer1.toString();
					logger.info("customer found with name");
					flag=1;
				}
			}
			if(flag==1){
				return customer;
			}else{
				return "No Name Found";
			}
	}
	

	
	
	@Override
	public String updatePhoneNo(int customerId,long customerPhoneNo)
	{
		if(!(StaticCustomerDB.getCustomerDB().containsKey(customerId))){
			return "Customer Not Found";
		}else{
			StaticCustomerDB.getCustomerDB().get(customerId).setCustomerPhoneNo(customerPhoneNo);
			logger.info("Phone number updated");
			return "Phone number updated Successfully";
		}
		
	}

	
	
	
	@Override
	public String addCustomer(CustomerDTO customer) {
		logger.info("New Customer Added");
		StaticCustomerDB.getCustomerDB().put(customer.getCustomerId(), customer);
		return "New Customer Added [Customer ID : "+customer.getCustomerId()+"]";
	}

	@Override
	public String fetchOnId(int customerId) {

		if(StaticCustomerDB.getCustomerDB().containsKey(customerId)){
			logger.info("customer fetched by id");
			return StaticCustomerDB.getCustomerDB().get(customerId).toString();
		}else{
			return "User Not Found";
		}
	}
}

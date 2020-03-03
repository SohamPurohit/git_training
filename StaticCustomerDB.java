package com.cg.customerApp.dao;

import java.util.ArrayList;
import java.util.HashMap;

import com.cg.customerApp.dto.CustomerDTO;

public class StaticCustomerDB
{
	/*private static ArrayList<CustomerDTO> customerDB=new ArrayList<CustomerDTO>();*/
	private static HashMap<Integer,CustomerDTO> customerDB=new HashMap<Integer,CustomerDTO>();
	static
	{
		customerDB.put(101, new CustomerDTO(101,"Shubham",1234123412,"Pune","abc@gmail.com"));	
		customerDB.put(102,new CustomerDTO(102,"Soham",1234435612,"Pune","xyz@gmail.com"));
		customerDB.put(103,new CustomerDTO(103,"Praveen",1234123454,"Bangalore","qwe@gmail.com"));
		customerDB.put(104,new CustomerDTO(104,"Pooja",1234345678,"Chennai","zxc@gmail.com"));
		customerDB.put(105,new CustomerDTO(105,"Om",1341234121,"Mumbai","asd@gmail.com"));
	}
	public static HashMap<Integer, CustomerDTO> getCustomerDB() {
		return customerDB;
	}
	public static void setCustomerDB(HashMap<Integer, CustomerDTO> customerDB) {
		StaticCustomerDB.customerDB = customerDB;
	}

}

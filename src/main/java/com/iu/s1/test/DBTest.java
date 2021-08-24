package com.iu.s1.test;

import java.sql.Connection;

import com.iu.s1.bankbook.BankbookDAO;
import com.iu.s1.bankbook.BankbookDTO;
import com.iu.s1.util.DBConnector;

public class DBTest {
	
	
	public static void main(String[] args) {
		//Test
//		DBConnector dbConnector = new DBConnector();
//		Connection con = dbConnector.getConnect();
//		System.out.println(con);
		
		//BankbookDAO getSelect Test
		BankbookDAO bankbookDAO = new BankbookDAO();
		BankbookDTO bankbookDTO = new BankbookDTO();
		bankbookDTO.setBookNumber(1);
		bankbookDTO = bankbookDAO.getSelect(bankbookDTO);
		
		System.out.println(bankbookDTO.getBookName());
	}
}

package com.iu.s1.bankbook;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.iu.s1.util.DBConnector;

public class BankbookDAO {

	private DBConnector dbConnector;
	
	public BankbookDAO() {
		dbConnector = new DBConnector();
	}
	
	public ArrayList<BankbookDTO> getList() {
		Connection con = dbConnector.getConnect();
		PreparedStatement st = null;
		ResultSet rs = null;
		ArrayList<BankbookDTO> ar = new ArrayList<BankbookDTO>();
		
		String sql= "select * from bankbook";
		
		try {
			st = con.prepareStatement(sql);
			
			rs = st.executeQuery();
			
			while(rs.next()) {
				BankbookDTO bankbookDTO = new BankbookDTO();
				bankbookDTO.setBookNumber(rs.getLong("booknumber"));
				bankbookDTO.setBookName(rs.getString("bookname"));
				bankbookDTO.setBookRate(rs.getDouble("bookrate"));
				bankbookDTO.setBookSale(rs.getInt("booksale"));
				ar.add(bankbookDTO);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dbConnector.disConnect(rs, st, con);
		}
		return ar;
	}
	
	
	
	public BankbookDTO getSelect(BankbookDTO bankbookDTO) {
		
		Connection con = dbConnector.getConnect();
		System.out.println("Con : "+ con);
		PreparedStatement st = null;
		ResultSet rs = null;
		BankbookDTO result = null;
		
		String sql = "SELECT * FROM BANKBOOK WHERE BOOKNUMBER=?";
		
		try {
			st = con.prepareStatement(sql);
			
			st.setLong(1, bankbookDTO.getBookNumber());
			rs = st.executeQuery();
			
			if(rs.next()) {
				result = new BankbookDTO();
				result.setBookNumber(rs.getLong("booknumber"));
				result.setBookName(rs.getString("bookname"));
				result.setBookRate(rs.getDouble("bookrate"));
				result.setBookSale(rs.getInt("booksale"));
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbConnector.disConnect(rs, st, con);
		}
		System.out.println("finish");
		return result;
	}
	
	
	
}

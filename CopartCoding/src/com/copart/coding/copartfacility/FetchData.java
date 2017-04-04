package com.copart.coding.copartfacility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class FetchData {

	public ResultSet getData() throws Exception {
		ResultSet rs = null;
		Connection conn = DatabaseConnection.getConnection();
		
		 PreparedStatement ps = conn.prepareStatement("Select latitude, longitude zipcode from Facility;");
	      rs = ps.executeQuery();
		return rs;
	}
}

package com.capT.jdbc;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SaveOperations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url = "jdbc:postgresql://localhost:5432/EMP";
		String user = "postgres";
		String pass ="root";
		try {
			Class.forName("org.postgresql.Driver");
			System.out.println("Loaded");
			Connection con = DriverManager.getConnection(url,user,pass);
			System.out.println(con);
			Statement stm = con.createStatement();
			stm.execute("insert  into student values(3,'Akku',6.5,1674545678)");
			System.out.println("DATA inserted into student table of EMP");
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

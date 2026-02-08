package com.capT.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteOperations {
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
			stm.execute("DELETE from student where sid=6");
			System.out.println("Record Deleted");
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
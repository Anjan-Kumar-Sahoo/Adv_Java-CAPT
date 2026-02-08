package com.capT.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateOperations {
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
			stm.execute("UPDATE student set name='Aditya', phno='234',cgpa=8.18 where sid=5");
			System.out.println("Record Updated");
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

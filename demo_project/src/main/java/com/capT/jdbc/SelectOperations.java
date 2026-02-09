package com.capT.jdbc;

import java.sql.*;
import java.util.*;

public class SelectOperations {

    public static void main(String[] args) {

        String url = "jdbc:postgresql://localhost:5432/EMP";
        String user = "postgres";
        String pass = "root";
        Scanner sc = new Scanner(System.in);
        String sql="";
        System.out.println("Enter Y to print the table & N to give the sid");
        if(sc.next().toUpperCase().charAt(0) == 'Y')
        	sql = "SELECT * FROM student";
        else
        {
        	sql = "SELECT * FROM student where ";
            System.out.println("Enter sid : ");
        	int sid = sc.nextInt();
        	sql+="sid = "+sid;
        }
        try {
            Class.forName("org.postgresql.Driver");

            Connection con = DriverManager.getConnection(url, user, pass);

            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            ResultSetMetaData meta = rs.getMetaData();
            int columnCount = meta.getColumnCount();

            for (int i = 1; i <= columnCount; i++) {
                System.out.print(meta.getColumnName(i) + "\t");
            }
            System.out.println();

            for (int i = 1; i <= columnCount; i++) {
                System.out.print("--------\t");
            }
            System.out.println();

            while (rs.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    System.out.print(rs.getObject(i) + "\t");
                }
                System.out.println();
            }
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        sc.close();
    }
}

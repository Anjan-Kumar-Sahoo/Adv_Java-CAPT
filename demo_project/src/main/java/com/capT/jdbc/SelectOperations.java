package com.capT.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class SelectOperations {

    public static void main(String[] args) {

        String url = "jdbc:postgresql://localhost:5432/EMP";
        String user = "postgres";
        String pass = "root";

        // 🔁 CHANGE ONLY THIS QUERY
        String sql = "SELECT * FROM student where name='Anjali' or sid=1"; 
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
    }
}

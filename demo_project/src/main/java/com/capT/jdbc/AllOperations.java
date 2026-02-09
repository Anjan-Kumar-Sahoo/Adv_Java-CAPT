package com.capT.jdbc;
import java.sql.*;
import java.util.*;
public class AllOperations {
	private static String url = "jdbc:postgresql://localhost:5432/EMP";
	private static String user = "postgres";
	private static String pass ="root";
	private static Connection con;
	static Scanner sc = new Scanner(System.in);
	static {
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(url,user,pass);			
		} catch (ClassNotFoundException | SQLException  e) {
			e.printStackTrace();
		}
	}
	public static void saveEmployee() throws SQLException{
		PreparedStatement ps = con.prepareStatement("insert into student values(?,?,?,?)");
		System.out.println("Enter SID :");
		ps.setInt(1, sc.nextInt());
		System.out.println("Enter name :");
		ps.setString(2, sc.next()+sc.nextLine());
		System.out.println("Enter CGPS :");
		ps.setDouble(3, sc.nextDouble());
		System.out.println("Enter PhNo :");
		ps.setLong(4, sc.nextLong());
		ps.execute();
		System.out.println("ROW Inserted");
	}
	public static void deleteEMPbyID() throws SQLException
	{
		PreparedStatement ps = con.prepareStatement("DELETE from student where sid=?");
		System.out.println("Enter SID to delete:");
		ps.setInt(1, sc.nextInt());
		ps.execute();
		System.out.println("ROW DELETED");
	}
	public static void updateDetail() throws SQLException
	{
		System.out.println("Enter Col Name to modify = ");
		String cn = sc.next();
		String s = "update student set " + cn + "= ? where sid = ?";
		PreparedStatement ps = con.prepareStatement(s);
		System.out.println("Enter sid - ");
		ps.setInt(2, sc.nextInt());
		System.out.println("Enter value: ");
		if (cn.equals("cgpa"))
		    ps.setDouble(1, sc.nextDouble());
		else if (cn.equals("phno"))
		    ps.setLong(1, sc.nextLong());
		else
		    ps.setString(1, sc.next());
        ps.execute();
		System.out.println("ROW Updated");
	}
	public static void selectEmployee() throws SQLException{
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
	}
	public static void main(String ...args) throws SQLException
	{
		Scanner sc = new Scanner(System.in);
		while(true)
		{
			System.out.println("\n--- EMP DATABASE MENU ---");
	        System.out.println("1. Insert");
	        System.out.println("2. Update");
	        System.out.println("3. Delete");
	        System.out.println("4. Select ");
	        System.out.println("5. Exit");
	        System.out.print("Enter your choice: ");
			int c = sc.nextInt();
			switch(c) {
				case 3: deleteEMPbyID();
						break;
				case 2: updateDetail();
						break;
				case 1: saveEmployee();
						break;
				case 4: selectEmployee();
						break;
				case 5: System.out.println("---Exiting--- Byeeee");
						sc.close();
						System.exit(0);
				default: System.out.println("Wrong Choice");;
			}
		}
	}
}
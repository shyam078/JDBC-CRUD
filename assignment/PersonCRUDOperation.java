package Com.Advance.assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PersonCRUDOperation {
	public static void savePerson(int id,String name,long phone,int age,String email_id,String password)
	{
		String url="jdbc:mysql://localhost:3306?user=root&password=root";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");			
			Connection con =DriverManager.getConnection(url);
			String query="insert into jdbc_tables.persondetails values(?,?,?,?,?,?)";
			 PreparedStatement pstmt=con.prepareStatement(query);
			 pstmt.setInt(1, id);
			 pstmt.setString(2, name);
			 pstmt.setLong(3,phone);
			 pstmt.setInt(4, age);
			 pstmt.setString(5,email_id );
			 pstmt.setString(6, password);
			 pstmt.execute();
			 con.close();
			System.out.println("data inserted");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void getPersonById(int id)
	{
		String url="jdbc:mysql://localhost:3306?user=root&password=root";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con =DriverManager.getConnection(url);
			String query="select * from jdbc_tables.persondetails where id=?";
			 PreparedStatement pstmt=con.prepareStatement(query);
			 pstmt.setInt(1, id);
			ResultSet rs= pstmt.executeQuery();
			while(rs.next())
			{
			System.out.println(rs.getInt(1));
			 System.out.println(rs.getString(2));
			 System.out.println(rs.getLong(3));
			 System.out.println(rs.getInt(4));
			 System.out.println(rs.getString(5));
			 System.out.println(rs.getString(6));
			}
			 pstmt.execute();
			 con.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void getAllPerson()
	{
		String url="jdbc:mysql://localhost:3306?user=root&password=root";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con =DriverManager.getConnection(url);
			 Statement stmt=con.createStatement();
			 String query="select * from jdbc_tables.persondetails";
			 ResultSet rs=stmt.executeQuery(query);
			 while(rs.next()) {
			 System.out.println(rs.getInt(1));
			 System.out.println(rs.getString(2));
			 System.out.println(rs.getLong(3));
			 System.out.println(rs.getInt(4));
			 System.out.println(rs.getString(5));
			 System.out.println(rs.getString(6));
			 }
			 con.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void deletePerson(int id)
	{
		String url="jdbc:mysql://localhost:3306?user=root&password=root";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con =DriverManager.getConnection(url);
			String query="delete from jdbc_tables.persondetails where id=?";
			 PreparedStatement pstmt=con.prepareStatement(query);
			 pstmt.setInt(1, id);
			 pstmt.executeUpdate();
			 con.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void validateByEmail(String email_id,String password)
	{
		String url="jdbc:mysql://localhost:3306?user=root&password=root";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con =DriverManager.getConnection(url);
			String query="select * from jdbc_tables.persondetails where email_id=? and password=?";
			 PreparedStatement pstmt=con.prepareStatement(query);
			 pstmt.setString(1,email_id);
			 pstmt.setString(2, password);
			 ResultSet rs=pstmt.executeQuery();
			 if(rs.next())
			 {
				 System.out.println("present in database");
			 }
			 else
			 {
				 System.out.println("invalid data");
			 }
			 con.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void validateByPhone(long phone,String password)
	{
		String url="jdbc:mysql://localhost:3306?user=root&password=root";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con =DriverManager.getConnection(url);
			String query="select * from jdbc_tables.persondetails where phone=? and password=?";
			 PreparedStatement pstmt=con.prepareStatement(query);
			 pstmt.setLong(1,phone);
			 pstmt.setString(2, password);
			 ResultSet rs=pstmt.executeQuery();
			 if(rs.next())
			 {
				 System.out.println("data present in database");
			 }
			 else
			 {
				 System.out.println("invalid data");
			 }
			 con.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

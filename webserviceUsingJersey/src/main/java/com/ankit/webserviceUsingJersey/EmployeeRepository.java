package com.ankit.webserviceUsingJersey;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmployeeRepository {
	
	List<Employee> elist = new ArrayList<Employee>();
	Connection con = null;
	
	public EmployeeRepository()
	{	
		String url = "jdbc:mysql://localhost:3306/webservice";
		String username = "root";
		String password = "root";
		try
		{	
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url,username,password);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	public List<Employee> doFetch()
	{		
		String sql = "select * from teluskowebservice";
		try
		{
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next())
			{
				Employee e = new Employee();
				e.setName(rs.getString(1));
				e.setDept(rs.getString(2));
				
				elist.add(e);
				Collections.sort(elist);
			}
		}
		catch(Exception e)
		{
			
		}
		return elist;
	}

	public void insertData(Employee em) {
		System.out.println(em.getName()+" inside repo");
		Employee e= new Employee();
		String sql = "insert into teluskowebservice values (?,?)";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, em.getName());
			stmt.setString(2, em.getDept());
			stmt.executeUpdate();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public void viewData()
	{
		for(Employee e:elist)
		{
			System.out.println("name: "+ e.getName()+ " dept: "+e.getDept());
		}
	}

	public Employee fetchParticular(String name) {
		String sql = "select * from teluskowebservice where name = '"+name+"'";
		Employee e = new Employee();
		System.out.println("1");
		try
		{
			System.out.println("2");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next())
			{
				System.out.println("3");
				e.setName(rs.getString(1));
				e.setDept(rs.getString(2));
				System.out.println(e.toString());
				elist.add(e);
			}
		}
		catch(Exception ex)
		{
			
		}
	 return e;
	}
	
	public String updateDetails(Employee emp)
	{
		String sql = "update teluskowebservice set name=? , dept=? where name=?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, emp.getName());
			pstmt.setString(2, emp.getDept());
			pstmt.setString(3, emp.getName());
			pstmt.executeUpdate();
			return "successfully done";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "not successfull";
	}
}

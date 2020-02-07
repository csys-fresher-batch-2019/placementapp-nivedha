package com.trainingproject.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.trainingproject.DbConnection;
import com.trainingproject.dao.ClientCompanyDAO;
import com.trainingproject.model.ClientCompany;

public class ClientCompanyDAOImpl implements ClientCompanyDAO
{

	public void addCompanyDetails(ClientCompany client) throws Exception {
		
		
		String sql = "insert into clientcmpy(client_id,company_name,company_type,company_address,ph_no,contact_person,email_id)values"
				+ "(client_id_seq.nextval,?,?,?,?,?,?)";
		System.out.println("");
		System.out.println("***Add Company Details***");
		System.out.println(sql);
	    try(Connection con=DbConnection.getConnection();PreparedStatement pst=con.prepareStatement(sql);)
	    {
	    pst.setString(1, client.getCompanyName());
	    pst.setString(2, client.getCompanyType());
	    pst.setString(3, client.getCompanyAddress());
	    pst.setLong(4, client.getPhoneNo());
	    pst.setString(5, client.getContactPerson());
	    pst.setString(6, client.getEmailId());
	    int row=pst.executeUpdate();
	    System.out.println(row);	
	    }
	    catch(SQLException e)
		{
	e.printStackTrace();	
		}
	   
	}

	public List<ClientCompany> listCompanyDetails() throws Exception {
		
		List<ClientCompany> list1=new ArrayList<ClientCompany>();
		
		String sql ="select * from clientcmpy";
		System.out.println("");
		System.out.println("***Display All Company Details***");
		System.out.println(sql);
		try(Connection con=DbConnection.getConnection();PreparedStatement stmt=con.prepareStatement(sql);)
		{
			try(ResultSet rs=stmt.executeQuery();)
		
		{
		while(rs.next())
		{
			ClientCompany cc=new ClientCompany();
			cc.setClientId(rs.getInt("client_id"));
			cc.setCompanyName(rs.getString("company_name"));
			cc.setCompanyType(rs.getString("company_type"));
			cc.setCompanyAddress(rs.getString("company_address"));
			cc.setPhoneNo(rs.getLong("ph_no"));
			cc.setContactPerson(rs.getString("contact_person"));
			cc.setEmailId(rs.getString("email_id"));
			list1.add(cc);
		}
		}
		}
		 catch(SQLException e)
		{
	e.printStackTrace();	
		}
		return list1;
	}

	public List<ClientCompany> searchByCompany(String companyName) throws Exception {
		
		List<ClientCompany> list1=new ArrayList<ClientCompany>();
		
		String sql="select client_id,company_name,company_type,company_address,ph_no,contact_person,email_id from clientcmpy where company_name like ?";
		System.out.println("");
		System.out.println("***Display "+companyName+" Company Details***");
		System.out.println(sql);
		try(Connection con=DbConnection.getConnection();PreparedStatement pst=con.prepareStatement(sql);)
		{
		pst.setString(1, "%"+companyName+"%");
		try(ResultSet rs=pst.executeQuery();)
		{
		while(rs.next())
		{
			ClientCompany cc=new ClientCompany();
			cc.setClientId(rs.getInt("client_id"));
			cc.setCompanyName(rs.getString("company_name"));
			cc.setCompanyType(rs.getString("company_type"));
			cc.setCompanyAddress(rs.getString("company_address"));
			cc.setPhoneNo(rs.getLong("ph_no"));
			cc.setContactPerson(rs.getString("contact_person"));
			cc.setEmailId(rs.getString("email_id"));
			list1.add(cc);	
		}
		}
		}
		catch(SQLException e)
		{
	e.printStackTrace();	
		}
		
		return list1;
	}

	public void deleteCompanyDetails(int clientId) throws Exception {
		
		String sql="delete from clientcmpy where client_id=?";
		System.out.println("");
		System.out.println("***Delete Company Details***");
		System.out.println(sql);
		try(Connection con=DbConnection.getConnection();PreparedStatement pst=con.prepareStatement(sql);)
		{
		pst.setInt(1, clientId);
        int row=pst.executeUpdate();
        System.out.println(row);
		}
		catch(SQLException e)
		{
	e.printStackTrace();	
		}
		
	}

	public List<ClientCompany> getCompanyNames() throws Exception {
		
		List<ClientCompany> list1=new ArrayList<ClientCompany>();
		String sql="select company_name from clientcmpy";
		System.out.println("");
		System.out.println("***Display Company Names***");
		System.out.println(sql);
		try(Connection con=DbConnection.getConnection();PreparedStatement stmt=con.prepareStatement(sql);)
		{
		try(ResultSet rs=stmt.executeQuery();)
		{
		
		while(rs.next())
		{
			ClientCompany cc=new ClientCompany();
			cc.setCompanyName(rs.getString("company_name"));
			list1.add(cc);
		}
		}
		}
		catch(SQLException e)
		{
	e.printStackTrace();	
		}
		return list1;
	}

	public int getNoOfCompanies() throws Exception {
		
		String sql="select count(company_name) from clientcmpy";
		System.out.println("");
		System.out.println(sql);
		int a=0;
        try(Connection con=DbConnection.getConnection();PreparedStatement stmt=con.prepareStatement(sql);)
        {
        	try(ResultSet rs=stmt.executeQuery();)
        
        {
		while(rs.next())
		{
			a=rs.getInt("count(company_name)");
		}
        }
        }
        catch(SQLException e)
		{
	e.printStackTrace();	
		}
		return a;
	}

	public void updateCompanyDetails(String companyName, String contactPerson) throws Exception {
		
		 String sql="update clientcmpy set contact_person=? where company_name=?";
		 System.out.println(""); 
		 System.out.println(sql);
	     try(Connection con=DbConnection.getConnection();PreparedStatement pst=con.prepareStatement(sql);)
	     { 
	     pst.setString(1, contactPerson);
	     pst.setString(2, companyName);
	     int row=pst.executeUpdate();
	     }
	     catch(SQLException e)
			{
		e.printStackTrace();	
			}

		
	}

}

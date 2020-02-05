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
		
		Connection con=DbConnection.getConnection();
		String sql = "insert into clientcmpy(client_id,company_name,company_type,company_address,ph_no,contact_person,email_id)values"
				+ "(client_id_seq.nextval,?,?,?,?,?,?)";
		System.out.println("");
		System.out.println("***Add Company Details***");
		System.out.println(sql);
	    PreparedStatement pst=con.prepareStatement(sql);
	    pst.setString(1, client.companyName);
	    pst.setString(2, client.companyType);
	    pst.setString(3, client.companyAddress);
	    pst.setLong(4, client.phoneNo);
	    pst.setString(5, client.contactPerson);
	    pst.setString(6, client.emailId);
	    int row=pst.executeUpdate();
	    System.out.println(row);	
	    con.close();
	}

	public List<ClientCompany> listCompanyDetails() throws Exception {
		
		List<ClientCompany> list1=new ArrayList<ClientCompany>();
		Connection con=DbConnection.getConnection();
		String sql ="select * from clientcmpy";
		System.out.println("");
		System.out.println("***Display All Company Details***");
		System.out.println(sql);
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery(sql);

		while(rs.next())
		{
			ClientCompany cc=new ClientCompany();
			cc.clientId=rs.getInt("client_id");
			cc.companyName=rs.getString("company_name");
			cc.companyType=rs.getString("company_type");
			cc.companyAddress=rs.getString("company_address");
			cc.phoneNo=rs.getLong("ph_no");
			cc.contactPerson=rs.getString("contact_person");
			cc.emailId=rs.getString("email_id");
			list1.add(cc);
		}
		con.close();
		return list1;
	}

	public List<ClientCompany> searchByCompany(String companyName) throws Exception {
		
		List<ClientCompany> list1=new ArrayList<ClientCompany>();
		Connection con=DbConnection.getConnection();
		String sql="select client_id,company_name,company_type,company_address,ph_no,contact_person,email_id from clientcmpy where company_name like ?";
		System.out.println("");
		System.out.println("***Display "+companyName+" Company Details***");
		System.out.println(sql);
		PreparedStatement pst=con.prepareStatement(sql);
		pst.setString(1, "%"+companyName+"%");
		ResultSet rs=pst.executeQuery();
		
		while(rs.next())
		{
			ClientCompany cc=new ClientCompany();
			cc.clientId=rs.getInt("client_id");
			cc.companyName=rs.getString("company_name");
			cc.companyType=rs.getString("company_type");
			cc.companyAddress=rs.getString("company_address");
			cc.phoneNo=rs.getLong("ph_no");
			cc.contactPerson=rs.getString("contact_person");
			cc.emailId=rs.getString("email_id");
			list1.add(cc);	
		}
		con.close();
		return list1;
	}

	public void deleteCompanyDetails(int clientId) throws Exception {
		
		Connection con=DbConnection.getConnection();
		String sql="delete from clientcmpy where client_id=?";
		System.out.println("");
		System.out.println("***Delete Company Details***");
		System.out.println(sql);
		PreparedStatement pst=con.prepareStatement(sql);
		pst.setInt(1, clientId);
        int row=pst.executeUpdate();
        System.out.println(row);
        con.close();
		
	}

	public List<ClientCompany> getCompanyNames() throws Exception {
		
		List<ClientCompany> list1=new ArrayList<ClientCompany>();
		Connection con=DbConnection.getConnection();
		String sql="select company_name from clientcmpy";
		System.out.println("");
		System.out.println("***Display Company Names***");
		System.out.println(sql);
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery(sql);
		
		while(rs.next())
		{
			ClientCompany cc=new ClientCompany();
			cc.companyName=rs.getString("company_name");
			list1.add(cc);
		}
		con.close();
		return list1;
	}

	public int getNoOfCompanies() throws Exception {
		
		Connection con=DbConnection.getConnection();
		String sql="select count(company_name) from clientcmpy";
		System.out.println("");
		
		System.out.println(sql);
        Statement stmt=con.createStatement();
        ResultSet rs=stmt.executeQuery(sql);
        int a=0;
		while(rs.next())
		{
			a=rs.getInt("count(company_name)");
		}
		con.close();
		return a;
	}

	public void updateCompanyDetails(String companyName, String contactPerson) throws Exception {
		
		 Connection con=DbConnection.getConnection();
		 String sql="update clientcmpy set contact_person=? where company_name=?";
		 System.out.println(""); 
		 System.out.println(sql);
	     PreparedStatement pst=con.prepareStatement(sql);
	     pst.setString(1, contactPerson);
	     pst.setString(2, companyName);
	     int row=pst.executeUpdate();
	     System.out.println(row);
	     con.close();
		
	}

}

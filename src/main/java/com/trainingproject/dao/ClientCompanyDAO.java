package com.trainingproject.dao;

import java.util.ArrayList;
import java.util.List;

import com.trainingproject.model.ClientCompany;

public interface ClientCompanyDAO {
	
	void addCompanyDetails(ClientCompany client) throws Exception;
	
	List<ClientCompany> listCompanyDetails() throws Exception;
	
	List<ClientCompany> searchByCompany(String companyName) throws Exception;
	
	void deleteCompanyDetails(int clientId) throws Exception;
	
	List<ClientCompany> getCompanyNames() throws Exception;
	
	int getNoOfCompanies() throws Exception;
	
	void updateCompanyDetails(String companyName,String contactPerson) throws Exception;

}

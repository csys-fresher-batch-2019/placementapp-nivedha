package com.trainingproject.dao;

import java.util.List;

import com.trainingproject.DbException;
import com.trainingproject.model.ClientCompany;

public interface ClientCompanyDAO {

	void addCompanyDetails(ClientCompany client) throws DbException;

	List<ClientCompany> listCompanyDetails() throws DbException;

	List<ClientCompany> searchByCompany(String companyName) throws DbException;

	void deleteCompanyDetails(int clientId) throws DbException;

	List<ClientCompany> getCompanyNames() throws DbException;

	int getNoOfCompanies() throws DbException;

	void updateCompanyDetails(String companyName, String contactPerson) throws DbException;

}

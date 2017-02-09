package com.capgemini.appl.services;

import java.util.List;

import com.capgemini.appl.daos.EmpDaoImpl;
import com.capgemini.appl.daos.IEmpDao;
import com.capgemini.appl.entities.Dept;
import com.capgemini.appl.entities.Emp;
import com.capgemini.appl.exceptions.CustomException;

public class EmpServicesImpl implements IEmpServices
{

	private IEmpDao dao;
	
	public EmpServicesImpl()
	{
		dao = new EmpDaoImpl();
	}
	
	@Override
	public void addNewEmp(Emp emp) throws CustomException
	{
		
		 dao.addNewEmp(emp);
		
	}

	@Override
	public Emp getEmpDetails(int empNo) 
	{
	
		return dao.getEmpDetails(empNo);
	}

	@Override
	public Dept getDeptDetails(int deptNo) throws CustomException 
	{
		
		return dao.getDeptDetails(deptNo);
	}

}

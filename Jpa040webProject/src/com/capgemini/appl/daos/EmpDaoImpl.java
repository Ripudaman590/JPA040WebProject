package com.capgemini.appl.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.capgemini.appl.entities.Dept;
import com.capgemini.appl.entities.Emp;
import com.capgemini.appl.exceptions.CustomException;
import com.capgemini.appl.util.JpaUtil;

public class EmpDaoImpl implements IEmpDao
{

	private EntityManager manager;
	
	
	public EmpDaoImpl()
	{
		super();
		manager = JpaUtil.getEntityManager();
	}
	


	@Override
	public void addNewEmp(Emp emp) throws CustomException
	{
		EntityTransaction trans = manager.getTransaction();
		trans.begin();

		manager.persist(emp);
		
		trans.commit();
		
		
	}



	@Override
	public Emp getEmpDetails(int empNo)
	{
		Emp emp = manager.find(Emp.class, empNo);
		
		return emp;
	}



	@Override
	public Dept getDeptDetails(int deptNo) throws CustomException
	{
		Dept dept  = (Dept) manager.find(Dept.class, deptNo);
		return dept;
	}

}

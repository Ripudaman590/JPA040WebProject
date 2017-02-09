package com.capgemini.appl.services;

import java.util.List;

import com.capgemini.appl.entities.Dept;
import com.capgemini.appl.entities.Emp;
import com.capgemini.appl.exceptions.CustomException;

public interface IEmpServices 
{
		public Emp getEmpDetails(int empNo);
		public void addNewEmp(Emp emp) throws CustomException;
		Dept getDeptDetails(int deptNo) throws CustomException;
	 
}

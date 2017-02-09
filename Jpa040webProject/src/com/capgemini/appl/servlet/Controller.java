package com.capgemini.appl.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.capgemini.appl.entities.Dept;
import com.capgemini.appl.exceptions.CustomException;
import com.capgemini.appl.services.EmpServicesImpl;
import com.capgemini.appl.services.IEmpServices;

@WebServlet("*.do")
public class Controller extends HttpServlet 
{
	
	IEmpServices services = null;
	
	
	@Override
	public void init() throws ServletException
	{
		super.init();
		try 
		{
			services = new EmpServicesImpl();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		try
		{
			Dept dept = services.getDeptDetails(20);
			
			request.setAttribute("deptDetails", dept);
			
			RequestDispatcher dispatch = request.getRequestDispatcher("/ShowDeptDetails.jsp");
			dispatch.forward(request, response);
			
		} 
		catch (CustomException e) 
		{
			RequestDispatcher dispatch = request.getRequestDispatcher("/Error.jsp");
			dispatch.forward(request, response);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
		
	}

}

package com.capgemini.appl.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil 
{

	private static EntityManagerFactory factory;
	
	static
	{
		try
		{
			factory = Persistence.createEntityManagerFactory("JPA-SK");
		} 
		catch (Exception e) 
		{
			
			e.printStackTrace();
		}
		
	}
		public static EntityManager getEntityManager()
		{
			return factory.createEntityManager();
		}
		
		public static void close()
		{
			if (factory != null) 
			{
				factory.close();
				factory = null;
			}
		
		}
	
}

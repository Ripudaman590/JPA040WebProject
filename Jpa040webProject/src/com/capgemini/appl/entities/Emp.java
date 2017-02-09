package com.capgemini.appl.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity(name="employees")
@Table(name="EMP")
@NamedQueries
({
	@NamedQuery(name="listEmpsOfSalRange",query="SELECT e FROM employees e WHERE e.empSal between :pFrom and :pTo"),
	@NamedQuery(name="listAllEmps",query="Select e From employees e")
}
)

@SequenceGenerator(name="emp_generator", sequenceName="seq_emps",allocationSize=1,initialValue=1)
public class Emp 
{

	private int empNo;
	private String empNm;
	private float empSal;
	private Dept dept;
	
	
	
	public Emp(int empNo, String empNm, float empSal, Dept dept) {
		super();
		this.empNo = empNo;
		this.empNm = empNm;
		this.empSal = empSal;
		this.dept = dept;
	}

	public Emp( String empNm, float empSal, Dept dept) 
	{
		super();
		
		this.empNm = empNm;
		this.empSal = empSal;
		this.dept= dept;
	}

	public Emp() 
	{
		super();
	}

	@Id
	@Column(name="EMPNO")
	@GeneratedValue(generator = "emp_generator", strategy=GenerationType.SEQUENCE)
	public int getEmpNo() {    //PropertyName emNo
		return empNo;
	}

	public void setEmpNo(int empNo) { 
		this.empNo = empNo;
	}

	@Column(name="ENAME")
	public String getEmpNm() {
		return empNm;
	}

	public void setEmpNm(String empNm) {
		this.empNm = empNm;
	}

	@Column(name="SAL")
	public float getEmpSal() {
		return empSal;
	}

	public void setEmpSal(float empSal) {
		this.empSal = empSal;
	}

	
	@OneToOne
	@JoinColumn(name="deptNo")
	public Dept getDept() {
		return dept;
	}


	public void setDept(Dept dept) {
		this.dept = dept;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((empNm == null) ? 0 : empNm.hashCode());
		result = prime * result + empNo;
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Emp other = (Emp) obj;
		if (empNm == null) {
			if (other.empNm != null)
				return false;
		} else if (!empNm.equals(other.empNm))
			return false;
		if (empNo != other.empNo)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Emp [empNo=" + empNo + ", empNm=" + empNm + ", empSal="
				+ empSal + ", dept=" + dept + "]";
	}



	
	
	
}

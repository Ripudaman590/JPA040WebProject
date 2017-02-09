package com.capgemini.appl.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity(name="dept")
@Table(name="DEPT")
public class Dept 
{

	private int deptNo;
	private String deptNm;
	private String location;
	
	public Dept()
	{

		
	}

	//Association
	
	private Set<Emp> empList;
	
	public Dept(int deptNo, String deptNm, String location) {
		super();
		this.deptNo = deptNo;
		this.deptNm = deptNm;
		this.location = location;
	}

	@Id
	@Column(name="DEPTNO")
	public int getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}

	@Column(name="DNAME")
	public String getDeptNm() {
		return deptNm;
	}

	public void setDeptNm(String deptNm) {
		this.deptNm = deptNm;
	}

	@Column(name="LOC")
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	

	@OneToMany(mappedBy="dept")  //Name of property which owns and exercises relationship
	public Set<Emp> getEmpList() {
		return empList;
	}

	public void setEmpList(Set<Emp> empList) {
		this.empList = empList;
	}

	@Override
	public String toString() {
		return "Dept [deptNo=" + deptNo + ", deptNm=" + deptNm + ", location="
				+ location + "]";
	}
	
}

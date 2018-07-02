package com.ankit.webserviceUsingJersey;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Employee implements Comparable<Employee>{
	
	private String name;
	private String dept;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	@Override
	public int compareTo(Employee o) {

		return o.getName().compareTo(this.name);
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", dept=" + dept + "]";
	}
		
	
}

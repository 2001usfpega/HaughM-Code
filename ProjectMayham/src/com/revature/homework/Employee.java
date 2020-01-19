package com.revature.homework;

import java.util.Comparator;

public class Employee implements Comparator<Employee>{
	
	private String name;
	private String department;
	private int age;

	Employee(String name, String department, int age){
		this.name = name;
		this.department = department;
		this.age = age;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}

	@Override
	public int compare(Employee o1, Employee o2) {
		if(o1.equals(o2)){
			return 0;
		}
		switch(o1.getName().compareToIgnoreCase(o2.getName())) {
			case 1: return 1;
			case -1: return -1;
			default: break;
		}
		switch(o1.getDepartment().compareToIgnoreCase(o2.getDepartment())) {
			case 1: return 1;
			case -1: return -1;
			default: break;
		}
		return (o1.getAge()>o2.getAge())? 1:-1;
	}
	
	@Override
	public boolean equals(Object o) {
		if(!(o instanceof Employee)){
			return false;
		}
		Employee e = (Employee) o;
		return (e.age==age&&e.getName().equalsIgnoreCase(name)&&e.getDepartment().equalsIgnoreCase(department));
	}
}

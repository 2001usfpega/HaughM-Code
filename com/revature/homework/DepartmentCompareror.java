package com.revature.homework;

class DepartmentCompareror implements Comparator<Employee>{
	@Override
	public int compare(Employee o1, Employee o2) {
		return o1.getDepartment().compareTo(o2.getDepartment());
	}
}

package com.revature.homework;

import java.util.Comparator;

class NameCompareror implements Comparator<Employee>{
	@Override
	public int compare(Employee o1, Employee o2) {
		return o1.getName().compareTo(o2.getName());
	}
}
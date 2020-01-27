package com.revature.homework;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.jupiter.api.Test;

class EmployeeComparisontester {

	@Test
	void test() {
		ArrayList<Employee> actuals= new ArrayList<Employee>();
		actuals.add(new Employee("Alice", "Packing", 30));
		actuals.add(new Employee("Charlie", "Unpacking", 25));
		actuals.add(new Employee("Bob", "Driver", 50));
		ArrayList<Employee> expecteds;
		Collections.sort(actuals, new AgeCompareror());
		
		expecteds = new ArrayList<Employee>();
		expecteds.add(new Employee("Charlie", "Unpacking", 25));
		expecteds.add(new Employee("Alice", "Packing", 30));
		expecteds.add(new Employee("Bob", "Driver", 50));
		
		

		for (int i = 0; i < actuals.size(); i++) {
			assertTrue(expecteds.get(i).equals(actuals.get(i)));
		}
		
		Collections.sort(actuals, new NameCompareror());
		
		expecteds = new ArrayList<Employee>();
		expecteds.add(new Employee("Alice", "Packing", 30));
		expecteds.add(new Employee("Bob", "Driver", 50));
		expecteds.add(new Employee("Charlie", "Unpacking", 25));
		for (int i = 0; i < actuals.size(); i++) {
			assertTrue(expecteds.get(i).equals(actuals.get(i)));
		}
		Collections.sort(actuals, new DepartmentCompareror());
		
		expecteds = new ArrayList<Employee>();
		expecteds.add(new Employee("Bob", "Driver", 50));
		expecteds.add(new Employee("Alice", "Packing", 30));
		expecteds.add(new Employee("Charlie", "Unpacking", 25));
		
		for (int i = 0; i < actuals.size(); i++) {
			assertTrue(expecteds.get(i).equals(actuals.get(i)));
		}
	}

}

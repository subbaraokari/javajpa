package org.simplilearn.services;

import java.util.List;

import org.simplilearn.entities.Emp;

public interface EmployeeService {
	void insert(Emp e);
	void delete(int eno);
	List<Emp> getAll();
	Emp get(int eno);
	void update(int eno,Emp e);
}

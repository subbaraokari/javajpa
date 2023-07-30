package org.simplilearn.services;

import java.util.List;
import java.util.Optional;

import org.simplilearn.entities.Emp;
import org.simplilearn.exceptions.EmployeeNotFoundException;
import org.simplilearn.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService{
	private EmployeeRepository empRepository;
	
	public EmployeeServiceImpl(EmployeeRepository empRepository) {
		super();
		this.empRepository = empRepository;
	}

	@Override
	public void insert(Emp e) {
		empRepository.save(e);
	}

	@Override
	public void delete(int eno) {
		empRepository.deleteById(eno);
	}

	@Override
	public List<Emp> getAll() {
		return empRepository.findAll();
	}

	@Override
	public Emp get(int eno) {
		/*
		 * To avoid null pointer exception
		 */
		Emp e=null;
		Optional<Emp> empOptional=empRepository.findById(eno);
		if(empOptional.isPresent())
		{
			e=empOptional.get();
		}
		else
		{
			throw new EmployeeNotFoundException("Employee not Found");
		}
		return e;
	}

	@Override
	public void update(int eno, Emp e) {
		Emp e1=get(eno);
		e1.setEno(e.getEno());
		e1.setName(e.getName());
		e1.setAddress(e.getAddress());
		empRepository.save(e1);
	}

}

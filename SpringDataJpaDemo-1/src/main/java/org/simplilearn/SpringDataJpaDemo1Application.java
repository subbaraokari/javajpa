package org.simplilearn;

import java.util.List;

import org.simplilearn.entities.Emp;
import org.simplilearn.services.EmployeeService;
import org.simplilearn.services.EmployeeServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringDataJpaDemo1Application {

	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(SpringDataJpaDemo1Application.class, args);
		EmployeeService employeeService=context.getBean("employeeService", EmployeeServiceImpl.class);
		/*
		 * Emp e1=new Emp(); e1.setName("suresh"); e1.setAddress("Chennai"); Emp e2=new
		 * Emp(); e2.setName("Ramesh"); e2.setAddress("Chennai");
		 * employeeService.insert(e1); employeeService.insert(e2)
		 */
		employeeService.getAll().forEach(emp->System.out.println(emp.getEno()+"\t"+emp.getName()+"\t"+emp.getAddress()));
		
		 
	}

}

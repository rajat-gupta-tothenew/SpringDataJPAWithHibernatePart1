package com.SpringDataJPAwithHibernatePart1.Hibernate;

import com.SpringDataJPAwithHibernatePart1.Hibernate.Entity.Employee;
import com.SpringDataJPAwithHibernatePart1.Hibernate.repos.EmployeeRepoPagingAndSorting;
import com.SpringDataJPAwithHibernatePart1.Hibernate.repos.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureTestEntityManager
class HibernateApplicationTests {

	@Autowired
	EmployeeRepoPagingAndSorting employeeRepoPagingAndSorting;
	@Autowired
	EmployeeRepository employeeRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testCreate(){
		Employee e1=new Employee();
		e1.setAge(22);
		e1.setLocation("Rampur");
		e1.setName("Rajat");
		employeeRepository.save(e1);

		Employee e2=new Employee();
		e2.setAge(23);
		e2.setLocation("Bihar");
		e2.setName("Rakesh");
		employeeRepository.save(e2);

		Employee e3=new Employee();
		e3.setAge(24);
		e3.setLocation("Haldwani");
		e3.setName("Kmalesh");
		employeeRepository.save(e3);

		Employee e4=new Employee();
		e4.setAge(25);
		e4.setLocation("Rampur");
		e4.setName("Abhinav");
		employeeRepository.save(e4);

		Employee e5=new Employee();
		e5.setAge(26);
		e5.setLocation("Dehradun");
		e5.setName("Abhilash");
		employeeRepository.save(e5);
	}

	@Test
	public void testUpdate(){
		Employee employee=employeeRepository.findById(1).get();
		employee.setLocation("Saharanpur");
		//employee.setId(2);

		employeeRepository.save(employee);
	}

	@Test
	public void testDelete(){
		if(employeeRepository.existsById(2)){
			employeeRepository.deleteById(2);
		}
	}

	@Test
	public void testRead(){
		Employee employee=employeeRepository.findById(1).get();
		assertEquals("Rajat",employee.getName());

	}

	@Test
	public void testCount(){
		System.out.println("count : " + employeeRepository.count());
	}

	@Test
	public void testFindAllPagingAndSorting(){
		Pageable pageable =  PageRequest.of(0,2, Sort.Direction.DESC,"age");
		employeeRepoPagingAndSorting.findAll(pageable).forEach(p-> System.out.println(p.getAge()));
	}

	@Test
	public void testFinfByName(){
		System.out.println(employeeRepository.findByName("Rajat"));
	}

	@Test
	public void testNameStartWithA() {
		System.out.println(employeeRepository.findByNameLike("%aj%"));
	}

	@Test
	public void findEmplyAgeBetween(){
		List<Employee> employees=employeeRepository.findByAgeBetween(23,25);
			//System.out.println();
		employees.forEach(e -> System.out.println(e));
	}
}

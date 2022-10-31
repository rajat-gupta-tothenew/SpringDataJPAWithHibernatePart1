package com.SpringDataJPAwithHibernatePart1.Hibernate.repos;

import com.SpringDataJPAwithHibernatePart1.Hibernate.Entity.Employee;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee,Integer> {

    Employee findByName(String name);

    Employee findByNameLike(String name);

    List<Employee> findByAgeBetween(int a,int b);
}

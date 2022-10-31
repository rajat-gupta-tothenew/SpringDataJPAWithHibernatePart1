package com.SpringDataJPAwithHibernatePart1.Hibernate.repos;

import com.SpringDataJPAwithHibernatePart1.Hibernate.Entity.Employee;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface EmployeeRepoPagingAndSorting extends PagingAndSortingRepository<Employee, Integer> {
}

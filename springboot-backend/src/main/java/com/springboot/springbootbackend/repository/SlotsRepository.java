package com.springboot.springbootbackend.repository;

import com.springboot.springbootbackend.model.Employee;
import com.springboot.springbootbackend.model.Slots;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SlotsRepository extends JpaRepository<Slots,Long> {
    List<Slots> findByEmployeeListContaining(Employee employee);
}

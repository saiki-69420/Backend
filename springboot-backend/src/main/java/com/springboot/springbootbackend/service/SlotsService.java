package com.springboot.springbootbackend.service;

import com.springboot.springbootbackend.model.Employee;
import com.springboot.springbootbackend.model.Slots;

import java.util.List;

public interface SlotsService {
    Slots saveSlots(Slots slots);
    List<Slots> findSlotsByEmployee(Employee employee);
}

package com.springboot.springbootbackend.service.impl;

import com.springboot.springbootbackend.model.Employee;
import com.springboot.springbootbackend.model.Slots;
import com.springboot.springbootbackend.repository.SlotsRepository;
import com.springboot.springbootbackend.service.SlotsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SlotsServiceimpl implements SlotsService {
    
    private SlotsRepository slotsRepository;
    
    public SlotsServiceimpl(SlotsRepository slotsRepository){
        super();
        this.slotsRepository=slotsRepository;
    }


    @Override
    public Slots saveSlots(Slots slots) {
        return slotsRepository.save(slots);
    }
    @Override
    public List<Slots> findSlotsByEmployee(Employee employee) {
        return slotsRepository.findByEmployeeListContaining(employee);
    }
}

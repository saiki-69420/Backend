package com.springboot.springbootbackend.controller;
import com.springboot.springbootbackend.model.Employee;
import com.springboot.springbootbackend.model.Slots;
import com.springboot.springbootbackend.repository.EmployeeRepository;
import com.springboot.springbootbackend.service.EmployeeService;
import com.springboot.springbootbackend.service.SlotsService;
import com.springboot.springbootbackend.service.impl.EmployeeServiceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class SlotResponse{
    private Slots slot;
    private Set<Employee> elist;

    public Slots getSlot() {
        return slot;
    }

    public void setSlot(Slots slot) {
        this.slot = slot;
    }

    public Set<Employee> getElist() {
        return elist;
    }

    public void setElist(Set<Employee> elist) {
        this.elist = elist;
    }
}
class SlotRequest{
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Set<Integer> getEidlist() {
        return eidlist;
    }

    public void setEidlist(Set<Integer> eidlist) {
        this.eidlist = eidlist;
    }

    private String title;
    private Date date;
    private Set<Integer> eidlist;
}

@RestController
@RequestMapping("/api/slots")
public class SlotsController {

    private SlotsService slotsService;
    @Autowired
    private EmployeeService empServ;
    public SlotsController(SlotsService slotsService) {
        super();
        this.slotsService = slotsService;
    }
    @GetMapping("{employeeId}")
    public ResponseEntity<Set<SlotResponse>> getSlotsByEmployeeId(@PathVariable("employeeId") Long employeeId) {
        Employee employee= empServ.getEmployeeById(employeeId);
        List<Slots> slots = slotsService.findSlotsByEmployee(employee);
        Set<SlotResponse> slotres=new HashSet<SlotResponse>();
        for(Slots s:slots){
            SlotResponse sr=new SlotResponse();
            sr.setSlot(s);
            Set<Employee> elist=s.getEmployeeList();
            sr.setElist(elist);
            slotres.add(sr);
        }
        if (slots.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(slotres);
        }
    }
    @PostMapping()
    public ResponseEntity<Slots> saveSlots(@RequestBody SlotRequest slotsRequest){
        Slots slot=new Slots();
        slot.setDate(slotsRequest.getDate());
        slot.setTitle(slotsRequest.getTitle());

        for(Integer empID:slotsRequest.getEidlist()){
            Employee employee= empServ.getEmployeeById(empID);
            if(employee!=null){
                if(slot.getEmployeeList()==null){
                    slot.setEmployeeList(new HashSet<>());
                }
                slot.getEmployeeList().add(employee);
//                if(employee.getSlots()==null) System.out.println("null hai bhai");
//                else employee.getSlots().add(slot);
            }
        }
        Slots savedSlot=slotsService.saveSlots(slot);

        return new ResponseEntity<>(savedSlot, HttpStatus.CREATED);
    }

}

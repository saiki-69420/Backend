package com.springboot.springbootbackend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.*;

@Data
@Entity
@Table(name = "slots")
public class Slots {


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

    public Set<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(Set<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public int getSlotid() {
        return slotid;
    }

    public void setSlotid(int slotid) {
        this.slotid = slotid;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int slotid;
    @Column (name="title")
    private String title;
    @Column (name="date")
    private Date date; //yyyy-MM-dd

    @JsonBackReference
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name="employee_slot",
            joinColumns = @JoinColumn(name="slot_id",referencedColumnName = "slotid"),
            inverseJoinColumns = @JoinColumn(name="emp_id",referencedColumnName = "id")
    )
    private Set<Employee> employeeList=new HashSet<>();

//    @Override
//    public boolean equals(Object o){
//        if(this==o) return true;
//        if(o==null||getClass()!=o.getClass()) return false;
//        Slots slot=(Slots)o;
//        return Objects.equals(id, slot.id);
//    }
//
//    @Override
//    public int hashCode(){
//        return Objects.hash(id);
//    }
}

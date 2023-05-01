package com.springboot.springbootbackend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Data
@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "first_name",nullable = false)
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email")
    private String email;
    @Column(name = "type")
    private String type;
    @Column(name = "password")
    private String password;

//    @JsonManagedReference
//    @ManyToMany(mappedBy = "employeeList")
//    Set<Slots> slots=new HashSet<>();
//    public Set<Slots> getSlots() {
//        return slots;
//    }
//
//    public void setSlots(Set<Slots> slots) {
//        this.slots = slots;
//    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


//    @Override

//    public boolean equals(Object o){
//        if(this==o) return true;
//        if(o==null||getClass()!=o.getClass()) return false;
//        Employee emp=(Employee) o;
//        return Objects.equals(id, emp.id);
//    }
//
//    @Override
//    public int hashCode(){
//        return Objects.hash(id);
//    }
}

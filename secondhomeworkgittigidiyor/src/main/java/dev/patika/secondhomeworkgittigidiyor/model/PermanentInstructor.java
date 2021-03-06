package dev.patika.secondhomeworkgittigidiyor.model;

import com.fasterxml.jackson.annotation.JsonTypeName;

import javax.persistence.Entity;

@Entity
@JsonTypeName("PermanentInstructor")
public class PermanentInstructor extends Instructor{

    private double fixedSalary;

    public PermanentInstructor(String name, String address, int phoneNumber, double fixedSalary) {
        super(name, address, phoneNumber);
        this.fixedSalary = fixedSalary;
    }

    public PermanentInstructor(double fixedSalary) {
        this.fixedSalary = fixedSalary;
    }

    public PermanentInstructor(){}

    public double getFixedSalary() {
        return fixedSalary;
    }

    public void setFixedSalary(double fixedSalary) {
        this.fixedSalary = fixedSalary;
    }


    @Override
    public String toString() {
        return "PermanentInstructor{" +
                "fixedSalary=" + fixedSalary +
                '}';
    }
}

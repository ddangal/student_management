/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author rowsun
 */
public class Student {
    String name, batch, address, roll, contact, photo,tu_roll,attendance;

    public Student(String roll,String name, String batch, String address, String tu_roll, String contact, String photo,String attendance) {
        this.roll = roll;
        this.name = name;
        this.batch = batch;
        this.address = address;
        this.tu_roll = tu_roll;
        this.contact = contact;
        this.photo = photo;
        this.attendance = attendance;
    }

  
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getAttendance() {
        return attendance;
    }

    public void setAttendance(String attendance) {
        this.attendance = attendance;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRoll() {
        return roll;
    }

    public void setRoll(String roll) {
        this.roll = roll;
    }
    public String getTURoll() {
        return tu_roll;
    }

    public void setTURoll(String roll) {
        this.tu_roll = tu_roll;
    }
    

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
    
    
}

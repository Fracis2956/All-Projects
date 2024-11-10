/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author: Francis Lee Jun Feng
 * @Student ID: 23WMR11560
 */
public class Students implements Serializable {

    private String name;
    private String ID;
    private String email;
    private String phNum;
    private char gender;

    public Students() {
    }

    public Students(String name, String ID, String email, String phNum, char gender) {
        this.name = name;
        this.ID = ID;
        this.email = email;
        this.phNum = phNum;
        this.gender = gender;
    }

    public Students(String name, String ID, char gender) {
        this.ID = ID;
        this.name = name;
        this.gender = gender;
    }

    public Students(String ID) {
        this.ID = ID;
    }

    public Students(char gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhNum() {
        return phNum;
    }

    public void setPhNum(String phNum) {
        this.phNum = phNum;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.ID);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (obj instanceof Students) {
            final Students other = (Students) obj;
            return Objects.equals(this.ID, other.ID);
        }
        return false;
    }

    @Override
    public String toString() {
        return name;
    }

}

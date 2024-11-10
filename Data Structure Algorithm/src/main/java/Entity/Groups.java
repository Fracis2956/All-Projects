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
public class Groups implements Serializable{
    private String groupName;

    public Groups() {
    }
    
    public Groups(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + Objects.hashCode(this.groupName);
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
        if (obj instanceof Groups) {
        final Groups other = (Groups) obj;
        return Objects.equals(this.groupName, other.groupName);
        }
            return false;
    }

    @Override
    public String toString() {
        return groupName;
    }
    
    
    
}

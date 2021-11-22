/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Duy_Do
 */
public class TaskType {
    private int numberId;
    private String IdName;

    public TaskType(int numberId, String IdName) {
        this.numberId = numberId;
        this.IdName = IdName;
    }

    public int getNumberId() {
        return numberId;
    }

    public void setNumberId(int numberId) {
        this.numberId = numberId;
    }

    public String getIdName() {
        return IdName;
    }

    public void setIdName(String IdName) {
        this.IdName = IdName;
    }
    
    public void display(){
        
        System.out.printf("%-5d %-10s\n", getNumberId(), getIdName());   
    }
    
}

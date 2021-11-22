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
public class Task {
    private String id;
    private String requirementName;
    private String taskType;
    private String date;
    private String planFrom;
    private String planTo;
    private String assignee;
    private String reviewer;

    public Task(String id, String requirementName, String taskType ,String date, String planFrom, String planTo, String assignee, String reviewer) {
        this.id = id;
        this.requirementName = requirementName;
        this.taskType = taskType;
        this.date = date;
        this.planFrom = planFrom;
        this.planTo = planTo;
        this.assignee = assignee;
        this.reviewer = reviewer;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRequirementName() {
        return requirementName;
    }

    public void setRequirementName(String requirementName) {
        this.requirementName = requirementName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPlanFrom() {
        return planFrom;
    }

    public void setPlanFrom(String planFrom) {
        this.planFrom = planFrom;
    }

    public String getPlanTo() {
        return planTo;
    }

    public void setPlanTo(String planTo) {
        this.planTo = planTo;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }

    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }
    
    public void display(){
        
        System.out.printf("%-5s %-10s %-10s %-15s %-13.1f  %-15s %-10s\n", getId(), getRequirementName(), getTaskType(), getDate(), (Double.parseDouble(getPlanTo()) - Double.parseDouble(getPlanFrom())), getAssignee(), getReviewer() );   
        
        
    }
    
    
}

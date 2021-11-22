/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Controller.TaskManagement;
import java.util.LinkedList;
import model.TaskType;
import model.Task;
import util.Validation;

/**
 *
 * @author Duy_Do
 */
public class Menu {

    private TaskManagement cabinet = new TaskManagement();

    public void addID() {

        cabinet.addId("Code");
        cabinet.addId("Test");
        cabinet.addId("Design");
        cabinet.addId("Review");

    }

    public void addTask() {

        String temp;
        String taskType;

        while (true) {
            taskType = Validation.getStringRegex("TaskType: ", "\\d+", "Can't be empty!", "Can't contains any letters!");
            temp = cabinet.getTaskType(taskType);
            if (temp.isEmpty() || temp.length() == 0) {
                System.out.println("Please enter the ID in the list!");
            } else {
                break;
            }

        }

        taskType = temp;
        String requeName = Validation.getString("Requirement Name: ", "Can't be empty!");

        // ^(1[0-2]|0[1-9])/(3[01]|[12][0-9]|0[1-9])/[0-9]{4}$   => ^(3[01] | [12][0-9])-(1[0-2]0[1-9])-[0-9]{4}$)
        String date;
        while (true) {
            date = Validation.getStringRegex("Date: ", "^(3[01]|[12][0-9]|0[1-9])-(1[0-2]|0[1-9])-[0-9]{4}$", "Can't be empty!", "Following the form: dd-MM-yyyy");

            if (check(date) == false) {
                System.out.println("This day isn't exist!");
            } else {
                break;
            }

        }

        String planFrom;
        String planTo;
        while (true) {

            planFrom = Validation.getStringRegex("PlanFrom: ", "^[0-9]+[.]?[0|5]+$", "Can't be empty!", "Can't cantains any letters and must enter double number!");
            planTo = Validation.getStringRegex("PlanTo: ", "^[0-9]+[.]?[0|5]+$", "Can't be empty!", "Can't cantains any letters and must enter double number!");

            int check = cabinet.checkPlan(planFrom, planTo);

            if (check == 1) {
                System.out.println("PlanFrom must less than PlanTo!");
            } else if (check == 2) {
                System.out.println("PlanFrom and PlanTo must in range[8h - 17.5h]!");
            } else {
                break;
            }

        }

        String assignee = Validation.getString("Assignee: ", "Can't be empty!");

        String reviewer = Validation.getString("Reviewer: ", "Can't be empty!");

        cabinet.addTask(requeName, taskType, date, planFrom, planTo, assignee, reviewer);
        System.out.println("Add task successfully!");

    }

    public void delete() {

        String id = Validation.getStringRegex("Id: ", "\\d+", "Can't be empty!", "Id can't contains any letters!");
        int index = cabinet.searchById(id);

        if (index == -1) {
            System.out.println("NOT FOUND!");
            return;
        }

        cabinet.delete(index);
        System.out.println("Delete successfully!");

    }

    public boolean check(String date) {

        String[] a = date.split("-");

        if (a[1].equalsIgnoreCase("02")) {
            if (a[0].equalsIgnoreCase("30")) {
                return false;
            }

        }

        return true;

    }

    public void showTask() {

        LinkedList<Task> sc = new LinkedList();
        sc = cabinet.getTask();
        System.out.println("ID    Name       TaskType       Date        Time         Assignee          Reviewer    ");
        for (int i = 0; i < sc.size(); i++) {
            sc.get(i).display();
        }

    }

    public void showTaskType() {

        LinkedList<TaskType> sc = new LinkedList();
        sc = cabinet.getTaskType();
        System.out.println("ID    TaskType    ");
        for (int i = 0; i < sc.size(); i++) {
            sc.get(i).display();
        }

        System.out.println("");
    }

    public void displayF() {

        System.out.println("1. Add Task");
        System.out.println("2. Delete Task");
        System.out.println("3. Show Task");
        System.out.println("4. Exits!");

    }

}

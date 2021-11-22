package Controller;

import java.util.LinkedList;
import model.TaskType;
import model.Task;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Duy_Do
 */
public class TaskManagement {

    private LinkedList<Task> listTask = new LinkedList<>();
    private LinkedList<TaskType> listId = new LinkedList<>();
    private static int id1 = 1;
    private static int id2 = 1;

    public void addId(String taskType) {

        listId.add(new TaskType(id1, taskType));
        id1++;

    }

    public void addTask(String requeName, String taskType, String date, String planFrom, String planTo, String assignee, String reviewer) {
        String temp = String.valueOf(id2);
        listTask.add(new Task(temp, requeName, taskType, date, planFrom, planTo, assignee, reviewer));
        id2++;

    }

    public void delete(int index) {

        listTask.remove(index);

    }

   

    public int searchById(String id) {

        int index = -1;

        for (int i = 0; i < listTask.size(); i++) {
            if (listTask.get(i).getId().equalsIgnoreCase(id)) {
                index = i;
            }
        }

        return index;

    }

    public String getTaskType(String string) {

        int a = Integer.parseInt(string);

        String temp = "";
        for (int i = 0; i < listId.size(); i++) {
            if (listId.get(i).getNumberId() == a) {
                temp = listId.get(i).getIdName();
            }
        }

        return temp;

    }

    public int checkPlan(String planFrom, String planTo) {

        Double from = Double.parseDouble(planFrom);
        Double to = Double.parseDouble(planTo);

        if (from >= to) {
            return 1;
        } else if (from < 8.0 || to > 17.5) {
            return 2;
        } else {
            return 0;
        }

    }
    
     public LinkedList getTask() {

        return listTask;

    }

    public LinkedList getTaskType() {

        return listId;

    }

}

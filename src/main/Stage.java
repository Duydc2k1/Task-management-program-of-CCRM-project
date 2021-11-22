/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import Controller.TaskManagement;
import model.TaskType;
import model.Task;
import util.Validation;
import view.Menu;

/**
 *
 * @author Duy_Do
 */
public class Stage {

    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.addID();
        int getchoice;

        while (true) {
            menu.displayF();
            getchoice = Validation.getInteger("Enter your choice: ", "Must be an integer!");

            switch (getchoice) {
                case 1:
                    menu.showTaskType();
                    menu.addTask();
                    break;
                case 2:
                    menu.delete();
                    break;
                case 3:
                    menu.showTask();
                    break;
                case 4:
                    return;

            }

        }

    }
}

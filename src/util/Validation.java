/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.Scanner;

/**
 *
 * @author Duy_Do
 */
public class Validation {

    private static Scanner sc = new Scanner(System.in);

    public static String getString(String msg, String error1) {

        String a;

        while (true) {
            System.out.print(msg);
            a = sc.nextLine();
            if (a.isEmpty() || a.length() == 0) {
                System.out.println(error1);
            } else {
                return a;
            }
        }

    }

    public static String getStringRegex(String msg, String regex, String error1, String error2) {
        String a;
        boolean match;

        while (true) {
            System.out.print(msg);
            a = sc.nextLine();
            match = a.matches(regex);

            if (a.isEmpty() || a.length() == 0) {
                System.out.println(error1);
            } else if (match == false) {
                System.out.println(error2);
            } else {
                return a;
            }

        }

    }

    public static int getInteger(String msg, String error1) {

        int a;

        while (true) {

            try {
                System.out.print(msg);

                a = Integer.parseInt(sc.nextLine());
                return a;
            } catch (Exception e) {
                System.out.println(error1);
            }

        }

    }
    
   
    
    
    
    
    

}

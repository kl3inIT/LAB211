/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package j1.s.p0068;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Admin
 */
public class Manager {

    private final ArrayList<Student> studentList = new ArrayList<>();

    public void inputStudentInformation() {
        while (true) {
            System.out.println("Please input student information");
            String name = Validation.getString("Name: ", "Student name is required.");
            String classes = Validation.getString("Classes: ", "Student class is required.");
            double mark = Validation.getADouble("Mark: ", "Student mark is from 1 to 100.", 0, 100);
            studentList.add(new Student(name, classes, mark));
            if (!Validation.getChoice("Do you want to enter more student information?(Y/N): ",
                    "Please input Y(Yes) or N(No).", "Y", "N")) {
                break;
            }
        }
    }
    
    public void display() {
        Collections.sort(studentList);
        for (int i = 0; i < studentList.size(); i++) {
            System.out.println("-------------Student " + i + "-------------");
            System.out.println("Name: " + studentList.get(i).getName());
            System.out.println("Classes: " + studentList.get(i).getClasses());
            System.out.println("Mark: " + studentList.get(i).getMark());
        }
    }
}

package controller;

import ui.Menu;
import util.Validation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import model.Student;

public class Manager {

    private final ArrayList<Student> studentList = new ArrayList<>();

    public void createNewStudent() {
        do {
            System.out.println("You are preparing to input a new student profile");
            String id = Validation.getID("Input student ID(HAxxxxxx, HExxxxxx, HSxxxxxx): ",
                    "The format of id is HAXXXXXX, HEXXXXXX, HSXXXXXX", "H[ASE]\\d{6}");

            Student existingStudent = findStudentObjectByID(id);
            if (existingStudent != null) {
                System.out.println("The student ID is already exist."
                        + "You can add more courses for this student.");
                if (Validation.getChoice("Do you want to add another course for this student (Y/N)?: ",
                        "Please input y/Y or n/N", "Y", "N")) {
                    addCourse(existingStudent);
                }
            } else {
                String studentName = Validation.getString("Input Student name: ",
                        "The student name is required!");
                int semester = Validation.getAnInteger("Input Student semester(1 -> 9): ",
                        "Semester is from 1 to 9", 1, 9);
                Student student = new Student(id, studentName, semester);
                studentList.add(student);
                addCourse(student);
                System.out.println("Student profile is added successfully");
            }

            System.out.println("------------------------------------");
            if (studentList.size() < 2) {
                System.out.println("You need to create at least 10 students");
            } else {
                if (!Validation.getChoice("Do you want to continue (Y/N)?: ",
                        "Please input y/Y or n/N", "Y", "N")) {
                    break;
                }
            }
        } while (true);
    }

    private Student findStudentObjectByID(String id) {
        if (studentList.isEmpty()) {
            return null;
        }
        for (Student student : studentList) {
            if (student.getId().equalsIgnoreCase(id)) {
                return student;
            }
        }
        return null;
    }

    private void addCourse(Student student) {
        String courseName = Validation.getCourse();
        student.addCourse(courseName);
    }

    public void findAndSort() {
        if (studentList.isEmpty()) {
            System.err.println("List Student is empty. Nothing to find!!");
            return;
        }

        ArrayList<Student> foundStudents = findListStudentByName();
        if (foundStudents.isEmpty()) {
            System.out.println("Not found!!");
            return;
        }
        Collections.sort(foundStudents);
        System.out.println("Here is list student that you want to find");
        String header = String.format("%-20s|%-8s|%-5s", "Student name",
                "Semester", "Course Name");
        System.out.println(header);
        for (Student student : foundStudents) {
            student.print();
        }
    }

    private ArrayList<Student> findListStudentByName() {
        ArrayList<Student> listStudentFindByName = new ArrayList<>();
        String name = Validation.getString("Input student name or part of student name to search: ",
                "Student name is required");
        for (Student student : studentList) {
            if (student.getStudentName().toUpperCase().contains(name.toUpperCase())) {
                listStudentFindByName.add(student);
            }
        }
        return listStudentFindByName;
    }

    public void updateOrDelete() {
        if (studentList.isEmpty()) {
            System.err.println("List Student is empty. Nothing to find!!");
            return;
        }

        String id = Validation.getID("Input student ID(HAxxxxxx, HExxxxxx, HSxxxxxx) to find: ",
                "The format of id is SXXX (HAxxxxxx, HExxxxxx, HSxxxxxx)", "H[ASE]\\d{6}");

        Student student = findStudentObjectByID(id);

        if (student == null) {
            System.out.println("Not found!!");
            return;
        }

        System.out.println("------------------------------------");
        System.out.println("Here is the student information that you want to Update or Delete");
        student.print();

        if (Validation.getChoice("Do you want to update (U) or delete (D) student?: ",
                "Please input u/U or d/D", "U", "D")) {

            Menu menu = new Menu("What information do you want to update?");
            menu.addNewOption("1. Update Student Name");
            menu.addNewOption("2. Update Semester");
            menu.addNewOption("3. Update Student Course");
            menu.addNewOption("4. Completing updated student information");

            int choice;
            do {
                menu.printMenu();
                choice = menu.getChoice();

                switch (choice) {
                    case 1:
                        String newName = Validation.getString("Input new student name: ",
                                "Student name is required");
                        student.setStudentName(newName);
                        System.out.println("Student name updated successfully!");
                        break;

                    case 2:
                        int newSemester = Validation.getAnInteger("Input new student semester(1 -> 9): ",
                                "Semester is from 1 to 9", 1, 9);
                        student.setSemester(newSemester);
                        System.out.println("Student semester updated successfully!");
                        break;

                    case 3:
                        if (Validation.getChoice("Do you want to add (A) or delete (D) a course?: ",
                                "Please input a/A to add or d/D to delete", "A", "D")) {

                            String newCourse = Validation.getCourse();
                            student.addCourse(newCourse);
                            System.out.println("Course " + newCourse + " added successfully!");

                        } else {
                            String deleteCourse = Validation.getCourse();
                            student.deleteCourse(deleteCourse);
                        }
                        break;

                    case 4:
                        System.out.println("The student info is updated successfully!");
                        break;
                }
            } while (choice != 4);

        } else {
            if (Validation.getChoice("Are you sure you want to delete this student (Y/N)?: ",
                    "Please input y/Y or n/N", "Y", "N")) {
                studentList.remove(student);
                System.out.println("The selected student is removed successfully!");
            } else {
                System.out.println("Deletion cancelled");
            }
        }
    }

    public void report() {
        if (studentList.isEmpty()) {
            System.err.println("The student list is empty. Nothing to report!");
            return;
        }

        System.out.printf("%-20s|%-12s|%-5s\n", "Student name", "Course", "Total");

        for (Student student : studentList) {
            HashMap<String, Integer> courseCountMap = new HashMap<>();

            for (String course : student.getCourses()) {
                courseCountMap.put(course, courseCountMap.getOrDefault(course, 0) + 1);
            }

            for (Map.Entry<String, Integer> entry : courseCountMap.entrySet()) {
                System.out.printf("%-20s|%-12s|%-5d\n", student.getStudentName(), entry.getKey(), entry.getValue());
            }
        }
    }
}

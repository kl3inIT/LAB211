package model;

import java.util.ArrayList;

public class Student implements Comparable<Student> {

    private final String id;
    private String studentName;
    private int semester;
    private final ArrayList<String> courses;

    public Student(String id, String studentName, int semester) {
        this.id = id;
        this.studentName = studentName;
        this.semester = semester;
        this.courses = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public ArrayList<String> getCourses() {
        return courses;
    }

    public void addCourse(String courseName) {
        this.courses.add(courseName);
    }

    public void deleteCourse(String courseName) {
        if (courses.contains(courseName.toUpperCase())) {
            courses.remove(courseName);
            System.out.println("Course " + courseName + " removed successfully!");
        } else {
            System.out.println("Course " + courseName + " not found!");
        }
    }

    @Override
    public int compareTo(Student that) {
        return this.studentName.compareTo(that.studentName);
    }

    public void print() {
        for (String course : courses) {
            System.out.printf("%-20s|%-8s|%-12s\n", studentName, semester, course);
        }
    }
}

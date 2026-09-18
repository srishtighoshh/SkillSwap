
package com.skillswap.model;

public class Student extends User {

    private String department;
    private int year;

    public Student(int userId, String name, String email, String password,
                   String department, int year) {

        super(userId, name, email, password);
        this.department = department;
        this.year = year;
    }

    public String getDepartment() {
        return department;
    }

    public int getYear() {
        return year;
    }

    @Override
    public void displayProfile() {
        System.out.println("Student Profile");
        System.out.println("Name: " + getName());
        System.out.println("Email: " + getEmail());
        System.out.println("Department: " + department);
        System.out.println("Year: " + year);
    }
}

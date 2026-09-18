
package com.skillswap.model;

public class Admin extends User {

    private String adminRole;

    public Admin(int userId, String name, String email, String password,
                 String adminRole) {

        super(userId, name, email, password);
        this.adminRole = adminRole;
    }

    public String getAdminRole() {
        return adminRole;
    }

    @Override
    public void displayProfile() {
        System.out.println("Admin Profile");
        System.out.println("Name: " + getName());
        System.out.println("Email: " + getEmail());
        System.out.println("Role: " + adminRole);
    }
}

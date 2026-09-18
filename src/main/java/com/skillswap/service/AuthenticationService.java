
package com.skillswap.service;

import com.skillswap.dao.UserDAO;

public class AuthenticationService {

    private final UserDAO userDAO;

    public AuthenticationService() {
        userDAO = new UserDAO();
    }

    public boolean register(String name, String email,
                            String password, String role) {

        if (name == null || name.isBlank()) {
            System.out.println("Name cannot be empty.");
            return false;
        }

        if (email == null || !email.contains("@")) {
            System.out.println("Please enter a valid email.");
            return false;
        }

        if (password == null || password.length() < 6) {
            System.out.println("Password must contain at least 6 characters.");
            return false;
        }

        return userDAO.registerUser(name, email, password, role);
    }

    public boolean login(String email, String password) {

        if (email == null || password == null) {
            return false;
        }

        return userDAO.loginUser(email, password);
    }
}

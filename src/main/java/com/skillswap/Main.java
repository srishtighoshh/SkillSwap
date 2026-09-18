package com.skillswap;

import com.skillswap.dao.*;
import com.skillswap.service.*;
import com.skillswap.util.DatabaseInitializer;

public class Main {

    public static void main(String[] args) {

        System.out.println("==============================================");
        System.out.println("                 SKILLSWAP");
        System.out.println("        Student Skill Exchange Platform");
        System.out.println("==============================================");

        // Initialize database
        DatabaseInitializer.initialize();

        AuthenticationService authService = new AuthenticationService();
        SkillDAO skillDAO = new SkillDAO();
        UserSkillDAO userSkillDAO = new UserSkillDAO();
        RequestDAO requestDAO = new RequestDAO();
        SessionService sessionService = new SessionService();
        RatingDAO ratingDAO = new RatingDAO();
        MatchingService matchingService = new MatchingService();

        // =========================================
        // 1. USER REGISTRATION & LOGIN
        // =========================================

        System.out.println("\n========== 1. USER MANAGEMENT ==========");

        authService.register(
                "Aarav",
                "aarav@skillswap.com",
                "aarav123",
                "STUDENT"
        );

        authService.register(
                "Riya",
                "riya@skillswap.com",
                "riya123",
                "STUDENT"
        );

        boolean login = authService.login(
                "aarav@skillswap.com",
                "aarav123"
        );

        System.out.println(
                "Aarav Login: " + (login ? "SUCCESS" : "FAILED")
        );

        // =========================================
        // 2. SKILL MANAGEMENT
        // =========================================

        System.out.println("\n========== 2. SKILL MANAGEMENT ==========");

        skillDAO.addSkill(
                "Java Programming",
                "Programming",
                "Object-oriented Java programming"
        );

        skillDAO.addSkill(
                "Graphic Design",
                "Design",
                "Digital design and visual communication"
        );

        skillDAO.addSkill(
                "Python",
                "Programming",
                "Python programming and problem solving"
        );

        skillDAO.displayAllSkills();

        // =========================================
        // 3. USER-SKILL MAPPING
        // =========================================

        System.out.println("\n========== 3. USER SKILLS ==========");

        // Aarav teaches Java
        userSkillDAO.addUserSkill(1, 1, "TEACH");

        // Aarav wants to learn Graphic Design
        userSkillDAO.addUserSkill(1, 2, "LEARN");

        // Riya teaches Graphic Design
        userSkillDAO.addUserSkill(2, 2, "TEACH");

        // Riya wants to learn Java
        userSkillDAO.addUserSkill(2, 1, "LEARN");

        System.out.println("User skills added successfully.");

        // =========================================
        // 4. SKILL MATCHING
        // =========================================

        System.out.println("\n========== 4. SKILL MATCHING ==========");

        System.out.println("Matches for Aarav:");
        matchingService.findMatches(1);

        // =========================================
        // 5. EXCHANGE REQUEST
        // =========================================

        System.out.println("\n========== 5. EXCHANGE REQUEST ==========");

        requestDAO.createRequest(1, 2);

        System.out.println("Skill exchange request created.");
        requestDAO.displayRequests();

        // =========================================
        // 6. LEARNING SESSION
        // =========================================

        System.out.println("\n========== 6. LEARNING SESSION ==========");

        sessionService.scheduleSession(
                2,
                1,
                2,
                "2026-09-20 18:00"
        );

        System.out.println("Learning session scheduled.");
        sessionService.showSessions();

        // =========================================
        // 7. RATING & FEEDBACK
        // =========================================

        System.out.println("\n========== 7. RATING & FEEDBACK ==========");

        ratingDAO.addRating(
                1,
                1,
                5,
                "Excellent teaching session!"
        );

        System.out.println("Rating submitted successfully.");

        // =========================================
        // FINAL RESULT
        // =========================================

        System.out.println("\n==============================================");
        System.out.println("       SKILLSWAP DEMO COMPLETED SUCCESSFULLY");
        System.out.println("==============================================");

        System.out.println("\nModules demonstrated:");
        System.out.println("✓ User Registration & Authentication");
        System.out.println("✓ Skill Management");
        System.out.println("✓ User-Skill Mapping");
        System.out.println("✓ Skill Matching");
        System.out.println("✓ Exchange Requests");
        System.out.println("✓ Learning Sessions");
        System.out.println("✓ Ratings & Feedback");
        System.out.println("✓ SQLite Database Integration");
    }
}

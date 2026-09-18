
package com.skillswap.util;

import java.sql.Connection;
import java.sql.Statement;

public class DatabaseInitializer {

    public static void initialize() {

        String usersTable = """
                CREATE TABLE IF NOT EXISTS users (
                    user_id INTEGER PRIMARY KEY AUTOINCREMENT,
                    name TEXT NOT NULL,
                    email TEXT UNIQUE NOT NULL,
                    password TEXT NOT NULL,
                    role TEXT NOT NULL
                )
                """;

        String skillsTable = """
                CREATE TABLE IF NOT EXISTS skills (
                    skill_id INTEGER PRIMARY KEY AUTOINCREMENT,
                    skill_name TEXT NOT NULL,
                    category TEXT NOT NULL,
                    description TEXT
                )
                """;

        String userSkillsTable = """
                CREATE TABLE IF NOT EXISTS user_skills (
                    user_id INTEGER,
                    skill_id INTEGER,
                    skill_type TEXT NOT NULL,
                    PRIMARY KEY (user_id, skill_id, skill_type),
                    FOREIGN KEY (user_id) REFERENCES users(user_id),
                    FOREIGN KEY (skill_id) REFERENCES skills(skill_id)
                )
                """;

        String requestsTable = """
                CREATE TABLE IF NOT EXISTS skill_requests (
                    request_id INTEGER PRIMARY KEY AUTOINCREMENT,
                    requester_id INTEGER NOT NULL,
                    skill_id INTEGER NOT NULL,
                    status TEXT NOT NULL,
                    FOREIGN KEY (requester_id) REFERENCES users(user_id),
                    FOREIGN KEY (skill_id) REFERENCES skills(skill_id)
                )
                """;

        String sessionsTable = """
                CREATE TABLE IF NOT EXISTS sessions (
                    session_id INTEGER PRIMARY KEY AUTOINCREMENT,
                    teacher_id INTEGER NOT NULL,
                    learner_id INTEGER NOT NULL,
                    skill_id INTEGER NOT NULL,
                    session_date TEXT NOT NULL,
                    status TEXT NOT NULL,
                    FOREIGN KEY (teacher_id) REFERENCES users(user_id),
                    FOREIGN KEY (learner_id) REFERENCES users(user_id),
                    FOREIGN KEY (skill_id) REFERENCES skills(skill_id)
                )
                """;

        String ratingsTable = """
                CREATE TABLE IF NOT EXISTS ratings (
                    rating_id INTEGER PRIMARY KEY AUTOINCREMENT,
                    session_id INTEGER NOT NULL,
                    reviewer_id INTEGER NOT NULL,
                    rating INTEGER NOT NULL,
                    feedback TEXT,
                    FOREIGN KEY (session_id) REFERENCES sessions(session_id),
                    FOREIGN KEY (reviewer_id) REFERENCES users(user_id)
                )
                """;

        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement()) {

            statement.execute("PRAGMA foreign_keys = ON");

            statement.execute(usersTable);
            statement.execute(skillsTable);
            statement.execute(userSkillsTable);
            statement.execute(requestsTable);
            statement.execute(sessionsTable);
            statement.execute(ratingsTable);

            System.out.println(
                    "All SkillSwap database tables initialized successfully."
            );

        } catch (Exception e) {
            System.out.println(
                    "Database initialization failed: " + e.getMessage()
            );
        }
    }
}

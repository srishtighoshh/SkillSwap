
package com.skillswap.dao;

import com.skillswap.util.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SessionDAO {

    public boolean createSession(int teacherId, int learnerId,
                                 int skillId, String sessionDate) {

        String sql = """
                INSERT INTO sessions
                (teacher_id, learner_id, skill_id, session_date, status)
                VALUES (?, ?, ?, ?, ?)
                """;

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, teacherId);
            statement.setInt(2, learnerId);
            statement.setInt(3, skillId);
            statement.setString(4, sessionDate);
            statement.setString(5, "SCHEDULED");

            statement.executeUpdate();

            return true;

        } catch (Exception e) {
            System.out.println("Failed to create session: " + e.getMessage());
            return false;
        }
    }

    public void displaySessions() {

        String sql = "SELECT * FROM sessions";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            System.out.println("\n========== LEARNING SESSIONS ==========");

            while (resultSet.next()) {

                System.out.println(
                        "Session ID: " + resultSet.getInt("session_id") +
                        " | Teacher: " + resultSet.getInt("teacher_id") +
                        " | Learner: " + resultSet.getInt("learner_id") +
                        " | Skill: " + resultSet.getInt("skill_id") +
                        " | Date: " + resultSet.getString("session_date") +
                        " | Status: " + resultSet.getString("status")
                );
            }

        } catch (Exception e) {
            System.out.println("Failed to retrieve sessions: " + e.getMessage());
        }
    }
}

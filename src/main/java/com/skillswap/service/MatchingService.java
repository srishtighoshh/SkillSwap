
package com.skillswap.service;

import com.skillswap.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MatchingService {

    public void findMatches(int userId) {

        String sql = """
                SELECT DISTINCT
                    u.user_id,
                    u.name,
                    s.skill_name,
                    s.category
                FROM users u
                JOIN user_skills us ON u.user_id = us.user_id
                JOIN skills s ON us.skill_id = s.skill_id
                WHERE us.skill_type = 'TEACH'
                AND s.skill_id IN (
                    SELECT skill_id
                    FROM user_skills
                    WHERE user_id = ?
                    AND skill_type = 'LEARN'
                )
                AND u.user_id != ?
                """;

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, userId);
            statement.setInt(2, userId);

            ResultSet resultSet = statement.executeQuery();

            System.out.println("\n========== SKILL MATCHES ==========");

            boolean found = false;

            while (resultSet.next()) {

                found = true;

                System.out.println(
                        "Student: " + resultSet.getString("name") +
                        " | User ID: " + resultSet.getInt("user_id") +
                        " | Skill: " + resultSet.getString("skill_name") +
                        " | Category: " + resultSet.getString("category")
                );
            }

            if (!found) {
                System.out.println("No matching students found.");
            }

        } catch (Exception e) {
            System.out.println("Matching failed: " + e.getMessage());
        }
    }
}

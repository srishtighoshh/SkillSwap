
package com.skillswap.dao;

import com.skillswap.util.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SkillDAO {

    public boolean addSkill(String skillName, String category,
                            String description) {

        String sql = """
                INSERT INTO skills (skill_name, category, description)
                VALUES (?, ?, ?)
                """;

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, skillName);
            statement.setString(2, category);
            statement.setString(3, description);

            statement.executeUpdate();

            return true;

        } catch (Exception e) {
            System.out.println("Failed to add skill: " + e.getMessage());
            return false;
        }
    }

    public void displayAllSkills() {

        String sql = "SELECT * FROM skills";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            System.out.println("\n========== AVAILABLE SKILLS ==========");

            while (resultSet.next()) {

                System.out.println(
                        "ID: " + resultSet.getInt("skill_id") +
                        " | Skill: " + resultSet.getString("skill_name") +
                        " | Category: " + resultSet.getString("category")
                );

                System.out.println(
                        "Description: " +
                        resultSet.getString("description")
                );

                System.out.println("--------------------------------------");
            }

        } catch (Exception e) {
            System.out.println("Failed to retrieve skills: " + e.getMessage());
        }
    }
}

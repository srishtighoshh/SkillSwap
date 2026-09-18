package com.skillswap.dao;

import com.skillswap.util.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class UserSkillDAO {

    public boolean addUserSkill(int userId, int skillId, String skillType) {

        if (!skillType.equals("TEACH") && !skillType.equals("LEARN")) {
            System.out.println("Skill type must be TEACH or LEARN.");
            return false;
        }

        String sql = """
                INSERT OR IGNORE INTO user_skills
                (user_id, skill_id, skill_type)
                VALUES (?, ?, ?)
                """;

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, userId);
            statement.setInt(2, skillId);
            statement.setString(3, skillType);

            statement.executeUpdate();

            return true;

        } catch (Exception e) {
            System.out.println("Failed to add user skill: " + e.getMessage());
            return false;
        }
    }
}

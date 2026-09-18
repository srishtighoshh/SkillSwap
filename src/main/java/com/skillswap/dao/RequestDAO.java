
package com.skillswap.dao;

import com.skillswap.util.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RequestDAO {

    public boolean createRequest(int requesterId, int skillId) {

        String sql = """
                INSERT INTO skill_requests
                (requester_id, skill_id, status)
                VALUES (?, ?, ?)
                """;

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, requesterId);
            statement.setInt(2, skillId);
            statement.setString(3, "PENDING");

            statement.executeUpdate();

            return true;

        } catch (Exception e) {
            System.out.println("Failed to create request: " + e.getMessage());
            return false;
        }
    }

    public void displayRequests() {

        String sql = "SELECT * FROM skill_requests";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            System.out.println("\n========== SKILL REQUESTS ==========");

            while (resultSet.next()) {

                System.out.println(
                        "Request ID: " + resultSet.getInt("request_id") +
                        " | Requester ID: " + resultSet.getInt("requester_id") +
                        " | Skill ID: " + resultSet.getInt("skill_id") +
                        " | Status: " + resultSet.getString("status")
                );
            }

        } catch (Exception e) {
            System.out.println("Failed to retrieve requests: " + e.getMessage());
        }
    }
}

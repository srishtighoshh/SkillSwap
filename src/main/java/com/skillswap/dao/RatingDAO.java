package com.skillswap.dao;

import com.skillswap.util.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class RatingDAO {

    public boolean addRating(int sessionId, int reviewerId,
                             int rating, String feedback) {

        if (rating < 1 || rating > 5) {
            System.out.println("Rating must be between 1 and 5.");
            return false;
        }

        String sql = """
                INSERT INTO ratings
                (session_id, reviewer_id, rating, feedback)
                VALUES (?, ?, ?, ?)
                """;

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, sessionId);
            statement.setInt(2, reviewerId);
            statement.setInt(3, rating);
            statement.setString(4, feedback);

            statement.executeUpdate();

            return true;

        } catch (Exception e) {
            System.out.println("Failed to add rating: " + e.getMessage());
            return false;
        }
    }
}

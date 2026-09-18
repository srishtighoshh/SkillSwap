
package com.skillswap.model;

public class Rating {

    private int ratingId;
    private int sessionId;
    private int reviewerId;
    private int rating;
    private String feedback;

    public Rating(int ratingId, int sessionId, int reviewerId,
                  int rating, String feedback) {

        this.ratingId = ratingId;
        this.sessionId = sessionId;
        this.reviewerId = reviewerId;
        this.rating = rating;
        this.feedback = feedback;
    }

    public int getRatingId() {
        return ratingId;
    }

    public int getSessionId() {
        return sessionId;
    }

    public int getReviewerId() {
        return reviewerId;
    }

    public int getRating() {
        return rating;
    }

    public String getFeedback() {
        return feedback;
    }

    public void displayRating() {
        System.out.println("Rating ID: " + ratingId);
        System.out.println("Session ID: " + sessionId);
        System.out.println("Rating: " + rating + "/5");
        System.out.println("Feedback: " + feedback);
    }
}

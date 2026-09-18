
package com.skillswap.service;

import com.skillswap.dao.SessionDAO;

public class SessionService {

    private final SessionDAO sessionDAO;

    public SessionService() {
        sessionDAO = new SessionDAO();
    }

    public boolean scheduleSession(int teacherId, int learnerId,
                                   int skillId, String sessionDate) {

        if (teacherId <= 0 || learnerId <= 0 || skillId <= 0) {
            System.out.println("Invalid user or skill ID.");
            return false;
        }

        if (teacherId == learnerId) {
            System.out.println("Teacher and learner cannot be the same user.");
            return false;
        }

        if (sessionDate == null || sessionDate.isBlank()) {
            System.out.println("Session date cannot be empty.");
            return false;
        }

        return sessionDAO.createSession(
                teacherId, learnerId, skillId, sessionDate
        );
    }

    public void showSessions() {
        sessionDAO.displaySessions();
    }
}

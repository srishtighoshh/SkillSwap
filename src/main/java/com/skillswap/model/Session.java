
package com.skillswap.model;

public class Session {

    private int sessionId;
    private int teacherId;
    private int learnerId;
    private int skillId;
    private String sessionDate;
    private String status;

    public Session(int sessionId, int teacherId, int learnerId,
                   int skillId, String sessionDate, String status) {

        this.sessionId = sessionId;
        this.teacherId = teacherId;
        this.learnerId = learnerId;
        this.skillId = skillId;
        this.sessionDate = sessionDate;
        this.status = status;
    }

    public int getSessionId() {
        return sessionId;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public int getLearnerId() {
        return learnerId;
    }

    public int getSkillId() {
        return skillId;
    }

    public String getSessionDate() {
        return sessionDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void displaySession() {
        System.out.println("Session ID: " + sessionId);
        System.out.println("Teacher ID: " + teacherId);
        System.out.println("Learner ID: " + learnerId);
        System.out.println("Skill ID: " + skillId);
        System.out.println("Date: " + sessionDate);
        System.out.println("Status: " + status);
    }
}


package com.skillswap.model;

public class SkillRequest {

    private int requestId;
    private int requesterId;
    private int skillId;
    private String status;

    public SkillRequest(int requestId, int requesterId, int skillId, String status) {
        this.requestId = requestId;
        this.requesterId = requesterId;
        this.skillId = skillId;
        this.status = status;
    }

    public int getRequestId() {
        return requestId;
    }

    public int getRequesterId() {
        return requesterId;
    }

    public int getSkillId() {
        return skillId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void displayRequest() {
        System.out.println("Request ID: " + requestId);
        System.out.println("Requester ID: " + requesterId);
        System.out.println("Skill ID: " + skillId);
        System.out.println("Status: " + status);
    }
}

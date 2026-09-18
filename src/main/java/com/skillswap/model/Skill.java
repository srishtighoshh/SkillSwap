
package com.skillswap.model;

public class Skill {

    private int skillId;
    private String skillName;
    private String category;
    private String description;

    public Skill(int skillId, String skillName, String category, String description) {
        this.skillId = skillId;
        this.skillName = skillName;
        this.category = category;
        this.description = description;
    }

    public int getSkillId() {
        return skillId;
    }

    public String getSkillName() {
        return skillName;
    }

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public void displaySkill() {
        System.out.println("Skill ID: " + skillId);
        System.out.println("Skill: " + skillName);
        System.out.println("Category: " + category);
        System.out.println("Description: " + description);
    }
}

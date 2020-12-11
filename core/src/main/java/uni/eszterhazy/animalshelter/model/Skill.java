package uni.eszterhazy.animalshelter.model;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class Skill {

    private int id;

    private String skill;
    private int level;

    public Skill(){

    }

    public Skill(String skill, int level) {
        this.skill = skill;
        this.level = level;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        if(skill != null)
        {this.skill = skill;
        }
        else {
            //throw exception!
        }
    }


    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        if(level >= 0 && level <= 10) {
            this.level = level;
        }
        else{
            //throw exception!
        }
    }

    @Override
    public String toString() {
        return "Skill{" +
                "skill='" + skill + '\'' +
                ", level=" + level +
                '}';
    }
}

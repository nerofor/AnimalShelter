package uni.eszterhazy.animalshelter.model;

public class Skill {
    /*szobatiszta,
    * engedelmes állat,
    * gyerekbarát

    HOUSE_TRAINED,
    WELL_MANNERED_ANIMAL,
    CHILD_FRIENDLY*/

    private String skill;
    private int level;

    public Skill(){

    }

    public Skill(String skill, int level) {
        this.skill = skill;
        this.level = level;

    }


    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        if(skill != null && skill != "")
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
}

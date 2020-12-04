package uni.eszterhazy.animalshelter.model;

import uni.eszterhazy.animalshelter.exception.InvalidDateOfBirth;

import java.time.LocalDate;
import java.util.Collection;
import java.util.UUID;

public class Animal {
    private String id;
    private String name;
    private Type type;
    private Gender gender;
    private LocalDate dateOfBirth;

    private Collection<Skill> skills;
    private Status status;
    private Collection<Color> colors;
    private String description;

    public Animal(){
        this.id = UUID.randomUUID().toString();
    }

    /* optional
    public Animal(String name, Status status){

    }

    public Animal(String name, Type type, Gender gender, Status status){

    }*/

    public String getName() { return name; }

    public void setName(String name) {

        if(name.trim().length() == 0) {
            //hibaüzenetet dob!
        }
        else {
            this.name = name;
        }
    }



    public Type getType() {
        return type;
    }

    public void setType(Type type) {

        if(type == this.type) {
            //hibaüzenetet dob, mert ugyanazt akarom beállítani?
        }
        else {
            this.type = type;
        }
    }



    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {

        if(gender == this.gender) {
            //hibaüzenetet dob, mert ugyanazt akarom beállítani?
        }
        else {
            this.gender = gender;
        }
    }



    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) throws InvalidDateOfBirth {
        if(dateOfBirth.isAfter(LocalDate.now().minusMonths(6))){
            //throw new exception to do not added animal that younger than 6 months.
            throw new InvalidDateOfBirth("Do not added animal that younger than 6 months! Wrong date: " + dateOfBirth);
        }
        if(dateOfBirth.isBefore(LocalDate.now().minusYears(10))) {
            //throw new exception to do not added animal that younger than 10 years old.
            throw new InvalidDateOfBirth("Do not added animal that older than 10 years old! Wrong date: " + dateOfBirth);
        }

        this.dateOfBirth = dateOfBirth;
    }



    public Collection<Skill> getSkills() {
        return skills;
    }

    public void setSkills(Collection<Skill> skills) {
        this.skills = skills;
    }



    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        //mindenképp kell, hogy legyen státusza! Erre lehetne külön kivételt dobni!
        this.status = status;
    }



    public Collection<Color> getColors() {
        return colors;
    }

    public void setColors(Collection<Color> colors) {
        this.colors = colors;
    }



    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /*ToString metódus felülírása?*/
}

package uni.eszterhazy.animalshelter.model;

import org.springframework.format.annotation.DateTimeFormat;
import uni.eszterhazy.animalshelter.exception.InvalidDateOfBirth;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.UUID;

public class Animal {
    private String id;
    private String name;
    private Type type;
    private Gender gender;

    @DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
    private LocalDate dateOfBirth;

    private List<Skill> skills;
    private Status status;
    private Color color;
    private String description;

    public Animal(){
        this.id = UUID.randomUUID().toString();
    }

    public Animal(String name, Status status, @DateTimeFormat(iso=DateTimeFormat.ISO.DATE) LocalDate dateOfBirth){
        this();
        this.name = name;
        this.status = status;
        this.dateOfBirth = dateOfBirth;
    }

    public Animal(String name, Type type, Gender gender){
        this();
        this.name = name;
        this.type = type;
        this.gender = gender;
    }

    //public Animal(String name, Type type, Gender gender, String description){
    //    this();
    //    this(name, type, gender);
    //    this.description = description;
    //}

    public Animal(String name, String description) {
        this();
        this.name = name;
        this.description = description;
    }

    public Animal(String name, Type type, Gender gender, @DateTimeFormat(iso=DateTimeFormat.ISO.DATE) LocalDate dateOfBirth, Status status, Color color, String description) {
        this();
        this.name = name;
        this.type = type;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.status = status;
        this.color = color;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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
            //hibaüzenetet dob, mert ugyanazt akarom beállítani!
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
            //hibaüzenetet dob, mert ugyanazt akarom beállítani!
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



    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }



    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        //mindenképp kell, hogy legyen státusza! Erre lehetne külön kivételt dobni!
        this.status = status;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAge(){
        LocalDate currentDate = LocalDate.now();
        int age = Period.between(dateOfBirth, currentDate).getYears();
        return age;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", type=" + type +
                ", gender=" + gender +
                ", status=" + status +
                ", description='" + description + '\'' +
                '}';
    }
}

package uni.eszterhazy.animalshelter.relational;
import org.junit.Test;
import uni.eszterhazy.animalshelter.dao.AnimalDAO;
import uni.eszterhazy.animalshelter.service.impl.AnimalServiceImpl;
import uni.eszterhazy.animalshelter.exception.AnimalAlreadyAdded;
import uni.eszterhazy.animalshelter.exception.InvalidDateOfBirth;
import uni.eszterhazy.animalshelter.model.*;
import uni.eszterhazy.animalshelter.service.AnimalService;

import java.time.LocalDate;
import java.util.ArrayList;

import java.util.List;

public class AnimalDAORelationalTest {

    @Test
    public void test() throws InvalidDateOfBirth, AnimalAlreadyAdded {
        AnimalDAO dao = new AnimalDAORelational();
        AnimalService service = new AnimalServiceImpl(dao);

        Animal animal = new Animal("Veronica", Type.DOG, Gender.FEMALE, LocalDate.of(2010,12,31),Status.ADOPTED ,Color.BROWN, "None.");
        Skill s1 = new Skill("SIT", 3);
        Skill s2 = new Skill("LIE", 7);
        Skill s3 = new Skill("BARK", 6);
        Skill s4 = new Skill(String.valueOf(Task.CHILD_FRIENDLY), 5);
        List<Skill> skills = new ArrayList<>();
        skills.add(s1);
        skills.add(s2);
        skills.add(s3);
        skills.add(s4);
        animal.setSkills(skills);
        //dao.createAnimal(animal);
        //System.out.println(dao.readAnimal(animal.getId()));

        System.out.println("\nAverage age  of animals: "+service.getAverageAge());
        System.out.println("\nAverage age of parrots: "+service.getAverageAgeOfType(Type.PARROT));
        //System.out.println(dao.readAllAnimalOfType(Type.DOG));
    }
}
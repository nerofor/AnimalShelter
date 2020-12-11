package uni.eszterhazy.animalshelter.dao.relational;
import org.junit.Test;
import uni.eszterhazy.animalshelter.dao.AnimalDAO;
import uni.eszterhazy.animalshelter.exception.AnimalAlreadyAdded;
import uni.eszterhazy.animalshelter.exception.InvalidDateOfBirth;
import uni.eszterhazy.animalshelter.model.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AnimalDAORelationalTest {

    @Test
    public void test() throws InvalidDateOfBirth, AnimalAlreadyAdded {
        AnimalDAO dao = new AnimalDAORelational();
        Animal animal = new Animal();

        animal.setName("Jack");
        animal.setColor(Color.OTHER);
        animal.setGender(Gender.MALE);
        animal.setDateOfBirth(LocalDate.of(2010,12,30));

        //Skill s1 = new Skill("SIT", 10);
        //Skill s2 = new Skill("HOUSE_TRAINED", 10);
        Skill s3 = new Skill("CHILD_FRIENDLY", 7);

        List skills = new ArrayList<>();
        //skills.add(s1);
        //skills.add(s2);
        skills.add(s3);

        animal.setSkills(skills);

        animal.setStatus(Status.TAKE_CARE);
        animal.setType(Type.CAT);
        animal.setDescription("None");

        //dao.createAnimal(animal);
        //System.out.println(dao.readAnimal(animal.getId()));

        System.out.println(dao.readAllAnimalOfType(Type.CAT));
        //System.out.println(dao.readAllAnimalOfType(Type.DOG));
    }
}
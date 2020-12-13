import uni.eszterhazy.animalshelter.dao.AnimalDAO;
import uni.eszterhazy.animalshelter.dao.jason.AnimalDAOJSON;
import uni.eszterhazy.animalshelter.dao.relational.AnimalDAORelational;
import uni.eszterhazy.animalshelter.dao.service.impl.AnimalServiceImpl;
import uni.eszterhazy.animalshelter.exception.InvalidDateOfBirth;
import uni.eszterhazy.animalshelter.exception.NameNotNull;

import java.io.IOException;
import java.time.LocalDate;

public class Demo {
    public static void main(String[] args) throws NameNotNull, InvalidDateOfBirth, IOException {
        AnimalDAO dao = new AnimalDAOJSON("datas.json");
        AnimalServiceImpl service = new AnimalServiceImpl(dao);

        //Animal animal = new Animal("Luna", Type.FISH, Gender.FEMALE, LocalDate.of(2015,8,6),Status.NOTIFIED ,Color.RED, "None.");

        System.out.println(service.getAllAnimal());
        System.out.println("Average age of animals: " + service.getAverageAge());
    }
}

package uni.eszterhazy.animalshelter.service;

import uni.eszterhazy.animalshelter.exception.*;
import uni.eszterhazy.animalshelter.model.*;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Collection;

public interface AnimalService {

    void addAnimal(Animal animal) throws AnimalAlreadyAdded, AnimalNotFound, IOException;
    void updateAnimal(String id, String name, int costPerDay, LocalDate dateOfBirth, Status status, String description) throws NameNotNull, InvalidCostPerDay, InvalidDateOfBirth, StatusNotNull, AnimalNotFound;
    void deleteAnimal(String id);
    Collection<Animal> getAllAnimal();
    Animal getAnimalById(String id) throws AnimalNotFound;

    double getAverageAge();
    double getAverageAgeOfType(Type type);

    Collection<Animal> getAllAnimalOfType(Type type);

    Collection<Skill> getSkillOfAnimalById(String id) throws AnimalNotFound;
    /*Animal youngestAnimal(String id);
    Animal oldestAnimal(String id);
    Animal adoptedAnimals();
    //Animal adoptedAnimals(Type type);
    Animal notifiedAnimals();
    //Animal notifiedAnimals(Type type);
    Animal takeCareAnimals();
    //Animal takeCareAnimals(Type type);
    Collection<Animal> birthBeetwenTwoDate(LocalDate start, LocalDate end);
    Collection<Animal> birthBeetwenTwoDateOfType(LocalDate start, LocalDate end, Type type);
    Collection<Animal> getAllAnimalColor(Color color);*/
}

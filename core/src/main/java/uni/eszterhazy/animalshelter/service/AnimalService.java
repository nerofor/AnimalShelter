package uni.eszterhazy.animalshelter.service;

import uni.eszterhazy.animalshelter.exception.AnimalAlreadyAdded;
import uni.eszterhazy.animalshelter.exception.AnimalNotFound;
import uni.eszterhazy.animalshelter.model.*;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Collection;

public interface AnimalService {
    void addAnimal(Animal animal) throws AnimalAlreadyAdded, AnimalNotFound, IOException;
    void updateAnimal(Animal animal);
    void deleteAnimal(Animal animal);
    Collection<Animal> getAllAnimal();
    Animal getAnimalById(String id);

    double averageAge();
    double averageAgeOfType();
    Collection<Animal> getAllAnimalOfType(Type type);
    Collection<Animal> getAllAnimalOfGender(Gender gender);
    Animal getSkillOfAnimal(String id);
    Animal youngestAnimal(String id);
    Animal oldestAnimal(String id);
    Animal adoptedAnimals();
    //Animal adoptedAnimals(Type type);
    Animal notifiedAnimals();
    //Animal notifiedAnimals(Type type);
    Animal takeCareAnimals();
    //Animal takeCareAnimals(Type type);
    Collection<Animal> birthBeetwenTwoDate(LocalDate start, LocalDate end);
    Collection<Animal> birthBeetwenTwoDateOfType(LocalDate start, LocalDate end, Type type);
    Collection<Animal> getAllAnimalColor(Color color);
}

package uni.eszterhazy.animalshelter.dao;

import uni.eszterhazy.animalshelter.exception.*;
import uni.eszterhazy.animalshelter.model.*;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Collection;

public interface AnimalDAO {
    void createAnimal(Animal animal) throws AnimalAlreadyAdded, IOException, AnimalNotFound;
    Collection<Animal> readAllAnimal();
    Animal readAnimal(String id) throws AnimalNotFound;
    void updateAnimal(String id, String name, int costPerDay, LocalDate dateOfBirth, Status status, String description) throws NameNotNull, InvalidCostPerDay, InvalidDateOfBirth, StatusNotNull, AnimalNotFound;
    void deleteAnimal(String id);
    Collection<Skill> getAllSkillById(String id); //ez tuti kelleni fog!
    Collection<Animal> readAllAnimalOfType(Type type); //ez már opcionális
    Collection<Animal> readAllAnimalOfTypeAndGender(Type type, Gender gender); //ez már opcionális

}

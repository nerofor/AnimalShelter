package uni.eszterhazy.animalshelter.dao;

import uni.eszterhazy.animalshelter.exception.*;
import uni.eszterhazy.animalshelter.model.Animal;
import uni.eszterhazy.animalshelter.model.Status;
import uni.eszterhazy.animalshelter.model.Type;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Collection;

public interface AnimalDAO {
    void createAnimal(Animal animal) throws AnimalAlreadyAdded, IOException, AnimalNotFound;
    Collection<Animal> readAllAnimal();
    Animal readAnimal(String id) throws AnimalNotFound;
    void updateAnimal(String id, String name, int costPerDay, LocalDate dateOfBirth, Status status, String description) throws NameNotNull, InvalidCostPerDay, InvalidDateOfBirth, StatusNotNull, AnimalNotFound;
    void deleteAnimal(String id);
    Collection<Animal> readAllAnimalOfType(Type type); //ez már opcionális
}

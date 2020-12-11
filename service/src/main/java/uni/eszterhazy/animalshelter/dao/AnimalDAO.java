package uni.eszterhazy.animalshelter.dao;

import uni.eszterhazy.animalshelter.exception.AnimalAlreadyAdded;
import uni.eszterhazy.animalshelter.model.Animal;
import uni.eszterhazy.animalshelter.model.Type;

import java.util.Collection;

public interface AnimalDAO {
    void createAnimal(Animal animal) throws AnimalAlreadyAdded;
    Collection<Animal> readAllAnimal();
    Animal readAnimal(String id);
    void updateAnimal(Animal animal);
    void deleteAnimal(Animal animal);
    Collection<Animal> readAllAnimalOfType(Type type); //ez már opcionális
}

package uni.eszterhazy.animalshelter.dao;

import uni.eszterhazy.animalshelter.model.Animal;
import uni.eszterhazy.animalshelter.model.Type;

import java.util.Collection;

public interface AnimalDAO {
    void createAnimal(Animal animal);
    Collection<Animal> readAllAnimal();
    Animal readAnimal();
    void updateAnimal(Animal animal);
    void deleteAnimal(Animal animal);
    Collection<Animal> readAllAnimalOfType(Type type); //ez már opcionális
}

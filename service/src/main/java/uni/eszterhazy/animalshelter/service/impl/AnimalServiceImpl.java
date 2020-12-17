package uni.eszterhazy.animalshelter.service.impl;

import uni.eszterhazy.animalshelter.dao.AnimalDAO;
import uni.eszterhazy.animalshelter.exception.*;
import uni.eszterhazy.animalshelter.model.*;
import uni.eszterhazy.animalshelter.service.AnimalService;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Collection;
import java.util.stream.Collectors;


public class AnimalServiceImpl implements AnimalService {
    private AnimalDAO dao;

    public AnimalServiceImpl(AnimalDAO dao){
        this.dao = dao;
    }

    public AnimalServiceImpl() {

    }

    @Override
    public void addAnimal(Animal animal) throws AnimalAlreadyAdded, AnimalNotFound, IOException {
        dao.createAnimal(animal);
    }

    @Override
    public void updateAnimal(String id, String name, int costPerDay, LocalDate dateOfBirth, Status status, String description) throws NameNotNull, InvalidCostPerDay, InvalidDateOfBirth, StatusNotNull, AnimalNotFound {
        dao.updateAnimal(id, name, costPerDay, dateOfBirth, status, description);
    }

    @Override
    public void deleteAnimal(String id) {
        dao.deleteAnimal(id);
    }

    @Override
    public Collection<Animal> getAllAnimal() {
        return dao.readAllAnimal();
    }

    @Override
    public Animal getAnimalById(String id) throws AnimalNotFound {
        return dao.readAnimal(id);
    }

    //??
    @Override
    public double getAverageAge() {
        Collection<Animal> animals = getAllAnimal();
        double sum = 0;
        for (Animal a: animals) {
            sum += a.getAge();
        }

        return sum/ animals.size();
    }

    //??
    @Override
    public double getAverageAgeOfType(Type type) {
        Collection<Animal> animals = getAllAnimal();
        double sum = 0;
        for (Animal a: animals) {

            if(a.getType() == type) {
                sum += a.getAge();
            }
        }

        return sum/ animals.size();
    }

    //??
    @Override
    public Collection<Animal> getAllAnimalOfType(Type type) {
        Collection<Animal> animals = getAllAnimal();
        Collection<Animal> result  = animals.stream().filter(a -> a.getType() == type).collect(Collectors.toList());
        return result;
    }

    //Ez tuti kelleni fog!
    @Override
    public Collection<Skill> getSkillOfAnimalById(String id){
        Collection<Skill> result = null;
        try {
            Animal animals = dao.readAnimal(id);

            if(dao.readAnimal(id) != null) {
                Animal a = dao.readAnimal(id);
                result = dao.getAllSkillById(id);

                result = a.getSkills();
            }
        } catch (AnimalNotFound animalNotFound) {
            animalNotFound.printStackTrace();
            return result;
        }
        return result;
    }
}
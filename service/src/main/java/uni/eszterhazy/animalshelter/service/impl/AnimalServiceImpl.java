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

    @Override
    public double getAverageAge() {
        Collection<Animal> animals = getAllAnimal();
        double sum = 0;
        for (Animal a: animals) {
            sum += a.getAge();
        }

        return sum/ animals.size();
    }
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

    @Override
    public Collection<Animal> getAllAnimalOfType(Type type) {
        Collection<Animal> animals = getAllAnimal();
        Collection<Animal> result  = animals.stream().filter(a -> a.getType() == type).collect(Collectors.toList());
        return result;
    }

    @Override
    public Collection<Animal> getAllAnimalOfGender(Gender gender) {
        Collection<Animal> animals = getAllAnimal();
        Collection<Animal> result  = animals.stream().filter(a -> a.getGender() == gender).collect(Collectors.toList());
        return result;
    }

    @Override
    public Collection<Animal> getAllAnimalOfTypeAndGender(Type type, Gender gender) {
        Collection<Animal> animals = getAllAnimal();
        for(Animal a: animals) {
            if(a.getType() == type && a.getGender() == gender){
                animals.add(a);
            }
        }
        return animals;
    }

    /*@Override
    public Animal getSkillOfAnimal(String id) {
        return null;
    }

    @Override
    public Animal youngestAnimal(String id) {
        return null;
    }

    @Override
    public Animal oldestAnimal(String id) {
        return null;
    }

    @Override
    public Animal adoptedAnimals() {
        return null;
    }

    @Override
    public Animal notifiedAnimals() {
        return null;
    }

    @Override
    public Animal takeCareAnimals() {
        return null;
    }

    @Override
    public Collection<Animal> birthBeetwenTwoDate(LocalDate start, LocalDate end) {
        return null;
    }

    @Override
    public Collection<Animal> birthBeetwenTwoDateOfType(LocalDate start, LocalDate end, Type type) {
        return null;
    }

    @Override
    public Collection<Animal> getAllAnimalColor(Color color) {
        return null;
    }*/
}
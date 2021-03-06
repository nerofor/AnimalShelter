package uni.eszterhazy.animalshelter.relational;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import uni.eszterhazy.animalshelter.dao.AnimalDAO;
import uni.eszterhazy.animalshelter.exception.*;
import uni.eszterhazy.animalshelter.model.*;

import org.hibernate.cfg.Configuration;

import java.time.LocalDate;
import java.util.Collection;

public class AnimalDAORelational implements AnimalDAO {
    private static SessionFactory factory;


    public AnimalDAORelational() {
        factory = new Configuration().configure().buildSessionFactory();
    }
    //The skills cannot add!
    @Override
    public void createAnimal(Animal animal) throws AnimalAlreadyAdded{
        try{
            animalSearchById(animal.getId());
        } catch (AnimalNotFound animalNotFound) {
            Session session = factory.openSession();
            Transaction tx = session.beginTransaction();

            session.save(animal);
            tx.commit();
            session.close();
            return;
        }

    }

    @Override
    public Collection<Animal> readAllAnimal() {
        Session session = factory.openSession();
        Collection<Animal> animals = session.createQuery("FROM Animal").list();
        return animals;
    }

    @Override
    public Animal readAnimal(String id) throws AnimalNotFound{
        Session session = factory.openSession();
        if(session.get(Animal.class,id)==null){
            throw new AnimalNotFound("Animal not found with "+id);
        }

        Animal animal = session.get(Animal.class,id);
        return animal;
    }

    @Override
    public void updateAnimal(String id, String name, int costPerDay, LocalDate dateOfBirth, Status status, String description) throws NameNotNull, InvalidCostPerDay, InvalidDateOfBirth, StatusNotNull, AnimalNotFound {
        Session session=factory.openSession();
        Transaction tx=session.beginTransaction();
        Animal object=session.get(Animal.class,id);
        object.setName(name);
        object.setDateOfBirth(dateOfBirth);
        object.setStatus(status);
        object.setDescription(description);

        session.update(object);
        tx.commit();
        session.close();
    }

    @Override
    public void deleteAnimal(String id) {
        Session session=factory.openSession();
        Transaction tx=session.beginTransaction();
        Animal object =session.get(Animal.class,id);
        session.delete(object);

        tx.commit();
        session.close();
    }

    //NO OK!
    @Override
    public Collection<Skill> getAllSkillById(String id) {
        return null;
    }

    @Override
    public Collection<Animal> readAllAnimalOfType(Type type) {
        Session session = factory.openSession();
        String hql = "From Animal Where "+String.valueOf(type)+"=: type";

        Query q = session.createQuery(hql);
        q.setParameter("type", type);
        Collection result = q.list();
        return result;
    }

    //NO OK!
    @Override
    public Collection<Animal> readAllAnimalOfTypeAndGender(Type type, Gender gender) {
        return null;
    }

    private Animal animalSearchById(String id) throws AnimalNotFound {
        Session session=factory.openSession();
        if(session.get(Animal.class,id)==null){
            throw  new AnimalNotFound(id);
        }
        Animal result=session.get(Animal.class,id);
        return result;
    }
}

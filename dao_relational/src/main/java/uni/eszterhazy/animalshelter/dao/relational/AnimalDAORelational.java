package uni.eszterhazy.animalshelter.dao.relational;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import uni.eszterhazy.animalshelter.dao.AnimalDAO;
import uni.eszterhazy.animalshelter.model.Animal;
import uni.eszterhazy.animalshelter.model.Type;

import org.hibernate.cfg.Configuration;
import java.util.Collection;

public class AnimalDAORelational implements AnimalDAO {
    private static SessionFactory factory;


    public AnimalDAORelational() {
        factory = new Configuration().configure().buildSessionFactory();
    }

    @Override
    public void createAnimal(Animal animal) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(animal);
        tx.commit();
        session.close();

    }

    @Override
    public Collection<Animal> readAllAnimal() {
        Session session = factory.openSession();
        Collection<Animal> result = session.createQuery("FROM Animal").list();
        return result;
    }

    @Override
    public Animal readAnimal(String id) {
        Session session = factory.openSession();
        Animal result = session.get(Animal.class, id);
        return result;
    }

    @Override
    public void updateAnimal(Animal animal) {

    }

    @Override
    public void deleteAnimal(Animal animal) {

    }

    @Override
    public Collection<Animal> readAllAnimalOfType(Type type) {
        Session session = factory.openSession();
        String hql = "From Animal Where type=: type";

        Query q = session.createQuery(hql);
        q.setParameter("type", type);
        Collection result = q.list();
        return result;
    }
}

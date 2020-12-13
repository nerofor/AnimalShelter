package uni.eszterhazy.animalshelter.jason;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.core.type.TypeReference;
import uni.eszterhazy.animalshelter.dao.AnimalDAO;
import uni.eszterhazy.animalshelter.exception.AnimalAlreadyAdded;
import uni.eszterhazy.animalshelter.exception.AnimalNotFound;
import uni.eszterhazy.animalshelter.model.Animal;
import uni.eszterhazy.animalshelter.model.Type;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class AnimalDAOJSON implements AnimalDAO {
    File jsonFile;
    ObjectMapper mapper;

    public AnimalDAOJSON(String jsonFilePath) throws IOException {
        jsonFile = new File(jsonFilePath);
        if(!jsonFile.exists()) {
            jsonFile.createNewFile();
            FileWriter writer = new FileWriter(jsonFile);
            writer.write("[]");
            writer.flush();
            writer.close();
        }
        mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());

    }

    public void createAnimal(Animal animal) throws AnimalAlreadyAdded {
        Collection<Animal> animals = readAllAnimal();
        Animal result = null;
        try {
            result = readAnimal(animal.getId());
        } catch (AnimalNotFound animalNotFound) {
            animalNotFound.printStackTrace();
        }

        if(result==null) {
            animals.add(animal);
            try {
                mapper.writeValue(jsonFile, animal);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        throw new AnimalAlreadyAdded(animal.getId());
    }

    public Collection<Animal> readAllAnimal() {
        Collection<Animal> animals = new ArrayList<Animal>();
        TypeReference type = new TypeReference<ArrayList<Animal>>() {};
        try {
            animals = mapper.readValue(jsonFile, type);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Animal readAnimal(String id) throws AnimalNotFound {
       Collection<Animal> animals = readAllAnimal();
       for(Animal a: animals) {
           if(a.getId().equalsIgnoreCase(id)){
               return a;
           }
       }
       throw new AnimalNotFound(id);
    }

    public void updateAnimal(Animal animal) {

    }

    public void deleteAnimal(Animal animal) {

    }

    public Collection<Animal> readAllAnimalOfType(Type type) {
        return null;
    }
}

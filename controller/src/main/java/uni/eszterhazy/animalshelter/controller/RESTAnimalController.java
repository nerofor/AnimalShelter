package uni.eszterhazy.animalshelter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import uni.eszterhazy.animalshelter.exception.AnimalAlreadyAdded;
import uni.eszterhazy.animalshelter.exception.AnimalNotFound;
import uni.eszterhazy.animalshelter.exception.InvalidDateOfBirth;
import uni.eszterhazy.animalshelter.model.Animal;
import uni.eszterhazy.animalshelter.model.Gender;
import uni.eszterhazy.animalshelter.model.Type;
import uni.eszterhazy.animalshelter.service.AnimalService;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

@RestController
@RequestMapping(value = "/rest/")
public class RESTAnimalController {

    @Autowired
    AnimalService animalService;

    @GetMapping(value = "animals")
    public Collection<Animal> getAllAnimal(){
        return animalService.getAllAnimal();
    }

    @GetMapping(value = "animal/{id:[A-Za-z0-9]{8}-[A-Za-z0-9]{4}-[A-Za-z0-9]{4}-[A-Za-z0-9]{4}-[A-Za-z0-9]{12}}")
    public Animal getAnimalById(@PathVariable(name = "id") String id) throws AnimalNotFound {
            return animalService.getAnimalById(id);


    }

    @ExceptionHandler(AnimalNotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String unknowAnimalId(AnimalNotFound animalNotFound) {
        return "Animal not found with id:" + animalNotFound.getMessage();
    }

    //@GetMapping(value = "animals/{costPerDay}")
    //public Collection<Animal> getAllAnimalofType(@RequestParam(value = "type", required = false) Type type, @RequestParam(value = "cost") int costPerDay){
        //if(type != null && costPerDay == 0)
        //    return animalService.getAllAnimalOfType(type);
//
        //if(type == null && costPerDay == 0)
        //    return animalService.getAllAnimal();

        //if(type != null && costPerDay > 0) //kell costPerDay mezőt!
            //return animalService.getAllAnimalOfType(type).stream().filter(a -> a.getCostPerDay() > costPerDay).collect(Collectors.toList());

    /*Nem biztos, hogy jó!*/
    @GetMapping(value = "animals/{status}")
    public Collection<Animal> getAllAnimalofType(@RequestParam(value = "type", required = false) Type type, @RequestParam(value = "gender") Gender gender){
        Collection<Animal> animals = animalService.getAllAnimalOfType(type);
        Collection<Animal> result = new ArrayList<Animal>();
        for (Animal a: animals) {
            if(a.getGender() == gender){
                result.add(a);
            }
        }

        return result;
    }

    @PostMapping(value = "animals", consumes = MediaType.APPLICATION_JSON_VALUE, produces = "application/json;charset=utf-8")
    public String addAnimal(@RequestBody Animal animal) throws IOException, AnimalAlreadyAdded, AnimalNotFound {
        animalService.addAnimal(animal);
        return "New animal added this id: "+animal.getId();
    }

    @ExceptionHandler(AnimalAlreadyAdded.class)
    @ResponseStatus(HttpStatus.IM_USED)
    public String usedAnimalId(AnimalAlreadyAdded animalAlreadyAdded) {
        return "Already added animal with id: " + animalAlreadyAdded.getMessage();
    }

    /*@ExceptionHandler(InvalidDateOfBirth.class)
    public String badRequest(InvalidDateOfBirth e) {
        return e.getMessage();
    }*/
}

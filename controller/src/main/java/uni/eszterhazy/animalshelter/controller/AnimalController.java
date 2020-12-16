package uni.eszterhazy.animalshelter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import uni.eszterhazy.animalshelter.exception.*;
import uni.eszterhazy.animalshelter.model.Animal;
import uni.eszterhazy.animalshelter.model.Status;
import uni.eszterhazy.animalshelter.model.Type;
import uni.eszterhazy.animalshelter.service.AnimalService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;


@Controller
public class AnimalController {

    @Autowired
    @Qualifier("AnimalService")
    AnimalService service;

    @ModelAttribute(value = "animal")
    public Animal create(){
        return new Animal();
    }

    //OK!
    @GetMapping(value = "/animals")
    public ModelAndView getAnimals(Model model){
        ModelAndView mav = new ModelAndView("animalList");
        model.addAttribute("type", Type.values());
        mav.addObject("animals", service.getAllAnimal());
        return mav;
    }

    //OK!
    @GetMapping("/animal/{id}")
    public String getAnimalById(@PathVariable String id, Model model) throws AnimalNotFound {
        model.addAttribute("animal", service.getAnimalById(id));
        return "animalDetails";
    }

    @PostMapping(value="/animalID")
    public ModelAndView searchById(String id) throws AnimalNotFound {
        Animal result=service.getAnimalById(id);
        Collection<Animal> resultList=new ArrayList<Animal>();
        resultList.add(result);

        ModelAndView mav=new ModelAndView("animalList");
        mav.addObject("animal",resultList);
        return mav;
    }


    @GetMapping(value = "/newAnimal")
    public String addAnimalForm(Model model) {
        model.addAttribute("status", Status.values());
        return "animalForm";
    }

    @PostMapping(value = "/addAnimal")
    public String addAnimal(@ModelAttribute("animal") Animal animal) {
        try {
            service.addAnimal(animal);
        } catch (AnimalAlreadyAdded animalAlreadyAdded) {
            animalAlreadyAdded.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (AnimalNotFound animalNotFound) {
            animalNotFound.printStackTrace();
        }

        return "redirect:animal/"+animal.getId();
    }


    @GetMapping(value = "/updateById/{id}")
    public String updateForm(@PathVariable String id,Model model) throws AnimalNotFound {
        Animal object=service.getAnimalById(id);
        model.addAttribute("newAnimal",object);
        model.addAttribute("Type", Type.values());
        return "animalUpdate";
    }


    @PostMapping(value = "/update")
    public String update(@ModelAttribute("newAnimal") Animal animal) {
        try {
            service.updateAnimal(animal.getId(), animal.getName(), animal.getCostPerDay(), animal.getDateOfBirth(), animal.getStatus(), animal.getDescription());
        } catch (NameNotNull nameNotNull){
            nameNotNull.printStackTrace();
        } catch(InvalidCostPerDay invalidCostPerDay){
            invalidCostPerDay.printStackTrace();

        } catch (InvalidDateOfBirth invalidDateOfBirth) {
            invalidDateOfBirth.printStackTrace();

        } catch (StatusNotNull statusNotNull) {
            statusNotNull.printStackTrace();

        } catch(AnimalNotFound animalNotFound) {
            animalNotFound.printStackTrace();
        }
        return "redirect:animal/" + animal.getId();
    }

    @GetMapping(value = "/deleteById/{id}")
    public String delete(@PathVariable String id) throws AnimalNotFound {
        service.deleteAnimal(id);
        return "redirect:/animals";
    }

    @PostMapping(value="/byType")
    public ModelAndView getBdByRate(Type type){
        ModelAndView mav=new ModelAndView("AnimalList");
        mav.addObject("animal",service.getAllAnimalOfType(type));
        return mav;
    }
}

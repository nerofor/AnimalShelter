package uni.eszterhazy.animalshelter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import uni.eszterhazy.animalshelter.exception.AnimalAlreadyAdded;
import uni.eszterhazy.animalshelter.exception.AnimalNotFound;
import uni.eszterhazy.animalshelter.model.Animal;
import uni.eszterhazy.animalshelter.model.Status;
import uni.eszterhazy.animalshelter.service.AnimalService;

import java.io.IOException;


@Controller
public class AnimalController {

    @Autowired
    @Qualifier("animalService")
    AnimalService service;

    @ModelAttribute(value = "animal")
    public Animal create(){
        return new Animal();
    }

    /*@GetMapping(value = "/animals")
    public ModelAndView getAnimals(){
        //System.out.println(service.getAllAnimal());
        ModelAndView mav = new ModelAndView("animallist.jsp");
        mav.addObject("animals", service.getAllAnimal());
        return mav;
    }*/

    @GetMapping("/animals")
    public String getAnimals2(Model model) {
        model.addAttribute("animals", service.getAllAnimal());
        return "animallist.jsp";
    }

    @GetMapping("/animal/{id}")
    public String getAnimalById(@PathVariable String id, Model model) throws AnimalNotFound {
        model.addAttribute("animal", service.getAnimalById(id));
        return "animaldetails.jsp";
    }
    @GetMapping(value = "addAnimal")
    public String addAnimalForm(Model model) {
        model.addAttribute("status", Status.values());
        return "animalForm.jsp";
    }

    //@PostMapping(value = "addAnimal")
    //public String addAnimal(@ModelAttribute("animal") Animal animal, Model model) {
    //    try {
    //        service.addAnimal(animal);
    //    } catch (AnimalAlreadyAdded animalAlreadyAdded) {
    //        animalAlreadyAdded.printStackTrace();
    //    } catch (IOException e) {
    //        e.printStackTrace();
    //    }
    //    return "redirect:animal/"+animal.getId();
    //}
    /*
    @Autowired
    public AnimalController(AnimalService service) {
        this.service = service;
    }

    @Autowired
    public void setService() {
        this.service = service;
    }*/
}

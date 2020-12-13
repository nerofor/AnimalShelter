import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import uni.eszterhazy.animalshelter.service.AnimalService;

public class AnimalApp {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("app-config.xml");
        AnimalService service = (AnimalService) context.getBean("animalService");
        System.out.println(service.getAllAnimal());
    }
}

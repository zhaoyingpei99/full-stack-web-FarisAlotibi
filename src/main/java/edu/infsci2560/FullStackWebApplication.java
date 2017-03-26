package edu.infsci2560;

import edu.infsci2560.models.InfoArm;
import edu.infsci2560.models.InfoArm.TicketType;
import edu.infsci2560.repositories.InfoArmRepository;
import edu.infsci2560.models.Orgnization;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import edu.infsci2560.models.Course;
import edu.infsci2560.repositories.CourseRepository;
import java.net.*;  

@SpringBootApplication
@ComponentScan({"edu.infsci2560"})
public class FullStackWebApplication {

    private static final Logger log = LoggerFactory.getLogger(FullStackWebApplication.class);

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(FullStackWebApplication.class, args);

        InfoArmRepository repository = ctx.getBean(InfoArmRepository.class);

        InfoArm infoArm1 = new InfoArm("install firewall", TicketType.Network_Security);
        Orgnization orgnization = new Orgnization("IT", "2000", "Industry Professionals", infoArm1);
        infoArm1.setOrgnization(orgnization);
        repository.save(infoArm1);

        InfoArm infoArm2 = new InfoArm("Batch the bugs", TicketType.Software_Security);
        orgnization = new Orgnization("Military", "10000", "Goverment", infoArm2);
        infoArm2.setOrgnization(orgnization);
        repository.save(infoArm2);

        InfoArm infoArm3 = new InfoArm("Update PLC", TicketType.Hardware_Security);
        orgnization = new Orgnization("Hospital", "5000", "Health Insurance", infoArm3);
        infoArm3.setOrgnization(orgnization);
        repository.save(infoArm3);

        CourseRepository courseRepository = ctx.getBean(CourseRepository.class);
        try{
            URL link1 = new URL("https://www.youtube.com/watch?v=DoRoMLPDneo");
            URL link2 = new URL("https://www.youtube.com/watch?v=vg9cNFPQFqM");
            courseRepository.save(new Course(1L, "Beginner Ethical Hacking", "Good Ethical Hacking", link1));
            courseRepository.save(new Course(2L, "Advance Ethical Hacking", "Really good start of ethical hacking", link2));
        }catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }


//    @Bean
//    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
//        return args -> {
//
//            System.out.println("Let's inspect the beans provided by Spring Boot:");
//
//            String[] beanNames = ctx.getBeanDefinitionNames();
//            Arrays.sort(beanNames);
//            for (String beanName : beanNames) {
//                System.out.println(beanName);
//            }
//
//        };
//    }
//    @Bean
//    public CommandLineRunner databaseDemo(CustomerRepository repository) {
//        return (args) -> {
//            // save a couple of customers
//            repository.save(new Customer("Jack", "Bauer"));
//            repository.save(new Customer("Chloe", "O'Brian"));
//            repository.save(new Customer("Kim", "Bauer"));
//            repository.save(new Customer("David", "Palmer"));
//            repository.save(new Customer("Michelle", "Dessler"));
//            repository.save(new Customer("Billy", "Bean"));
//
//            // fetch all customers
//            log.info("[Database Demo] Customers found with findAll():");
//            log.info("[Database Demo] -------------------------------");
//            for (Customer customer : repository.findAll()) {
//                log.info("[Database Demo] " + customer.toString());
//            }
//            log.info("");
//
//            // fetch an individual customer by ID
//            Customer customer = repository.findOne(1L);
//            log.info("[Database Demo] Customer found with findOne(1L):");
//            log.info("[Database Demo] --------------------------------");
//            log.info("[Database Demo] " + customer.toString());
//
//            // fetch customers by last name
//            log.info("[Database Demo] Customer found with findByLastName('Bauer'):");
//            log.info("[Database Demo] --------------------------------------------");
//            for (Customer bauer : repository.findByLastName("Bauer")) {
//                log.info("[Database Demo] " + bauer.toString());
//            }
//        };
//    }
}
package by.javagury.spring;

import by.javagury.spring.config.ApplicationConfiguration;
import by.javagury.spring.service.CompanyService;
import by.javagury.spring.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringRunner {
    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);

        var companyService = context.getBean(CompanyService.class);
        System.out.println(companyService.findAll());
        System.out.println(companyService.findById(1L));

        var userService = context.getBean(UserService.class);
        System.out.println(userService.findById(1L));
        System.out.println(userService.findAll());
        context.close();
    }
}

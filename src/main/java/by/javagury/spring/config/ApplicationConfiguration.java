package by.javagury.spring.config;


import by.javagury.spring.database.repository.CompanyRepository;
import by.javagury.spring.database.repository.UserRepository;
import by.javagury.spring.dto.UserDto;
import by.javagury.spring.listener.EntityAfterEvent;
import by.javagury.spring.listener.EntityBeforeEvent;
import by.javagury.spring.mapper.CompanyToDto;
import by.javagury.spring.mapper.DtoToCompany;
import by.javagury.spring.mapper.DtoToUser;
import by.javagury.spring.mapper.UserToDto;
import by.javagury.spring.service.CompanyService;
import by.javagury.spring.service.UserService;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.*;

@Configuration
@PropertySource("classpath:app.properties")
@ComponentScan("by.javagury.spring")
public class ApplicationConfiguration {

    @Bean
    public UserService userService(ApplicationEventPublisher applicationEventPublisher) {
        return new UserService(new DtoToUser(), new UserToDto(), new UserRepository(),
                applicationEventPublisher);
    }

    @Bean
    public CompanyService companyService(ApplicationEventPublisher applicationEventPublisher) {
        return new CompanyService(new DtoToCompany(), new CompanyToDto(), new CompanyRepository(),
                applicationEventPublisher);
    }
}

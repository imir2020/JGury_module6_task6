package repository;

import by.javagury.spring.database.entity.Company;
import by.javagury.spring.database.entity.User;
import by.javagury.spring.database.repository.CompanyRepository;
import by.javagury.spring.database.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;

@TestInstance(PER_CLASS)
public class UserRepositoryTest {
    private final UserRepository userRepository = new UserRepository();

    @Test
    public void findById(){
        Long id = 4L;
        User user = userRepository.findById(id).get();
        System.out.println(user);
    }

    @Test
    public void save(){
        Long id = 3L;
        User user = User.builder()
                .birthDate(LocalDateTime.now())
                .firstName("Oleg")
                .lastName("Ivanov")
                .companyId(id)
                .build();
        userRepository.save(user);
    }
}

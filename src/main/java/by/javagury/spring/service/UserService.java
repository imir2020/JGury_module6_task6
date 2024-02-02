package by.javagury.spring.service;

import by.javagury.spring.database.repository.UserRepository;
import by.javagury.spring.dto.UserDto;
import by.javagury.spring.listener.EntityAfterEvent;
import by.javagury.spring.listener.EntityBeforeEvent;
import by.javagury.spring.mapper.DtoToUser;
import by.javagury.spring.mapper.UserToDto;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@ToString
public class UserService {
    private final DtoToUser dtoToUser;
    private final  UserToDto userToDto;
    private final UserRepository userRepository;
    private final ApplicationEventPublisher applicationEventPublisher;

    public Optional<UserDto> findById(Long id) {
        applicationEventPublisher.publishEvent(new EntityBeforeEvent(userRepository, "WILL FIND"));
        Optional<UserDto> companyDto = userRepository.findById(id)
                .map(userToDto::mapfrom);
        applicationEventPublisher.publishEvent(new EntityAfterEvent(companyDto, "WAS FIND"));
        return companyDto;
    }

    public List<UserDto> findAll() {
        applicationEventPublisher.publishEvent(new EntityBeforeEvent(userRepository, "WILL FIND_ALL"));
        List<UserDto> list = userRepository.findAll().stream()
                .map(userToDto::mapfrom)
                .collect(Collectors.toList());
        applicationEventPublisher.publishEvent(new EntityAfterEvent(userRepository, "WAS FIND_ALL"));
        return list;
    }

    public UserDto  save(UserDto userDto) {
        applicationEventPublisher.publishEvent(new EntityBeforeEvent(userRepository, "WILL SAVE"));
        var company = dtoToUser.mapfrom(userDto);
        userRepository.save(company);
        applicationEventPublisher.publishEvent(new EntityAfterEvent(userRepository, "WAS SAVE"));
        return userDto;
    }

    public void update( UserDto userDto) {
        applicationEventPublisher.publishEvent(new EntityBeforeEvent(userRepository, "WILL UPDATE"));
        userRepository.update(dtoToUser.mapfrom(userDto));
        applicationEventPublisher.publishEvent(new EntityBeforeEvent(userRepository, "WAS UPDATE"));
    }

    public void delete(Long id) {
        applicationEventPublisher.publishEvent(new EntityBeforeEvent(userRepository, "WILL DELETE"));
        userRepository.delete(id);
        applicationEventPublisher.publishEvent(new EntityBeforeEvent(userRepository, "WAS DELETE"));

    }
}

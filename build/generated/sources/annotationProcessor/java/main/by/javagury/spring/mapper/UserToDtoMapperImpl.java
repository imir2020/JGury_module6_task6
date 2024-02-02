package by.javagury.spring.mapper;

import by.javagury.spring.database.entity.User;
import by.javagury.spring.dto.UserDto;
import java.time.LocalDateTime;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-02T19:14:46+0300",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.2.jar, environment: Java 17.0.8 (Oracle Corporation)"
)
public class UserToDtoMapperImpl implements UserToDtoMapper {

    @Override
    public UserDto fromUser(User user) {
        if ( user == null ) {
            return null;
        }

        Long id = null;
        String firstName = null;
        String lastName = null;
        String role = null;
        String userName = null;
        Long companyId = null;

        id = user.getId();
        firstName = user.getFirstName();
        lastName = user.getLastName();
        role = user.getRole();
        userName = user.getUserName();
        companyId = user.getCompanyId();

        LocalDateTime localDateTime = null;

        UserDto userDto = new UserDto( id, localDateTime, firstName, lastName, role, userName, companyId );

        return userDto;
    }
}

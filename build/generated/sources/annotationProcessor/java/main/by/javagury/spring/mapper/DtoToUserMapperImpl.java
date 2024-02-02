package by.javagury.spring.mapper;

import by.javagury.spring.database.entity.User;
import by.javagury.spring.dto.UserDto;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-02T19:14:46+0300",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.2.jar, environment: Java 17.0.8 (Oracle Corporation)"
)
public class DtoToUserMapperImpl implements DtoToUserMapper {

    @Override
    public User fromDto(UserDto userDto) {
        if ( userDto == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.id( userDto.id() );
        user.firstName( userDto.firstName() );
        user.lastName( userDto.lastName() );
        user.role( userDto.role() );
        user.userName( userDto.userName() );
        user.companyId( userDto.companyId() );

        return user.build();
    }
}

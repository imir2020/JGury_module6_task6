package by.javagury.spring.mapper;

import by.javagury.spring.database.entity.User;
import by.javagury.spring.dto.UserDto;

public class DtoToUser {
    public User mapfrom(UserDto userDto){
        return DtoToUserMapper.INSTANCE.fromDto(userDto);
    }
}

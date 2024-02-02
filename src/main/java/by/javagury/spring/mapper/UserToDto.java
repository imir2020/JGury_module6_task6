package by.javagury.spring.mapper;


import by.javagury.spring.database.entity.User;
import by.javagury.spring.dto.UserDto;

public class UserToDto {

    public UserDto mapfrom(User user){
        return UserToDtoMapper.INSTANCE.fromUser(user);
    }

}

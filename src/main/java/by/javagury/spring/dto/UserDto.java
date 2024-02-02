package by.javagury.spring.dto;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

//@Component
public record UserDto(Long id,
                      LocalDateTime localDateTime,
                      String firstName,
                      String lastName,
                      String role,
                      String userName,
                      Long companyId) {
}

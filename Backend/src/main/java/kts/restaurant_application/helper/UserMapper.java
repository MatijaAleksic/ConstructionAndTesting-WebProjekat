package kts.restaurant_application.helper;


import kts.restaurant_application.DTO.UserDTO;
import kts.restaurant_application.model.User;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class UserMapper implements MapperInterface<User, UserDTO> {


    @Override
    public User toEntity(UserDTO dto) {
        return new User(dto.getUsername(), dto.getPassword(), dto.getFirstName(), dto.getLastName(), dto.getDateOfBirth(), dto.getSalary());
    }

    @Override
    public UserDTO toDto(User entity) {
        return new UserDTO(entity.getId(), entity.getUsername(),entity.getPassword(), entity.getFirstName(), entity.getLastName(), entity.getDateOfBirth(), entity.getSalary());
    }
}

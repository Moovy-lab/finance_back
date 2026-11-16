package project.personal.finance.mapper;


import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import project.personal.finance.dto.UserDTO;
import project.personal.finance.entities.User;

@Mapper( componentModel = "Spring")
@Component
public interface UserMapper {

    public User toEntity(UserDTO dto);
    public UserDTO toDto (User user);
}

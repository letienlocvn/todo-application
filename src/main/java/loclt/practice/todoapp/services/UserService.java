package loclt.practice.todoapp.services;

import loclt.practice.todoapp.dto.LoginDTO;
import loclt.practice.todoapp.dto.UserCreationDTO;
import loclt.practice.todoapp.dto.UserDTO;

public interface UserService {
    Iterable<UserDTO> getAllUsers();

    UserCreationDTO signUp(UserCreationDTO userDTO);
    LoginDTO login(LoginDTO loginDTO);
}

package loclt.practice.todoapp.services.impl;

import loclt.practice.todoapp.dto.LoginDTO;
import loclt.practice.todoapp.dto.UserCreationDTO;
import loclt.practice.todoapp.dto.UserDTO;
import loclt.practice.todoapp.entities.User;
import loclt.practice.todoapp.repositories.UserRepository;
import loclt.practice.todoapp.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;


    public Iterable<UserDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(
                this::mapToDTOs).collect(Collectors.toList());

    }

    @Override
    public UserCreationDTO signUp(UserCreationDTO userDTO) {
        User user = mapToEntity(userDTO);
        return mapToDTO(userRepository.save(user));
    }

    @Override
    public LoginDTO login(LoginDTO loginDTO) {
        boolean isEmailExits = userRepository.existsByEmail(loginDTO.getEmail());
        if (isEmailExits) {
            User user = userRepository.findUserByEmailAndPassword(loginDTO.getEmail(), loginDTO.getPassword());
            return mapToDTOGenerics(user, LoginDTO.class);
        } else {
            return null;
        }
    }

    private <T, U> U mapToEntityGenerics(T DTO, Class<U> entityClass) {
        return modelMapper.map(DTO, entityClass);
    }

    private <T, U> U mapToDTOGenerics(T entity, Class<U> dtoClass) {
        return modelMapper.map(entity, dtoClass);
    }

    private User mapToEntity(UserCreationDTO userDTO) {
        return modelMapper.map(userDTO, User.class);
    }

    private UserDTO mapToDTOs(User user) {
        return modelMapper.map(user, UserDTO.class);
    }

    private UserCreationDTO mapToDTO(User user) {
        return modelMapper.map(user, UserCreationDTO.class);
    }
}

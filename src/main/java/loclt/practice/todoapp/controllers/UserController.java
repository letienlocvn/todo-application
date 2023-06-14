package loclt.practice.todoapp.controllers;

import loclt.practice.todoapp.dto.LoginDTO;
import loclt.practice.todoapp.dto.UserCreationDTO;
import loclt.practice.todoapp.dto.UserDTO;
import loclt.practice.todoapp.entities.User;
import loclt.practice.todoapp.payload.responses.ResponseMessage;
import loclt.practice.todoapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public ResponseEntity<Iterable<UserDTO>> getAllUser() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @PostMapping("/user")
    public ResponseEntity<UserCreationDTO> signUp(@RequestBody UserCreationDTO userDTO) {
        return ResponseEntity.ok(userService.signUp(userDTO));
    }

    @PostMapping("/login")
    public ResponseEntity<ResponseMessage<LoginDTO>> loginDTOResponseEntity(@RequestBody LoginDTO loginDTO) {
        ResponseMessage<LoginDTO> message = new ResponseMessage<>();
        LoginDTO userLogin =  userService.login(loginDTO);
        if (userLogin != null) {
            message.setStatus(HttpStatus.OK.value());
            message.setMessage("Login Success");
            message.setData(userLogin);
        } else {
            message.setStatus(HttpStatus.BAD_REQUEST.value());
            message.setMessage("Login failed");
            message.setData(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(message);
    }
}

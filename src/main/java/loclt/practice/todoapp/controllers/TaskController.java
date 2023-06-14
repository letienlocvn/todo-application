package loclt.practice.todoapp.controllers;

import jakarta.validation.Valid;
import loclt.practice.todoapp.dto.TaskDTO;
import loclt.practice.todoapp.payload.responses.ResponseMessage;
import loclt.practice.todoapp.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/tasks")
    public ResponseEntity<ResponseMessage<List<TaskDTO>>> getAllTasks() {
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseMessage<>(HttpStatus.OK.value(),
                        "Get list task successfully",
                        taskService.getAllTasks())
        );
    }

    @PostMapping("/task")
    public ResponseEntity<ResponseMessage<TaskDTO>> addTask(@Valid @RequestBody TaskDTO taskDTO) {
        ResponseMessage<TaskDTO> message = new ResponseMessage<>();
        TaskDTO newTask = taskService.addTask(taskDTO);
        message.setStatus(HttpStatus.OK.value());
        message.setMessage("Add new task successfully");
        message.setData(newTask);
        return ResponseEntity.status(HttpStatus.OK).body(message);
    }

    @PutMapping("/task/{id}")
    public ResponseEntity<ResponseMessage<TaskDTO>> updateTask(@PathVariable(name = "id") long id,
                                                               @RequestBody @Valid TaskDTO taskDTO) {
        ResponseMessage<TaskDTO> message = new ResponseMessage<>();
        TaskDTO updateTask = taskService.updateTask(id, taskDTO);
        message.setStatus(HttpStatus.OK.value());
        message.setMessage("Update task successfully");
        message.setData(updateTask);
        return ResponseEntity.status(HttpStatus.OK).body(message);
    }

    @DeleteMapping("/task/{id}")
    public ResponseEntity<ResponseMessage<TaskDTO>> deleteTask(@PathVariable(name = "id") long id) {
        ResponseMessage<TaskDTO> message = new ResponseMessage<>();
        taskService.deleteTask(id);
        message.setStatus(HttpStatus.OK.value());
        message.setMessage("Delete task successfully");
        return ResponseEntity.status(HttpStatus.OK).body(message);
    }
}

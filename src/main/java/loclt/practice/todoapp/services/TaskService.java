package loclt.practice.todoapp.services;

import loclt.practice.todoapp.dto.TaskDTO;

import java.util.List;

public interface TaskService {
    List<TaskDTO> getAllTasks();

    TaskDTO addTask(TaskDTO taskDTO);
    TaskDTO updateTask(long id, TaskDTO taskDTO);
    void deleteTask(long id);
}

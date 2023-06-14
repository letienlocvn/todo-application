package loclt.practice.todoapp.services.impl;

import loclt.practice.todoapp.dto.TaskDTO;
import loclt.practice.todoapp.entities.Task;
import loclt.practice.todoapp.exception.GlobalExceptionHandler;
import loclt.practice.todoapp.exception.ResourceNotFoundException;
import loclt.practice.todoapp.repositories.TaskRepository;
import loclt.practice.todoapp.services.TaskService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<TaskDTO> getAllTasks() {
        return taskRepository.findAll()
                .stream()
                .map((task -> modelMapper.map(task, TaskDTO.class)))
                .toList();
    }

    @Override
    public TaskDTO addTask(TaskDTO taskDTO) {
        //Convert DTO to entity
        Task taskConvert = mapToEntity(taskDTO, Task.class);
        Task task = taskRepository.save(taskConvert);
        return mapToDTO(task, TaskDTO.class);
    }

    @Override
    public TaskDTO updateTask(long id, TaskDTO taskDTO) {
        Task task = taskRepository.findTaskById(id).orElseThrow(() -> new ResourceNotFoundException("Task", "id", id));
        task.setTitle(taskDTO.getTitle());
        task.setCompleted(taskDTO.isCompleted());
        Task taskUpdated = taskRepository.save(task);
        return mapToDTO(taskUpdated, TaskDTO.class);
    }

    @Override
    public void deleteTask(long id) {
        Task task = taskRepository.findTaskById(id).orElseThrow(() -> new ResourceNotFoundException("Task", "id", id));
        if (task != null) {
            taskRepository.delete(task);
        }
    }

    private <T, U> U mapToEntity(T dto, Class<U> entity) {
        return modelMapper.map(dto, entity);
    }

    private <T, U> U mapToDTO(T entity, Class<U> dto) {
        return modelMapper.map(entity, dto);
    }
}

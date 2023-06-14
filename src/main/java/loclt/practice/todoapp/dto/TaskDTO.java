package loclt.practice.todoapp.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Data
public class TaskDTO {
    private Long id;
    @NotEmpty(message = "Không được để trống")
    private String title;
    private boolean isCompleted;
}

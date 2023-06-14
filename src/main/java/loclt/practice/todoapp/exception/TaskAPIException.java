package loclt.practice.todoapp.exception;

import org.springframework.http.HttpStatus;
public class TaskAPIException extends RuntimeException{
    private HttpStatus status;
    private String message;

    public TaskAPIException(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public TaskAPIException(String message, HttpStatus status, String message1) {
        super(message);
        this.status = status;
        this.message = message1;
    }
    @Override
    public String getMessage() {
        return message;
    }
}

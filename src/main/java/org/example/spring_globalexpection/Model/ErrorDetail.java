package org.example.spring_globalexpection.Model;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class ErrorDetail {
    private String message;
    private String details;
    private LocalDateTime timestamp;
}

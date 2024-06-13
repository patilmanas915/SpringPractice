package org.example.spring_globalexpection.WebLayer;

import org.example.spring_globalexpection.Model.ErrorDetail;
import org.example.spring_globalexpection.Model.StudentExpection;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class StudentControllerExceptionHandler {

    @ExceptionHandler(StudentExpection.class)
    public ResponseEntity<ErrorDetail> handleStudentException(StudentExpection ex) {
        ErrorDetail errorDetail = new ErrorDetail();
        errorDetail.setMessage(ex.getMessage());
        errorDetail.setDetails("Error in StudentController");
        errorDetail.setTimestamp(LocalDateTime.now());
        return new ResponseEntity<>(errorDetail, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetail> handleException(Exception ex) {
        ErrorDetail errorDetail = new ErrorDetail();
        errorDetail.setMessage(ex.getMessage());
        errorDetail.setDetails("Error in StudentController");
        errorDetail.setTimestamp(LocalDateTime.now());
        return new ResponseEntity<>(errorDetail, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}

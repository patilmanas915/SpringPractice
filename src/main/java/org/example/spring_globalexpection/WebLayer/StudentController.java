package org.example.spring_globalexpection.WebLayer;

import org.example.spring_globalexpection.Model.Student;
import org.example.spring_globalexpection.ServiceLayer.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {

    @Autowired
    private IStudentService studentService;

    @PostMapping("/add")
    public ResponseEntity<String> addStudent(@RequestBody Student student) {
        return new ResponseEntity<String>(studentService.addStudent(student), HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateStudent(@RequestBody Student student) {
        return new ResponseEntity<String>(studentService.updateStudent(student), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable int id) {
        return new ResponseEntity<String>(studentService.deleteStudent(id), HttpStatus.OK);
    }

    @GetMapping("/students")
    public ResponseEntity<Object> getAllStudents() {
        return new ResponseEntity<>(studentService.getAllStudents(), HttpStatus.OK);
    }

}

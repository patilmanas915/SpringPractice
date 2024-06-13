package org.example.spring_globalexpection.ServiceLayer;

import org.example.spring_globalexpection.Model.Student;

import java.util.List;

public interface IStudentService {

    public String addStudent(Student student);
    public String updateStudent(Student student);
    public String deleteStudent(int id);
    public List<Student> getAllStudents();
}

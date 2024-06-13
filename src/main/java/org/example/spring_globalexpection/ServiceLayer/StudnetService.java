package org.example.spring_globalexpection.ServiceLayer;

import org.example.spring_globalexpection.Daolayer.IStudentDao;
import org.example.spring_globalexpection.Model.Student;
import org.example.spring_globalexpection.Model.StudentExpection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudnetService implements IStudentService {

    @Autowired
    private IStudentDao studentDao;

    @Override
    public String addStudent(Student student) {
        studentDao.findByEmail(student.getEmail()).ifPresent(s -> {
            throw new StudentExpection("Student already exist with email " + student.getEmail());
        });
        return "Student added successfully With " + studentDao.save(student).getId();
    }

    @Override
    public String updateStudent(Student student) {
        Student s = studentDao.findByEmail(student.getEmail()).orElseThrow(() -> {
            throw new StudentExpection("Student not found with email " + student.getEmail());
        });
        s.setName(student.getName());
        s.setAddress(student.getAddress());

        return "Student updated successfully With " + studentDao.save(s).getId();
    }

    @Override
    public String deleteStudent(int id) {
        studentDao.findById(id).orElseThrow(() -> {
            throw new StudentExpection("Student not found with id " + id);
        });
        studentDao.deleteById(id);
        return "Student deleted successfully With " + id;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentDao.findAll();
    }
}

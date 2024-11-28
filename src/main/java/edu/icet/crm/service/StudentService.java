package edu.icet.crm.service;

import edu.icet.crm.model.Student;

import java.util.List;

public interface StudentService {
    Student persist(Student student);

    List<Student> getAllStudents();

    Student updateStudent(Student student, Long id);

    boolean deleteStudent(Long id);

    Student searchStudent(Long id);
}

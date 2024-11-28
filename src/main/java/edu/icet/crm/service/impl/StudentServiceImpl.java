package edu.icet.crm.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.icet.crm.entity.StudentEntity;
import edu.icet.crm.model.Student;
import edu.icet.crm.repository.StudentRepository;
import edu.icet.crm.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository repository;
    private final ObjectMapper mapper;
    @Override
    public Student persist(Student student) {
        StudentEntity saveEntity = repository.save(
                mapper.convertValue(student, StudentEntity.class));
        return mapper.convertValue(
                saveEntity,Student.class);
    }

    @Override
    public List<Student> getAllStudents() {
        Iterable<StudentEntity> studentEntities = repository.findAll();
        List<Student> studentList =new ArrayList<>();

        for(StudentEntity studentEntity:studentEntities){
            studentList.add(mapper.convertValue(studentEntity,Student.class));
        }
        return studentList;
    }

    @Override
    public Student updateStudent(Student student, Long id) {
        Optional<StudentEntity> studentEntity = repository.findById(id);
        StudentEntity newEntity = mapper.convertValue(
                                     student, StudentEntity.class);

       if(studentEntity.isPresent()){
           StudentEntity  oldEntity = studentEntity.get();
           oldEntity.setStudentName(newEntity.getStudentName());
           oldEntity.setStudentAge(newEntity.getStudentAge());
           oldEntity.setStudentContact(newEntity.getStudentContact());
           oldEntity.setGuardianName(newEntity.getGuardianName());
           oldEntity.setGurdianAdderss(newEntity.getGurdianAdderss());
           oldEntity.setGurdianContact(newEntity.getGurdianContact());


           repository.save(oldEntity);
           return student;

       }
       return mapper.convertValue(studentEntity.get(),Student.class);

    }

    @Override
    public boolean deleteStudent(Long id) {
       repository.deleteById(id);
       return true;
    }

    @Override
    public Student searchStudent(Long id) {
       return mapper.convertValue(
               repository.findById(id).get(),Student.class);
    }
}

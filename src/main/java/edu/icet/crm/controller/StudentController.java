package edu.icet.crm.controller;

import edu.icet.crm.model.Student;
import edu.icet.crm.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin

public class StudentController {

    private final StudentService service;


    @PostMapping("/student")
    public Student persist(@RequestBody Student student) {

        return service.persist(student);

    }

    @GetMapping("/getStudent")
    public List<Student>getAllStudents(){
        return service.getAllStudents();

    }

    @PutMapping("/updateStudent/id")
    public Student updateStuent(@RequestBody Student student,@RequestParam Long id){
        return service.updateStudent(student,id);
    }


    @DeleteMapping("/deleteStudent/id")
    public boolean deleteStudent(@RequestParam Long id){

      return   service.deleteStudent(id);

    }



    @GetMapping("/searchStudent/id")
    public Student searchStudent(@RequestParam Long id){
        return service.searchStudent(id);
    }


}

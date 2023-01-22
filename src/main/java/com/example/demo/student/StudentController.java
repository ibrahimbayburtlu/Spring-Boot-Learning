package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//  It can be considered as a combination of @Controller and @ResponseBody annotations
@RestController
//  It is used to map the web requests.
@RequestMapping(path = "api/v1/student")
public class StudentController {
    private final StudentService studentService;
    //  Spring provides annotation-based auto-wiring by providing @Autowired annotation. It is used to autowire spring bean on setter methods, instance variable, and constructor
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    // It maps the HTTP GET requests on the specific handler method.
    @GetMapping
    public List<Student> getStudents(){
        return studentService.getStudents();
    }
    // It maps the HTTP POST requests on the specific handler method.
    @PostMapping
    public void registerNewStudent(@RequestBody Student student){
        studentService.addNewStudent(student);
    }
    // It maps the HTTP DELETE requests on the specific handler method.
    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId){
        studentService.deleteStudent(studentId);
    }
    //  It maps the HTTP PUT requests on the specific handler method
    @PutMapping(path = "{studentId}")
    public void updateStudent(
            // It is used to extract the values from the URI
            @PathVariable("studentId") Long studentId,
            //  It is used to extract the query parameters form the URL
            @RequestParam(required = false) String name,
            //  It is used to extract the query parameters form the URL.
            @RequestParam(required = false) String email){
        studentService.updateStudent(studentId,name,email);
    }
}

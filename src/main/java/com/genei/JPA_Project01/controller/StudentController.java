package com.genei.JPA_Project01.controller;

import com.genei.JPA_Project01.entity.Student;
import com.genei.JPA_Project01.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/std")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/save")
    public Student createStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    @GetMapping("all")
    public List<Student> getAllStudents()
    {
        List<Student> allStudentData =  studentService.getAllStudentsData();
        return allStudentData;
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Integer id)
    {
        return studentService.getStudentById(id);
    }

    @GetMapping
    public Student getStudentById(@RequestParam int id, @RequestParam String name)
    {
        return studentService.getStudentById(id);
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Integer id, @RequestBody Student student)
    {
        Student updatedStudent = studentService.updateStudent(id, student);
        return updatedStudent;
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable Integer id) {
       boolean deleteStudent = studentService.deleteStudent(id);
       return "Deleted Sucessfully";

    }






}

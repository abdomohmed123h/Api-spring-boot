package com.example.demo.Conteroler;

import com.example.demo.Servse.Student_servisinterface;
import com.example.demo.model.Stutnt;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/root")

public class Student_conteroller {
    @Autowired
    Student_servisinterface student_servisinterface;

    @PostMapping("/save")
    public ResponseEntity<?> saveStudent(@RequestBody Stutnt student) {
        if (student.getId() != null) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", "ID should not be provided");
            return ResponseEntity.badRequest().body(errorResponse);
        }
        student_servisinterface.sevestudent(student);

        return ResponseEntity.status(HttpStatus.CREATED).body(student);
    }
    @PutMapping("/uptdte")
    public ResponseEntity<?> updateStudent(@RequestBody Stutnt student) {
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("error", "ID should not rellloe");
        boolean stute =student_servisinterface.updetstudent(student);
        if (stute) {
            return ResponseEntity.status(HttpStatus.OK).body(student);
        }else {
            return ResponseEntity.badRequest().body(errorResponse);
        }

    }
    @DeleteMapping("/delet/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable Long id) {
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("error", "ID should not find");
        Map<String,String> response = new HashMap<>();
        response.put("sussed" ,"deleted");

        if (student_servisinterface.delstudent(id)){
            return ResponseEntity.status(HttpStatus.OK).body(response);

        }else {
            return ResponseEntity.badRequest().body(errorResponse);
        }

}
    @GetMapping("getbyid/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable Long id) {
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("error", "ID should not find");
        if (student_servisinterface.findById(id) ==null){
            return ResponseEntity.badRequest().body(errorResponse);
        }else {
            return ResponseEntity.status(HttpStatus.OK).body(student_servisinterface.findById(id));
        }
    }
    @GetMapping()
    public ResponseEntity<?> getAllStudents() {
        return ResponseEntity.status(HttpStatus.OK).body(student_servisinterface.findAll());
    }
    @GetMapping("get/by/{name}")
    public ResponseEntity<?> getStudentByName(@PathVariable String name) {
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("error", "ID should not find");
        if (student_servisinterface.findByName(name) ==null){
            return ResponseEntity.badRequest().body(errorResponse);
        }else {
            return ResponseEntity.status(HttpStatus.OK).body(student_servisinterface.findByName(name));
        }
    }
    @GetMapping("/gitincluding/{name}")
    public ResponseEntity<Object> getStudentByGitIncluding(@PathVariable String name) {
        Object result = student_servisinterface.findicloding(name);

        if (result == null) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", "I can not find");
            return ResponseEntity.badRequest().body(errorResponse);
        }

        return ResponseEntity.ok(result);
    }




}



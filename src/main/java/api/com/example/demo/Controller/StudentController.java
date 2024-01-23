package api.com.example.demo.Controller;

import api.com.example.demo.Entity.Student;
import api.com.example.demo.ServiceImplementation.StudentService;
import api.com.example.demo.dto.StudentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/")
    public ResponseEntity<StudentDto> enregistrer(@RequestBody StudentDto studentDto){
        return  ResponseEntity.ok(studentService.Enregistrer(studentDto));
    }

    @GetMapping("/")
    public ResponseEntity<List<StudentDto>> getAllStudent(){
        return ResponseEntity.ok(studentService.getListStudent());
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentDto> updateStudent(@RequestBody StudentDto studentDto, @PathVariable int id){
        studentDto.setId(id);
        return ResponseEntity.ok(studentService.Enregistrer(studentDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> getOneStudent(@PathVariable int id){
        return ResponseEntity.ok(studentService.getOneStudent(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable int id){
        studentService.deleteStudent(id);
        return ResponseEntity.accepted().build();
    }
}

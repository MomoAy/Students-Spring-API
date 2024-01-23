package api.com.example.demo.ServiceImplementation;

import api.com.example.demo.Entity.Student;
import api.com.example.demo.Repository.StudentRepository;
import api.com.example.demo.Service.IStudentService;
import api.com.example.demo.dto.StudentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class StudentService implements IStudentService {


    @Autowired
    private StudentRepository studentRepository;

    @Override
    public StudentDto Enregistrer(StudentDto studentDto) {
        return convertEntityToDto(studentRepository.save(convertDtoToEntity(studentDto)));
    }

    @Override
    public List<StudentDto> getListStudent() {
        List<Student> getAllStudent = studentRepository.findAll();
        return getAllStudent.stream().map(produit -> convertEntityToDto(produit)).collect(Collectors.toList());
    }

    @Override
    public StudentDto getOneStudent(int id) {
        Student student = studentRepository.findById(id).get();
        if (student == null) new RuntimeException("L'id de l'étudiant n'existe pas");
        return convertEntityToDto(student);
    }

    @Override
    public void deleteStudent(int id) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new RuntimeException("L'étudiant à supprimer n'existe pas"));
        studentRepository.delete(student);
    }

    @Override
    public StudentDto convertEntityToDto(Student student) {
        return StudentDto.builder()
                .name(student.getName())
                .email(student.getEmail())
                .dob(student.getDob())
                .age(student.getAge())
                .build();
    }

    @Override
    public Student convertDtoToEntity(StudentDto studentDto) {
        return Student.builder()
                .id(studentDto.getId())
                .name(studentDto.getName())
                .email(studentDto.getEmail())
                .dob(studentDto.getDob())
                .age(studentDto.getAge())
                .build();
    }
}

package api.com.example.demo.Service;

import api.com.example.demo.Entity.Student;
import api.com.example.demo.dto.StudentDto;

import java.util.List;

public interface IStudentService {
    public StudentDto Enregistrer(StudentDto studentDto);

    public List<StudentDto> getListStudent();

    public StudentDto getOneStudent(int id);

    public void deleteStudent(int id);

    public StudentDto convertEntityToDto(Student student);

    public Student convertDtoToEntity(StudentDto studentDto);
}

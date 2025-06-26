package net.javaguides.sms.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import net.javaguides.sms.entity.Student;
import net.javaguides.sms.repository.StudentRepository;
import net.javaguides.sms.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	private StudentRepository studentrepository;
	
	public StudentServiceImpl(StudentRepository studentrepository) {
		super();
		this.studentrepository = studentrepository;
	}

	@Override
	public List<Student> getAllStudents() {
		
		return studentrepository.findAll();
	}

	@Override
	public Student saveStudent(Student student) {
		
		return studentrepository.save(student);
	}
	
	@Override
	public Student getStudentById(Long id) {
	    return studentrepository.findById(id)
	            .orElseThrow(() -> new RuntimeException("Student not found"));
	}

	@Override
	public void updateStudent(Student student) {
	    studentrepository.save(student);
	}

	@Override
	public void deleteStudentById(Long id) {
	    studentrepository.deleteById(id);
	}

	
}

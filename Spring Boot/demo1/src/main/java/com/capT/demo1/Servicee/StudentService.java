package com.capT.demo1.Servicee;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capT.demo1.Entity.Student;
import com.capT.demo1.Repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository repo;

	public StudentService() {
	}
	public Student saveStudent(Student s)
	{
		return repo.save(s);
	}
	
	public Student findStudentById(int id)
	{
//		Optional<Student> op = repo.findById(id);
//		return op.get();
		return repo.findById(id).orElse(null);
	}

	public boolean deleteStudent(Student s)
	{
		if(repo.findById(s.getId()).orElse(null)==null)
			return false;
		repo.delete(s);
		return true;
	}
	public boolean deleteStudentById(int id)
	{
		if(repo.findById(id).orElse(null)==null)
			return false;
		
		repo.deleteById(id);
		return true;
	}
	public List<Student> findAllStudents()
	{
		return repo.findAll();
	}
	public List<Student> saveAllStudents(List<Student> stu)
	{
		return repo.saveAll(stu);
	}
	
}

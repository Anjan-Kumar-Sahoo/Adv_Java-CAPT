package com.capT.StudentMS.Service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.capT.StudentMS.Entity.Student;
import com.capT.StudentMS.Exception.StudentNotFoundException;
import com.capT.StudentMS.Repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository repo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public Student saveStudent(Student s)
	{
		s.setPassword(passwordEncoder.encode(s.getPassword()));
		return repo.save(s);	
	}
	@PostAuthorize("returnObject.email == authentication.name or hasRole('ROLE_ADMIN')")
	@Cacheable(value = "students", key = "#id")
	public Student findById(int id)
	{
		return repo.findById(id).orElseThrow(() 
		-> new StudentNotFoundException(" Student with "+id+" not  Founnd"));
	}
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@Cacheable(value = "allStudents")
	public List<Student> findAllStudnets()
	{
		return repo.findAll();
	}
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@Cacheable(value = "allStudentsPage", key = "#pageable")
	public Page<Student> findAllStudnets(Pageable pageable)
	{
		return repo.findAll(pageable);
	}
	@PostAuthorize("returnObject.email == authentication.name or hasRole('ROLE_ADMIN')")
	public Student updateStudent(int id,Student s)
	{
		Student old = repo.findById(id).orElseThrow(() 
		-> new StudentNotFoundException(" Student with "+id+" not  Founnd"));
		old.setName(s.getName());
		old.setEmail(s.getEmail());
		old.setCourse(s.getCourse());
		old.setMarks(s.getMarks());
		return repo.save(old);
	}
	@PostAuthorize("returnObject.email == authentication.name or hasRole('ROLE_ADMIN')")
	public Student deleteStudent(int id)
	{
		Student student = repo.findById(id).orElseThrow(() 
		-> new StudentNotFoundException(" Student with "+id+" not  Founnd"));
		repo.deleteById(id);
		return student;
	}
	public Student uploadProfileImage(int id, MultipartFile file) throws IOException
	{
		Student student = findById(id);
		student.setProfileImage(file.getBytes());
		return repo.save(student);
	}
	public Student uploadAssignmentFile(int id, MultipartFile file) throws IOException
	{
		Student student = findById(id);
		student.setAssignmentFile(file.getBytes());
		return repo.save(student);
	}
	public byte[] downloadProfileImage(int id)
	{
		Student student = findById(id);
		return student.getProfileImage();
	}
	public byte[] downloadAssignmentFile(int id)
	{
		Student student = findById(id);
		return student.getAssignmentFile();
	}
	
}

package com.capT.StudentMS.Controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.capT.StudentMS.Entity.Student;
import com.capT.StudentMS.Service.StudentService;

@RestController @RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService service;
	
	@PostMapping("/save")
	public Student saveStudent(
			@RequestParam String name,
			@RequestParam String email,
			@RequestParam String course,
			@RequestParam double marks,
			@RequestParam String role,
			@RequestParam String password,
			@RequestParam(required = false) MultipartFile profileImage,
			@RequestParam(required = false) MultipartFile assignmentFile) throws IOException
	{
		Student s = new Student();
		s.setName(name);
		s.setEmail(email);
		s.setCourse(course);
		s.setMarks(marks);
		s.setRole(role);
		s.setPassword(password);
		s.setProfileImage(profileImage.getBytes());
		s.setAssignmentFile(assignmentFile.getBytes());

		return service.saveStudent(s);
	}
	
	@GetMapping("/find")
	public List<Student> findAllStudents()
	{
		return service.findAllStudnets();
	}
	@GetMapping("/find/page")
	public Page<Student> findAllStudentsPaged(
			@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "5") int size)
	{
		return service.findAllStudnets(PageRequest.of(page, size, Sort.by("id")));
	}
	@GetMapping("/find/{id}")
	public Student findAllStudents(@PathVariable int id)
	{
		return service.findById(id);
	}
	@PutMapping("/update/{id}")
	public Student updateStudent(
			@PathVariable int id,
			@RequestParam String name,
			@RequestParam String email,
			@RequestParam String course,
			@RequestParam double marks)
	{
		Student s = new Student();
		s.setName(name);
		s.setEmail(email);
		s.setCourse(course);
		s.setMarks(marks);
		return service.updateStudent(id, s);
	}
	@DeleteMapping("/delete/{id}")
	public Student deleteStudent(@PathVariable int id)
	{
		return service.deleteStudent(id);
	}
	
	@PostMapping("/upload/profile/{id}")
	public String uploadProfileImage(@PathVariable int id, @RequestParam("file") MultipartFile file) throws IOException
	{
		service.uploadProfileImage(id, file);
		return "Profile image uploaded for student " + id;
	}
	@PostMapping("/upload/assignment/{id}")
	public String uploadAssignmentFile(@PathVariable int id, @RequestParam("file") MultipartFile file) throws IOException
	{
		service.uploadAssignmentFile(id, file);
		return "Assignment uploaded for student " + id;
	}
	@GetMapping("/download/profile/{id}")
	public ResponseEntity<byte[]> downloadProfileImage(@PathVariable int id)
	{
		return ResponseEntity.ok()
				.contentType(MediaType.IMAGE_JPEG)
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment")
				.body(service.downloadProfileImage(id));
	}
	@GetMapping("/download/assignment/{id}")
	public ResponseEntity<byte[]> downloadAssignmentFile(@PathVariable int id)
	{
		return ResponseEntity.ok()
				.contentType(MediaType.APPLICATION_PDF)
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment")
				.body(service.downloadAssignmentFile(id));
	}
	
}

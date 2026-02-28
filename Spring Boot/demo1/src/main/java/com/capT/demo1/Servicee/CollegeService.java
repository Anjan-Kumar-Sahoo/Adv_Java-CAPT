package com.capT.demo1.Servicee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capT.demo1.Entity.College;
import com.capT.demo1.Entity.Student;
import com.capT.demo1.Repository.CollegeRepository;

@Service
public class CollegeService {

	@Autowired
	private CollegeRepository repo;

	public CollegeService() {
	}
	
	public College findByName(String name)
	{
		return repo.findByName(name);
	}
	
	public College saveCollege(College s)
	{
		List<Student> students = s.getStudents();
		s.addStudents(students);
		return repo.save(s);
		
	}
	
	public College findStudentById(int id)
	{
//		Optional<Student> op = repo.findById(id);
//		return op.get();
		return repo.findById(id).orElse(null);
	}

	public boolean deleteCollege(College s)
	{
		if(repo.findById(s.getId()).orElse(null)==null)
			return false;
		repo.delete(s);
		return true;
	}
	public boolean deleteCollegeById(int id)
	{
		if(repo.findById(id).orElse(null)==null)
			return false;
		
		repo.deleteById(id);
		return true;
	}
	public List<College> findAllColleges()
	{
		return repo.findAll();
	}
	public List<College> saveAllColleges(List<College> clg)
	{
		return repo.saveAll(clg);
	}
}

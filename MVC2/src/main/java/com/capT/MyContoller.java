package com.capT;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

@Controller
public class MyContoller {
	
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
	static EntityManager em = emf.createEntityManager();
	static EntityTransaction et = em.getTransaction();

	@RequestMapping("/hii")
	public String takeRequest()
	{
		return "hiipage";
	}
	@RequestMapping("/login")
	public String login()
	{
		return "login";
	}
	@RequestMapping("/logout")
	public String logout()
	{
		return "logout";
	}
	@RequestMapping("/data")
	public String sendData(Model model)
	{
		model.addAttribute("name","Anjan");
		model.addAttribute("cgpa",7.51);
		return "data";
	}
	@RequestMapping("/mv")
	public ModelAndView senddata2(ModelAndView mv)
	{
		mv.addObject("name","Anjan");
		mv.addObject("cgpa",7.5);
		mv.setViewName("data");
		return mv;
	}
	@RequestMapping("/registerStudent")
	public String showForm() {
	    return "Stuform1";
	}

	@RequestMapping("/processForm1")
	public ModelAndView processForm1(
	        @RequestParam("name") String name,
	        @RequestParam("cgpa") String cgpa, // Spring can auto-convert String to double
	        @RequestParam("id") String id,        // Spring can auto-convert String to int
	        @RequestParam("collegeName") String collegeName,
	        @RequestParam("address") String address)
	{
	    Student s = new Student();
	    s.setId(id);
	    s.setName(name);
	    s.setCgpa(cgpa);
	    s.setCollegeName(collegeName);
	    s.setAddress(address);

	    try {
	        et.begin();
	        em.persist(s);
	        et.commit();
	        System.out.println("Successfully saved student via processForm1: " + name);
	    } catch (Exception e) {
	        if (et.isActive()) et.rollback();
	        e.printStackTrace();
	    }
	    
	    ModelAndView mv = new ModelAndView();
	    mv.addObject("s", s);
	    mv.setViewName("display"); 
	    
	    return mv;
	}
	
	@RequestMapping("/processForm")
	public ModelAndView processForm(@ModelAttribute Student s) {
	    System.out.println("--- Saving Student to DB ---");
	    

	        et.begin();
	        em.persist(s);
	        et.commit();
	        System.out.println("Success: Saved " + s.getName());


	    ModelAndView mv = new ModelAndView();
	    mv.addObject("s", s);
	    mv.setViewName("display"); 
	    return mv;
	}
	@RequestMapping("/searchStudent")
	public String showSearch() {
	    return "findStudent";
	}
	@RequestMapping("/findStudent")
	public ModelAndView findStudent(@RequestParam("id") String id)
	{
		
		
		ModelAndView mv = new ModelAndView();
		Student s = em.find(Student.class, id);
		
		 mv.addObject("s", s);
		 mv.setViewName("display"); 
		    
		 return mv;
	}
}

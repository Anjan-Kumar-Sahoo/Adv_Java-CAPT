package com.capT;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class EmployeeController {
	
	private EmployeeDAO dao = new EmployeeDAO();
	
	@ModelAttribute("contextPath")
	public String getContextPath(HttpServletRequest request)
	{
		return request.getContextPath();
	}
	
	@GetMapping("/home")
	public String home(Model model)
	{
		List<Employee> employees = dao.getAllEmployees();
		model.addAttribute("employees", employees);
		return "home";
	}
	
	@GetMapping("/add")
	public String showAddForm()
	{
		return "addEmployee";
	}
	
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute Employee employee, Model model)
	{
		dao.saveEmployee(employee);
		model.addAttribute("employee", employee);
		model.addAttribute("action", "save");
		return "display";
	}
	
	@GetMapping("/edit")
	public String showUpdateForm(@RequestParam("id") int id, Model model)
	{
		Employee employee = dao.getEmployeeById(id);
		model.addAttribute("employee", employee);
		return "updateEmployee";
	}
	
	@PostMapping("/update")
	public String updateEmployee(@RequestParam("id") int id, @ModelAttribute Employee employee, Model model)
	{
		dao.updateEmployee(id, employee);
		Employee updatedEmployee = dao.getEmployeeById(id);
		model.addAttribute("employee", updatedEmployee);
		model.addAttribute("action", "update");
		return "display";
	}
	
	@GetMapping("/delete")
	public String deleteEmployee(@RequestParam("id") int id, Model model)
	{
		dao.deleteEmployee(id);
		model.addAttribute("employeeId", id);
		model.addAttribute("action", "delete");
		return "display";
	}
}


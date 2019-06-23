package com;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {
	private final EmployeeRepository employeeRepository;

	public HomeController(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@RequestMapping(value = "/")
	public String index(Model model) {
		// Determine release data.
		String releaseVersion = coalesce(System.getenv("HEROKU_RELEASE_VERSION"),
				"vX");
		String releaseTimestamp = coalesce(System.getenv("HEROKU_RELEASE_CREATED_AT"),
				"1970-01-01T00:00:00Z");
		model.addAttribute("version", releaseVersion);
		model.addAttribute("timestamp", releaseTimestamp);

		// Determine employee data
		List<Employee> employees = new ArrayList<>();
		employeeRepository.findAll().forEach(employees::add);
		model.addAttribute("employees", employees);

		return "index";
	}

	private String coalesce(String a, String b) {
		if (a != null) {
			return a;
		}

		return b;
	}

}

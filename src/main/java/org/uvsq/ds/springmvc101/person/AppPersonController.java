package org.uvsq.ds.springmvc101.person;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/app/persons")
public class AppPersonController {
	
	private Logger logger = LoggerFactory.getLogger(AppPersonController.class);
	
	private PersonService personService;
	
	public AppPersonController(PersonService personService) {
		this.personService = personService;
		logger.info(this.getClass().getSimpleName()+" Creation");
	}

	@GetMapping({"", "/index"})
	public String indexAppPersons() {
		return "app/persons/index";
	}

	@GetMapping("/list")
	public String listAppPersons(Model model) {
		model.addAttribute("persons", personService.getAllPersons());
		return "app/persons/list";
	}
	
	@GetMapping("/view/{id}")
	public String viewAppPerson(@PathVariable Long id, Model model) {
		personService.getPersonById(id).ifPresent(p -> {
			model.addAttribute("person", p);
		});
		return "app/persons/view";
	}
	
	@GetMapping({ "/edit", "edit/{id}" })
	public String editForm(@PathVariable(required = false) Long id, Model model) {
		
		Person person = null;
		if (id != null) {
			Optional<Person> op = personService.getPersonById(id);
			if (op.isPresent()) {
				person = op.get();
			} 
		}
		if ( person == null ) {
			person = new Person();
		}
		model.addAttribute("person", person);
		return "app/persons/edit";
	}
	
	
	@PostMapping("/edit")
	public String editAppPerson(@ModelAttribute Person person, BindingResult result, Model model) {
		if ( result.hasErrors() ) {
			return "app/persons/edit";
		}
		Long id = person.getId();
		if ( id == null ) {
			personService.createPerson(person);	
		} else {
			Optional<Person> op = personService.getPersonById(id);
			if ( op.isPresent() ) {
				Person existing = op.get();
				existing.setFirstname(person.getFirstname());
				existing.setLastname(person.getLastname());
				personService.updatePerson(existing);
			}
		}

		model.addAttribute("id", person.getId());
		return "redirect:/app/persons/view/{id}";
	}


}

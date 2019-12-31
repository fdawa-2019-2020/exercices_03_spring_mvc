package org.uvsq.ds.springmvc101.project;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api")
public class ProjectController {

	private ProjectService projectService;
	private Logger logger = LoggerFactory.getLogger(ProjectController.class);

	public ProjectController(ProjectService projectService) {
		this.projectService = projectService;
	}

	@GetMapping(path="/projects")
	@ResponseBody
	public List<Project> getAllProjects() {
		return projectService.getAllProjects();
	}

	@GetMapping(path="/search-projects")
	@ResponseBody
	public List<Project> searchProjects(@RequestParam(required = false, defaultValue = "OPENED") State state, 
										@RequestParam(required = false) Nature nature,
										@RequestParam(required = false) List<String> tags) {
		logger.info("SearchProjects with {}, {}, {}", state, nature, tags);
		return projectService.getAllProjects().stream()
				.filter(p -> state == null || p.getState() ==  state)
				.filter(p -> nature == null || p.getNature() ==  nature)
				.filter(p -> tags == null || p.getTags().containsAll(tags))
				.collect(toList());
	}

	
	
	@PostMapping("/projects-random")
	@ResponseBody
	public Project createRandomProject() {
		Project project = new Project();
		project.setName(UUID.randomUUID().toString());
		project.setNature(Nature.OPEN);
		Project created = projectService.createProject(project);
		return created;
	}

	@PostMapping("/projects")
	@ResponseBody
	public Project createProject(@RequestBody Project project) {
		return projectService.createProject(project);
	}
	
	@GetMapping("/projects/{id}")
	@ResponseBody Project getProjectById(@PathVariable Long id) {
		return projectService.getProjectById(id).orElse(null);
	}
	
	
	@GetMapping("/natures")
	@ResponseBody
	public List<String> getNatures() {
		return Arrays.stream(Nature.values()).map(Nature::name).collect(toList());
	}
	
	@GetMapping("/states")
	@ResponseBody
	public List<String> getStates() {
		return Arrays.stream(State.values()).map(State::name).collect(toList());
	}
	
	@GetMapping("/natures/{nature}/projects")
	@ResponseBody
	public List<Project> getProjectByNature(@PathVariable Nature nature) {
		return projectService.getAllProjects().stream().filter(p -> p.getNature() ==  nature).collect(toList());
	}

	@GetMapping("/states/{state}/projects")
	@ResponseBody
	public List<Project> getProjectByState(@PathVariable State state) {
		return projectService.getAllProjects().stream().filter(p -> p.getState() ==  state).collect(toList());
	}

	@GetMapping("/natures/{nature}/states/{state}/projects")
	@ResponseBody
	public List<Project> getProjectByNatureAndStatus(@PathVariable Nature nature, @PathVariable State state) {
		return projectService.getAllProjects().stream()
			.filter(p -> p.getNature() ==  nature)
			.filter(p -> p.getState() == state)
			.collect(toList());
	}	
	
	@GetMapping("/natures/{nature}/tags/{tags}/projects")
	@ResponseBody
	public List<Project> getProjectByNatureAndTag(@PathVariable Nature nature, @PathVariable List<String> tags) {
		return projectService.getAllProjects().stream()
			.filter(p -> p.getNature() ==  nature)
			.filter(p -> p.getTags().containsAll(tags))
			.collect(toList());
	}
	
	
	
		
}

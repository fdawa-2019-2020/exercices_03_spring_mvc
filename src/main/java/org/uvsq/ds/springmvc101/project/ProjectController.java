package org.uvsq.ds.springmvc101.project;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ProjectController {

	private ProjectService projectService;

	public ProjectController(ProjectService projectService) {
		this.projectService = projectService;
	}

	@GetMapping("/projects")
	@ResponseBody
	public List<Project> getAllProjects() {
		return projectService.getAllProjects();
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

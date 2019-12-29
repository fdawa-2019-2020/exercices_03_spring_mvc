package org.uvsq.ds.springmvc101.project;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
		return projectService.getProjectById(id);
	}
}

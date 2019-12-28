package org.uvsq.ds.springmvc101.project;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ProjectController {
	
	private ProjectService projectService;

	public ProjectController(ProjectService projectService) {
		this.projectService = projectService;
	}

	@RequestMapping("/projects")
	@ResponseBody
	public List<Project> getAllProjects() {
		return projectService.getAllProjects();
	}
}

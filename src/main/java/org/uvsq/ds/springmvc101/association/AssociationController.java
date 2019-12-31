package org.uvsq.ds.springmvc101.association;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api/associations")
public class AssociationController {
	
	private AssociationService service;

	public AssociationController(AssociationService service) {
		this.service = service;
	}

	@PostMapping("")
	@ResponseBody
	public Association createAssociation(@RequestBody Association association) {
		return this.service.createOrUpdate(association);
	}

	@DeleteMapping("/persons/{personId}/project/{projectId}")
	@ResponseBody
	public Association deleteAssociation(@PathVariable Long personId, @PathVariable Long projectId) {
		Association association = new Association();
		association.setPersonId(personId);
		association.setProjectId(projectId);
		Integer rate = this.service.delete(association);
		association.setRate(rate);
		return association;
	}

	
	
	@GetMapping("")
	@ResponseBody
	public List<Association> getAllAssociations() {
		return  this.service.getAllAssociations();
	}


}

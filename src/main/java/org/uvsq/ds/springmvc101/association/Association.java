package org.uvsq.ds.springmvc101.association;

public class Association {

	private Long projectId;
	private Long personId;
	private Integer rate;
	
	
	public Long getProjectId() {
		return projectId;
	}
	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}
	public Long getPersonId() {
		return personId;
	}
	public void setPersonId(Long personId) {
		this.personId = personId;
	}
	public Integer getRate() {
		return rate;
	}
	public void setRate(Integer rate) {
		this.rate = rate;
	}
	@Override
	public String toString() {
		return "Association [projectId=" + projectId + ", personId=" + personId + ", rate=" + rate + "]";
	}
	
	
	
	
}

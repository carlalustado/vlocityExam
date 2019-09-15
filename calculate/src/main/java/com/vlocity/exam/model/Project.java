package com.vlocity.exam.model;

import java.util.Date;
import java.util.List;

public class Project {

	private String projectName;
	private Integer projectID;
	private Date startDate;
	private Date endDate;
	private String description;
	private String status;
	private List<Tasks> tasks;

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public Integer getProjectID() {
		return projectID;
	}

	public void setProjectID(Integer projectID) {
		this.projectID = projectID;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Tasks> getTasks() {
		return tasks;
	}

	public void setTasks(List<Tasks> tasks) {
		this.tasks = tasks;
	}
	
	@Override
	public String toString() {
		return "Project [projectName=" + projectName + ", projectID=" + projectID + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", description=" + description + ", status=" + status + ", tasks=" + tasks
				+ "]";
	}
}

package com.vlocity.exam.model;

import java.util.Date;

public class Tasks {

	private String taskName;
	private Integer taskId;
	private Long duration;
	private Date startDate;
	private Date endDate;
	private String status;
	private Boolean isDependent;

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public Integer getTaskId() {
		return taskId;
	}

	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}

	public Long getDuration() {
		return duration;
	}

	public void setDuration(Long duration) {
		this.duration = duration;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Boolean getIsDependent() {
		return isDependent;
	}

	public void setIsDependent(Boolean isDependent) {
		this.isDependent = isDependent;
	}
	
	@Override
	public String toString() {
		return "Tasks [taskName=" + taskName + ", taskId=" + taskId + ", duration=" + duration + ", startDate="
				+ startDate + ", endDate=" + endDate + ", status=" + status + ", isDependent=" + isDependent + "]";
	}
}

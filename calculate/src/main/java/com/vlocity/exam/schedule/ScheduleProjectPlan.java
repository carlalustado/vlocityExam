package com.vlocity.exam.schedule;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.vlocity.exam.model.Project;

public class ScheduleProjectPlan {

	private static final Log LOGGER = LogFactory.getLog(ScheduleProjectPlan.class);
	
	public void createSchedule(Project project) {
		LOGGER.info("createSchedule starting...");
		
		
	}
	
	private void validateParams(Project project) {
		if (project.getProjectID() != null && StringUtils.isNotBlank(project.getProjectName())) {
			
		}
	}
	
	
}

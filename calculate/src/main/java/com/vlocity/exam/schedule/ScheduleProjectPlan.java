package com.vlocity.exam.schedule;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.vlocity.exam.model.Project;
import com.vlocity.exam.model.Tasks;
import com.vlocity.exam.model.TasksEnum;

public class ScheduleProjectPlan {

	private static final Log LOGGER = LogFactory.getLog(ScheduleProjectPlan.class);
	
	public void createSchedule(Project project) {
		LOGGER.info("createSchedule starting...");
		
		if (project != null) {
			if (project.getProjectID() != null && StringUtils.isNotBlank(project.getProjectName())) {
				if (CollectionUtils.isNotEmpty(project.getTasks())) {
					for (Tasks task : project.getTasks()) {
						
					}
				} else {
					List<Tasks> tasks = new ArrayList<Tasks>();
					
					Tasks task = new Tasks();
					task.setTaskId(1);
					task.setTaskName("MOBILIZATION");
					task.setStatus("");
					task.setIsDependent(false);
					task.setDuration(TasksEnum.MOBILIZATION);
					task.setEndDate(endDate);
					task.setStartDate(startDate);
					
				}
			}
		} else {
			// create new project
		}
	}
	
}

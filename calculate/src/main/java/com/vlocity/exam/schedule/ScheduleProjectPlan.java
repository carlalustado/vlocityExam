package com.vlocity.exam.schedule;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
						// validations and ordering
					}
				} else {
					List<Tasks> tasks = new ArrayList<Tasks>();
					
					Tasks task = new Tasks();
					task.setTaskId(1);
					task.setTaskName("MOBILIZATION");
					task.setStatus("Not Started");
					task.setIsDependent(false);
					
					Long duration = Long.valueOf(TasksEnum.MOBILIZATION.getValue());
					task.setDuration(duration);
					
					task.setStartDate(project.getStartDate());

					Calendar c = Calendar.getInstance();
					c.setTime(project.getStartDate());
					int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
					
					duration = (duration / 9) - 1;
					
					c.add(dayOfWeek, duration.intValue());
					
					task.setEndDate(c.getTime());
					
					tasks.add(task);
				}
			}
		} else {
			// create new project
		}
	}
	
	public Project createProject(String name, Date startDate, Date endDate) {
		
		Project project = new Project();
		
		project.setProjectName(name);
		project.setStartDate(startDate);
		project.setEndDate(endDate);
		
		return project;
	}
	
	public Tasks createTask(String name, String status, Boolean isDependent, Date startDate) {
		
		Tasks task = new Tasks();
		task.setTaskId(1);
		task.setTaskName(name);
		task.setStatus(status);
		task.setIsDependent(isDependent);
		
		Long duration = Long.valueOf(TasksEnum.MOBILIZATION.getValue());
		task.setDuration(duration);
		
		task.setStartDate(startDate);

		Calendar c = Calendar.getInstance();
		c.setTime(startDate);
		int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
		
		duration = (duration / 9) - 1;
		
		c.add(dayOfWeek, duration.intValue());
		
		task.setEndDate(c.getTime());
		
		return task;
	}
}

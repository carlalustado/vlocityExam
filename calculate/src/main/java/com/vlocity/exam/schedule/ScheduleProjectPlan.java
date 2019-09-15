package com.vlocity.exam.schedule;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.vlocity.exam.common.DateUtils;
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
		}
	}
	
	public Project createProject() {
		
		Project project = null;
		
		try {
			Scanner input = new Scanner(System.in);
			System.out.print("Project Name: ");
			String projName = input.next();
			
			System.out.print("Project Start date (MM-dd-yyyy): ");
			String projStartDate = input.next();
			Date sd = null;
        	if(StringUtils.isNotBlank(projStartDate)) {
        		sd = DateUtils.stringToDate(projStartDate);
        	} else {
        		throw new ParseException(projStartDate, 1);
        	}
			
			System.out.print("Project End date (MM-dd-yyyy): ");
			String projEndDate = input.next();
			Date ed = null;
        	if(StringUtils.isNotBlank(projEndDate)) {
        		ed = DateUtils.stringToDate(projEndDate);
        	} else {
        		throw new ParseException(projEndDate, 1);
        	}
        	
        	project = new Project();
			project.setProjectName(projName);
			project.setStartDate(sd);
			project.setEndDate(ed);
			
		} catch(Exception e) {
			System.out.println("Error creating project");
			return null;
		}

		System.out.println("Project created!");
		System.out.println("Project: ");
		System.out.println("Project Name: " + project.getProjectName());
		System.out.println("Project Start date: " + DateUtils.formatDate(project.getStartDate()));
		System.out.println("Project End date: " + DateUtils.formatDate(project.getEndDate()));
		
		return project;
	}
	
	public boolean validateProject(Project project) {
		
		if (project != null && project.getStartDate() != null && project.getEndDate() != null) {
			if (project.getStartDate().after(project.getEndDate())) {
				System.out.println("End date cannot be before start date");
				return false;
			}
			return true;
		} else {
			System.out.println("Error creating project");
			return false;
		}
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

package com.vlocity.exam.schedule;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import com.vlocity.exam.common.DateUtils;
import com.vlocity.exam.model.Project;
import com.vlocity.exam.model.Tasks;
import com.vlocity.exam.model.TasksEnum;

public class ScheduleProjectPlan {

	public void createSchedule(Project project) {
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
			Date sd = DateUtils.stringToDate(projStartDate);
			
			System.out.print("Project End date (MM-dd-yyyy): ");
			String projEndDate = input.next();
			Date ed = DateUtils.stringToDate(projEndDate);
        	
        	project = new Project();
			project.setProjectName(projName);
			project.setStartDate(sd);
			project.setEndDate(ed);
			
		} catch(Exception e) {
			System.out.println("Error creating project");
			System.out.println("-------------------------------------------------");
			return null;
		}

		return project;
	}
	
	public boolean validateProject(Project project) {
		
		if (project != null && project.getStartDate() != null && project.getEndDate() != null) {
			if (project.getStartDate().after(project.getEndDate())) {
				System.out.println("End date cannot be before start date");
			}
			
			System.out.println("------Project created!------");
			System.out.println("Name: " + project.getProjectName());
			System.out.println("Start date: " + DateUtils.formatDate(project.getStartDate()));
			System.out.println("End date: " + DateUtils.formatDate(project.getEndDate()));
			
			return true;
		} else {
			System.out.println("Error creating project");
			return false;
		}
	}
	
	
	public Tasks createTask(String name, Long duration, Date startDate, Date endDate) {
		Tasks task = new Tasks();
		task.setTaskId(1); // TODO
		task.setTaskName(name);
		task.setStatus("Not Started");
		task.setDuration(duration);
		task.setStartDate(startDate);
		task.setEndDate(endDate);
		
		return task;
	}
	
	public List<Tasks> createTasks(Project project, List<Tasks> tasks) {
		
		System.out.println("-------------------------------------------------");
		System.out.println("Please create task:");
		
		Scanner input = new Scanner(System.in);
		System.out.print("Task Name: ");
		String taskName = input.next();
		
		System.out.print("Task duration in hours: ");
		String taskDuration = input.next();
		
		Long duration = Long.parseLong(taskDuration);
		Date dtEnd = computeDateDuration(project.getStartDate(), duration);
		if (CollectionUtils.isEmpty(tasks)) {
			duration = (duration / 9) - 1;
			Tasks task = createTask(taskName, duration, project.getStartDate(), dtEnd);
			tasks.add(task);
			
			System.out.print("Task added! Add more tasks? (Y/N): ");
			String addMore = input.next();
			if (StringUtils.equalsIgnoreCase(addMore, "Y")) {
				tasks = createTasks(project, tasks);
				
				Long dtDuration = duration / 9;
				Date dtStart = computeDateDuration(tasks.get(0).getEndDate(), dtDuration);
				dtDuration = (dtDuration / 9) - 1;
				dtEnd = computeDateDuration(dtStart, dtDuration);
				
				task = createTask(taskName, duration, dtStart, dtEnd);
				tasks.add(task);
			} else {
				System.out.print("Task added!");
			}
			
			if (CollectionUtils.isNotEmpty(tasks)) {
				for (Tasks temp : tasks) {
					System.out.println("Name: " + temp.getTaskName());
					System.out.println("Start date: " + temp.getStartDate());
					System.out.println("End date: " + temp.getEndDate());
					System.out.println("-------------------------------------------------");
				}
			}
		} else {
			System.out.print("Is task dependent to any tasks? (Y/N): ");
			String isDependent = input.next();
			if (StringUtils.equals(isDependent, "Y")) {
				Tasks task = withDependency(dtEnd);
				tasks.add(task);
			} else if (StringUtils.equals(isDependent, "N")) {
				System.out.println("Tasks schedule created!");
			} else {
				System.out.println("Not a valid value");
			}
			System.out.println("-------------------------------------------------");
		}
		
		return tasks;
	}
	
	public Tasks withDependency(Date depEndDate) {
		
		Scanner input = new Scanner(System.in);
		System.out.println("Please create dependency: ");
		System.out.print("Task Name: ");
		String taskName = input.next();
		
		System.out.print("Task duration in hours: ");
		String taskDuration = input.next();
		
		System.out.print("Is task dependent to any tasks? (Y/N): ");
		String isDependent = input.next();
		
		// TODO
		
		Long duration = Long.parseLong(taskDuration);
		Long dtDuration = duration / 9;
		Date dtStart = computeDateDuration(depEndDate, dtDuration);
		dtDuration = (dtDuration / 9) - 1;
		Date dtEnd = computeDateDuration(dtStart, dtDuration);
		
		Tasks task = createTask(taskName, duration, dtStart, dtEnd);
		
		return task;
	}

//	public Tasks addMore(Date dtEnd) {
//		
//		Scanner input = new Scanner(System.in);
//		System.out.print("Task Name: ");
//		String taskName = input.next();
//		
//		System.out.print("Task duration in hours: ");
//		String taskDuration = input.next();
//
//		Long duration = Long.parseLong(taskDuration);
//		Long dtDuration = duration / 9;
//		Date dtStart = computeDateDuration(dtEnd, dtDuration);
//		dtDuration = (dtDuration / 9) - 1;
//		dtEnd = computeDateDuration(dtStart, dtDuration);
//		
//		Tasks task = createTask(taskName, duration, dtStart, dtEnd);
//		
//		return task;
//	}
	
	private Date computeDateDuration(Date date, Long duration) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
		c.add(dayOfWeek, duration.intValue());
		
		return c.getTime();
	}
}

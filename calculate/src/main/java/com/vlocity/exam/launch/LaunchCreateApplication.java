package com.vlocity.exam.launch;

import com.vlocity.exam.model.Project;
import com.vlocity.exam.schedule.ScheduleProjectPlan;

public class LaunchCreateApplication {

	public static void main(String[] args) {
		
		System.out.println("Welcome to Project Scheduler!");
		System.out.println("Please input the following to create a project: ");
		
		ScheduleProjectPlan schedProjPlan = new ScheduleProjectPlan();
		Project project = schedProjPlan.createProject();
		if (project != null) {
			boolean validProject = schedProjPlan.validateProject(project);
		}
		
	}
}

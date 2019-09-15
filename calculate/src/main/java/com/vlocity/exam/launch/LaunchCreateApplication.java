package com.vlocity.exam.launch;

import java.util.ArrayList;
import java.util.List;

import com.vlocity.exam.model.Project;
import com.vlocity.exam.model.Tasks;
import com.vlocity.exam.schedule.ScheduleProjectPlan;

public class LaunchCreateApplication {

	public static void main(String[] args) {
		
		System.out.println("Welcome to Project Scheduler!");
		System.out.println("Please input the following to create a project: ");
		System.out.println("-------------------------------------------------");
		
		ScheduleProjectPlan schedProjPlan = new ScheduleProjectPlan();
		Project project = schedProjPlan.createProject();
		
		boolean validProject = false;
		
		if (project != null) {
			validProject = schedProjPlan.validateProject(project);
		}
		
		if (validProject) {
			List<Tasks> tasks = new ArrayList<Tasks>();
			tasks = schedProjPlan.createTasks(project, tasks);
		}
	}
}

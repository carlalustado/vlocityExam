package com.vlocity.exam.launch;

import java.util.Scanner;

import com.vlocity.exam.schedule.ScheduleProjectPlan;

public class LaunchCreateApplication {

	public static void main(String[] args) {
		
		System.out.println("Welcome to Project Scheduler!");
		System.out.println("Please input the following to create a project: ");
		
		Scanner input = new Scanner(System.in);
		System.out.print("Project Name: ");
		String projName = input.next();
		System.out.print("Project Start date (MM-dd-yyyy): ");
		String projStartDate = input.next();
		
		System.out.print("Project End date (MM-dd-yyyy): ");
		String projEndDate = input.next();
		
		ScheduleProjectPlan schedProjPlan = new ScheduleProjectPlan();
		schedProjPlan.createProject(projName, projStartDate, projEndDate);
	}
}

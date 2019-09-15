package com.vlocity.exam.model;

public enum TasksEnum {

	MOBILIZATION("45"),
	ANALYSIS("27"),
	BUILD("90"),
	SIT("45"),
	UAT("45"),
	RELEASE("27"),
	CONTINGENCY("18");
	
	private String value;

	TasksEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
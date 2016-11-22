package com.xqq.testsqlite.model.entity;

public class Person {

	private String name;
	private String number;
	private int id;
	
	
	public Person(int id, String name, String number) {
		super();
		this.name = name;
		this.number = number;
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
}

package com.mindtree.college.vo;


public class Student {
	
	private int  rollNo;
	
	private String name;
	
	private String gender;
	
	private String stream;
	
	private int age;
	
	private int colId;

	public Student() {
		super();
	}

	


	public Student(String name, String gender, String stream, int age, int colId) {
		super();
		this.name = name;
		this.gender = gender;
		this.stream = stream;
		this.age = age;
		this.colId = colId;
	}




	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	

	public int getColId() {
		return colId;
	}



	public void setColId(int colId) {
		this.colId = colId;
	}




	public String getStream() {
		return stream;
	}




	public void setStream(String stream) {
		this.stream = stream;
	}



	@Override
	public String toString() {
		return "Student [rollNo=" + rollNo + ", name=" + name + ", gender=" + gender + ", stream=" + stream + ", age="
				+ age + ", colId=" + colId + "]";
	}


}

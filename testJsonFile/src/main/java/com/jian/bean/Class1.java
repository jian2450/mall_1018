package com.jian.bean;

public class Class1 {

	private int id;
	private String flmch1;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFlmch1() {
		return flmch1;
	}

	public void setFlmch1(String flmch1) {
		this.flmch1 = flmch1;
	}

	public Class1(int id, String flmch1) {
		this.id = id;
		this.flmch1 = flmch1;
	}

	@Override
	public String toString() {
		return "Class1{" +
				"id=" + id +
				", flmch1='" + flmch1 + '\'' +
				'}';
	}
}

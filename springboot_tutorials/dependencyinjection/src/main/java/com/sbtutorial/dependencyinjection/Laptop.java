package com.sbtutorial.dependencyinjection;

import org.springframework.stereotype.Component;

@Component
public class Laptop {
	
	private int lid;
	private String brand;
	private String specs;
	
	
	public int getLid() {
		return lid;
	}
	public void setLid(int lid) {
		this.lid = lid;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getSpecs() {
		return specs;
	}
	public void setSpecs(String specs) {
		this.specs = specs;
	}
	
	@Override
	public String toString() {
		return "Laptop [lid=" + lid + ", brand=" + brand + "]";
	}
	
	public void compile()
	{
		System.out.println("Compiling inside Laptop.");
	}

}

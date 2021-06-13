package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class OperatingParams {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private Integer rotorSpeed;
	
	private Integer slack;
	
	private Double rootThreshold;
	
	@JsonIgnore
	@OneToOne(mappedBy = "operatingParams")
	private Data data;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRotorSpeed() {
		return rotorSpeed;
	}

	public void setRotorSpeed(Integer rotorSpeed) {
		this.rotorSpeed = rotorSpeed;
	}

	public Integer getSlack() {
		return slack;
	}

	public void setSlack(Integer slack) {
		this.slack = slack;
	}

	public Double getRootThreshold() {
		return rootThreshold;
	}

	public void setRootThreshold(Double rootThreshold) {
		this.rootThreshold = rootThreshold;
	}

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "OperatingParams [rotorSpeed=" + rotorSpeed + ", slack=" + slack + ", rootThreshold=" + rootThreshold
				+ "]";
	}
	
}

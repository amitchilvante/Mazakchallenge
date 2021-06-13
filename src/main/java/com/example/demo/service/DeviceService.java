package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Data;

public interface DeviceService {
	List<Data> numDevices(String status,Integer rootThreashold,String daye);

	void insertIntoDb();

	public List<Data> getAllDevices();
}

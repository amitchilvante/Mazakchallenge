package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Data;
import com.example.demo.entity.Devices;
import com.example.demo.service.DeviceService;

@RestController
@RequestMapping("api/v1")
public class MazakController {
	
	@Autowired
	private DeviceService deviceService;
	
	@RequestMapping(value="numDevices",method = RequestMethod.GET)
	public List<Data> numDevices(@RequestParam String status,Integer rootThreashold,String daye){
		
		List<Data> dataList =  deviceService.numDevices(status, rootThreashold, daye);
		return dataList;
		//return dataList.size();
	}

	@RequestMapping(value="getAllDevices",method = RequestMethod.GET)
	public List<Data> getAllDevices(){
		return deviceService.getAllDevices();
	}
	//public List<Devices> numDevices()
	
	@RequestMapping(value = "mazak", method = RequestMethod.GET)
	public String getMazak() {
		deviceService.insertIntoDb();
		return "Data entered successfully";
	}
}

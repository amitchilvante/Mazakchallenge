package com.example.demo.service;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Data;
import com.example.demo.entity.Devices;
import com.example.demo.repository.DataRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class DeviceServiceImpl implements DeviceService{

	@Autowired
	private DataRepository dataRepo;
	
	@Override
	public List<Data> numDevices(String status, Integer rootThreashold, String daye) {
		List<Data> dataList = dataRepo.findDataByStatus(status);
		dataList= dataList.stream().filter((data)->data.getOperatingParams().getRootThreshold() > rootThreashold &&
				new SimpleDateFormat("MM-yyyy").format(data.getTimestamp()).equals(daye)).collect(Collectors.toList());
		return dataList;
	}

	@Override
	public void insertIntoDb() {
		try {
			String url = "https://jsonmock.hackerrank.com/api/iot_devices";
			URL finalUrl = new URL(url);
			HttpURLConnection connection = (HttpURLConnection) finalUrl.openConnection();
			connection.setRequestProperty("accept", "application/json");
			InputStream responseStream = connection.getInputStream();
			ObjectMapper mapper = new ObjectMapper();
			Devices device = mapper.readValue(responseStream, Devices.class);
			List<Data> dataList = new LinkedList<>();
			//System.out.println(device.getTotal_pages());
			for(int i=1;i<=device.getTotal_pages();i++) {
				url = "https://jsonmock.hackerrank.com/api/iot_devices/search?page="+i;
				finalUrl = new URL(url);
				connection = (HttpURLConnection) finalUrl.openConnection();
				connection.setRequestProperty("accept", "application/json");
				responseStream = connection.getInputStream();
				mapper = new ObjectMapper();
				device = mapper.readValue(responseStream, Devices.class);
				List<Data> list = device.getData();
				dataList.addAll(list);
			}
			dataRepo.saveAll(dataList);
		}catch (Exception e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Data> getAllDevices() {
		// TODO Auto-generated method stub
		return dataRepo.findAll();
	}

}

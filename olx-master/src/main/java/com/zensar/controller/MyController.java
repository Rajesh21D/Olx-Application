package com.zensar.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.entity.AdvertiseCategory;
import com.zensar.entity.AdvertiseStatus;



@RestController
@RequestMapping(value="/advertise",produces= {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE}, consumes= { MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
public class MyController {
	
	static List<AdvertiseCategory> categories= new ArrayList<AdvertiseCategory>();
	static List<AdvertiseStatus> status=new ArrayList<AdvertiseStatus>();
	
	static {
		categories.add(new AdvertiseCategory(1L, "Furniture"));
		categories.add(new AdvertiseCategory(2L, "Cars"));
		categories.add(new AdvertiseCategory(3L, "Mobiles"));
		categories.add(new AdvertiseCategory(4L, "Real Estate"));
		categories.add(new AdvertiseCategory(5L, "Sports"));
	}
	
	static {
		status.add(new AdvertiseStatus(1L, "OPEN"));
		status.add(new AdvertiseStatus(2L, "CLOSED"));
	}
	
	@GetMapping("/category")
	public List<AdvertiseCategory> getAllAdvertisementCategories() {
		return categories;
	}
	
	@GetMapping("/status")
	public List<AdvertiseStatus> getAllAdvertisementStatus(){
		return status;
	}
	

}
package com.zensar.olxadvertise.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.olxadvertise.entity.Advertise;
import com.zensar.olxadvertise.entity.AdvertiseDetails;



@RestController
public class OlxAdvertiseController {

	static List<Advertise> advertises = new ArrayList<Advertise>();
	static List<AdvertiseDetails> advertiseDetails=new ArrayList<AdvertiseDetails>();

	static {
		advertises.add(new Advertise(1L, "laptop sale", 54000, "Electronic goods", "intel core 3 Sony Vaio", "anand",
				"7/21/22", "7/21/22", "OPEN"));
	}
	
	static {
		advertiseDetails.add(new AdvertiseDetails(1L, "laptop sale", 54000, "Electronic goods", "intel core 3 Sony Vaio", "anand",
				"7/21/22", "7/21/22", "OPEN","Anand Kulkarni"));
	}

	@PostMapping("/advertise")
	public ResponseEntity<Advertise> addAdvertise(@RequestBody Advertise advertise,
			@RequestHeader("userName") String username, @RequestHeader("password") String password) {
		if (username.equals("anand") && password.equals("anand123")) {
			advertises.add(advertise);
			advertise.setCategory("Electronic goods");
			advertise.setUserName("anand");
			advertise.setCreatedDate("7/21/22");
			advertise.setModifiedDate("7/21/22");
			advertise.setStatus("OPEN");
			return new ResponseEntity<Advertise>(advertise, HttpStatus.CREATED);
		}

		return null;

	}
@GetMapping("/user/advertise/{postId}")
public Advertise getAdvertise(@PathVariable long postId,@RequestHeader("userName") String username, @RequestHeader("password") String password) {
	if (username.equals("anand") && password.equals("anand123")) {
		
		for(Advertise advertise:advertises) {
			if(advertise.getId()==postId) {
				return advertise;
			}
			
		}
	}
		return null;
		
	}

	@PutMapping("/advertise/{id}")
	public Advertise updateAdvertise(@PathVariable long id, @RequestBody Advertise advertises,
			@RequestHeader("userName") String username, @RequestHeader("password") String password) {
		if (username.equals("anand") && password.equals("anand123")) {
			Advertise advertise = getAdvertise(id, "anand", "anand123");
			advertise.setTitle(advertises.getTitle());
			advertise.setPrice(advertises.getPrice());
			advertise.setDescription(advertises.getDescription());
			
			return advertise;
		}

		return null;

	}
	
	@GetMapping("/user/advertise")
	public List<Advertise> getAllAdvertise(@RequestHeader("userName") String username, @RequestHeader("password") String password) {
		if (username.equals("anand") && password.equals("anand123")) {
		return advertises;
		}
		
		return null;
	}
	
	@DeleteMapping("/user/advertise/{postId}")
	public boolean deleteAdvertise(@PathVariable("postId") long id,@RequestHeader("userName") String username, @RequestHeader("password") String password) {
		if (username.equals("anand") && password.equals("anand123")) {
		for(Advertise advertise:advertises) {
			if(advertise.getId()==id) {
				advertises.remove(advertise);
				
				return true;
			}
		}
			
		}
		return false;
	}
	
	@GetMapping("/advertise/search/{index}")
	public Advertise searchAdvertisementsByCriteria(@PathVariable String category, String toDate,Long index, String fromDate) {
		for(Advertise advertise:advertises) {
			if(advertise.getId()==index||advertise.getCategory().equals(category)||advertise.getCreatedDate().equals(fromDate)||advertise.getModifiedDate().equals(toDate)) {
				return advertise;
			}

			
		}
		return null;
	}
	
	@GetMapping("/advertise/search")
	public List<Advertise> searchAdvertise() {
		
		return advertises;
		
	}
	@GetMapping("/advertise/{postId}")
	public List<AdvertiseDetails> advertiseDetails(@PathVariable("postId") long id,@RequestHeader("userName") String username, @RequestHeader("password") String password) {
		if (username.equals("anand") && password.equals("anand123")) {
			for(AdvertiseDetails advertise:advertiseDetails) {
				if(advertise.getId()==id) {
			
					return advertiseDetails;
				}
			}
		}
		return null;
		
	}

}

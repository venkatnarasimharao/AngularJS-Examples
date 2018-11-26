package com.nareshit.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.nareshit.model.College;

@Path(value="/college")
public class CollegeInformation {
	@GET
	@Path(value="/search")
	@Produces(MediaType.APPLICATION_JSON)
	public College serachColleges() {
		College college= new College();
		college.setCid(101);
		college.setInstitute("MS RAMAIYA");
		college.setFee(2442.4);
		college.setCourse("AngularJS");
		return college;
		
	}

}

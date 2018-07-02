package com.ankit.webserviceUsingJersey;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("employee")
public class EmployeeResource {
	
	EmployeeRepository empRepo = new EmployeeRepository();;
	
	@GET
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public List<Employee> doGet()
	{		
		return empRepo.doFetch();
	}
	
	@GET
	@Path("details/{id}")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Employee doGet(@PathParam("id") String name)
	{		
		System.out.println("inside resource class method");
		return empRepo.fetchParticular(name);
	}
	
	@POST
	@Path("emp")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Employee doCreate(Employee e)
	{
		System.out.println(e.getName().toString()+ "inside emp");
		empRepo.insertData(e);
		return e;
	}
	
	@PUT
	@Path("update")
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public String updateDate(Employee e)
	{
		return empRepo.updateDetails(e);
	}
}

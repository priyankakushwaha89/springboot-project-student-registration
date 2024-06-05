package com.student_registration.springboot_student_registration;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class MyController
{
 @Autowired
 StudentRepository erepo;
 
 // This is for Testing the performance of the code
	@RequestMapping("/test")
	public String test()
	{
		return " Test is completed";
	}
//This is for creating data
	@RequestMapping("/save")
	public String savedata(@RequestBody Student s)
	{
		erepo.save(s);
		return "Data is saved";
		
	}
// This is for Read the data
	@RequestMapping("/all")
	public List<Student> findData()
	{
		return erepo.findAll();
	}
	
	@RequestMapping("/{id}")
	public Optional<Student> byId(@PathVariable int id)
	{
		return erepo.findById(id);
	}
	
	@RequestMapping("/name/{name}")
	public List<Student> byName(@PathVariable String name)
	{
		return erepo.findByName(name);
	}
//This is for deleting the data	
	@RequestMapping("/delete/{id}")
	public String del(@PathVariable int id)
	{
		Student s=erepo.findById(id).get();
		erepo.deleteById(id);
		return "Data is released";
    }
	
//This is for updating the data 
	@RequestMapping("/upd/{id}")
	public String update(@RequestBody Student s,@PathVariable int id)
	{
		Student su=erepo.findById(id).get();
		su.setName(s.getName());
		su.setGmail(s.getGmail());
		su.setPassword(s.getPassword());
	    erepo.save(su);
	    return "Data is updated";

	}

}

package com.electro.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.electro.dtos.UserDto;
import com.electro.payloads.ApiResponse;
import com.electro.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/create")
	ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto)
	{
		return new ResponseEntity<UserDto>(userService.createUser(userDto), HttpStatus.CREATED);
	}
	
	@GetMapping("/getAll")
	ResponseEntity<List<UserDto>> getall(){
		return new ResponseEntity<List<UserDto>>(userService.getAll(), HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	ResponseEntity<ApiResponse> delete(@PathVariable String id)
	{
		userService.deleteUser(id);
		return new ResponseEntity(new ApiResponse("Deleted Successfully",true),HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
	ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto,@PathVariable String id)
	{
		return new ResponseEntity<UserDto>(this.userService.updateUser(userDto, id), HttpStatus.ACCEPTED);
	}
	
	
	@GetMapping("/getById/{id}")
	ResponseEntity<UserDto> getBy(@PathVariable String id)
	{
		return new ResponseEntity<UserDto>(this.userService.getById(id), HttpStatus.OK);
	}
	
	@GetMapping("/email/{emailId}")
	ResponseEntity<UserDto> getByEmail(@PathVariable String emailId)
	{
		return new ResponseEntity<UserDto>(this.userService.getByEmail(emailId), HttpStatus.OK);
	}
	
	
	
	
	
	
	
	

}

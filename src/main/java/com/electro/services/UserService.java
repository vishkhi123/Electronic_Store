package com.electro.services;

import java.util.List;

import com.electro.dtos.UserDto;

public interface UserService {
	
	UserDto createUser(UserDto userDto);
	
	UserDto updateUser(UserDto userDto,String id);
	
	void deleteUser(String id);
	
	List<UserDto> getAll();
	
	UserDto getById(String id);
	
	UserDto getByEmail(String email);
}

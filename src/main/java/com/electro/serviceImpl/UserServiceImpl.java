package com.electro.serviceImpl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.electro.dtos.UserDto;
import com.electro.entities.User;
import com.electro.repositeries.UserRepository;
import com.electro.services.UserService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private UserRepository userRepo;

	@Override
	public UserDto createUser(UserDto userDto) {
		// TODO Auto-generated method stub
		
		String userId = UUID.randomUUID().toString();
        userDto.setUserId(userId);
		User user=this.modelMapper.map(userDto, User.class);
	//	User user=this.modelMapper.map(userDto, User.class);
		User saved=userRepo.save(user);
		//return this.modelMapper.map(saved, UserDto.class);
		return this.modelMapper.map(saved, UserDto.class);
	}

	@Override
	public UserDto updateUser(UserDto userDto, String id) {
		// TODO Auto-generated method stub
		User user=this.userRepo.findById(id).orElseThrow(()->new RuntimeException("User Not Found"));
		user.setName(userDto.getName());
		
		user.setAbout(userDto.getAbout());
		user.setEmail(userDto.getEmail());
		user.setGender(userDto.getGender());
		
		return this.modelMapper.map(user, UserDto.class);
	}

	@Override
	public void deleteUser(String id) {
		// TODO Auto-generated method stub
		User user=userRepo.findById(id).orElseThrow(()->new RuntimeException("User Not Found"));
		if(user!=null)
		{
			this.userRepo.delete(user);
		}
		
	}

	@Override
	public List<UserDto> getAll() {
		// TODO Auto-generated method stub
		List<User> users=this.userRepo.findAll();
		List<UserDto> userDtos=users.stream().map(user->this.modelMapper.map(user, UserDto.class)).collect(Collectors.toList());
		return userDtos;
	}

	@Override
	public UserDto getById(String id) {
		// TODO Auto-generated method stub
		User user=this.userRepo.findById(id).orElseThrow(()-> new RuntimeException("User Not Found"));
		return this.modelMapper.map(user, UserDto.class);
	}

	@Override
	public UserDto getByEmail(String email) {
		// TODO Auto-generated method stub
		//User user=this.userRepo.findByEmail(email).orElseThrow(()->new RuntimeException("User Not Found"));
		User user=this.userRepo.findByEmailCustomQuery(email).orElseThrow(()->new RuntimeException("User Not Found"));
		return this.modelMapper.map(user, UserDto.class);
	}

}

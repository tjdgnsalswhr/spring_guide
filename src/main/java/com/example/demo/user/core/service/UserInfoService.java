package com.example.demo.user.core.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.common.error.exception.BusinessException;
import com.example.demo.user.core.application.object.UserRequestDTO;
import com.example.demo.user.core.application.object.UserResponseDTO;
import com.example.demo.user.core.entity.User;
import com.example.demo.user.core.port_infra.persistent.UserRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional

public class UserInfoService {
	
	private final UserRepository userRepo;
	private final ModelMapper modelMapper;  //두개의 비슷한 객체를 매핑시켜주는

	public List<User> getAllUser()
	{
		return userRepo.findAll();
	}
	
	public UserResponseDTO getOneUser(String uId)
	{
		Optional<User> optionalUser = userRepo.findById(uId);
		if(optionalUser.isPresent())
		{
			return modelMapper.map(optionalUser.get(), UserResponseDTO.class);
		}
		else
			return null;
	}
	
	public UserResponseDTO getOneUserByName(String uName)
	{
		Optional<User> optionalUser = userRepo.findByUName(uName);
		if(optionalUser.isPresent())
		{
			return modelMapper.map(optionalUser.get(), UserResponseDTO.class);
		}
		else
			return null;
	}
	
	public void insertUser(UserRequestDTO userRequestDTO)
	{
		User user = modelMapper.map(userRequestDTO, User.class);
		userRepo.save(user);
		
	}
	
	public void updateUser(UserRequestDTO userRequestDTO)
	{
		Optional<User> optionalUser = userRepo.findById(userRequestDTO.getUId());
		if(!optionalUser.isPresent())
		{
			throw new BusinessException("0000", "There is No User");
			
		}	
		User user = optionalUser.get();
		UserRequestDTO newInfo = user.update(userRequestDTO);
		userRepo.save(modelMapper.map(newInfo, User.class));
	}
	
	public void deleteUser(String uId)
	{
		Optional<User> optionalUser = userRepo.findById(uId);
		if(!optionalUser.isPresent())
		{
			throw new BusinessException("0000", "There is No User");
		}
		userRepo.delete(optionalUser.get());
	}
	
	
	
}

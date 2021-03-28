package com.example.demo.user.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.user.core.application.object.UserResponseDTO;
import com.example.demo.user.core.service.UserInfoService;

import io.swagger.annotations.ApiOperation;

@RestController
public class UserController {
	
	@Autowired
	UserInfoService service;
	
	@ApiOperation(value="전체 사용자 정보 조회", httpMethod = "GET", notes = "전체 사용자 정보 조회 API.")
	@GetMapping(value="/user/info/all")
	public ResponseEntity<Object> getAllUser()
	{
		return new ResponseEntity<>(service.getAllUser(), HttpStatus.OK);
	}
	
	@ApiOperation(value="단건 사용자 정보 조회", httpMethod = "GET", notes = "단건 사용자 정보 조회 API.")
	@GetMapping(value="/user/info/{uId}")
	public ResponseEntity<UserResponseDTO> getOneUser(@PathVariable String uId)
	{
		return new ResponseEntity<>(service.getOneUser(uId), HttpStatus.OK);
	}
	
	
	

}

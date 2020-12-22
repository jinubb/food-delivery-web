package com.dv.login.controller;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dv.common.ResponseContainer;
import com.dv.login.entity.User;
import com.dv.login.model.LoginResponse;
import com.dv.login.service.LoginService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/dv/login")
public class LoginController {
	private static Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	LoginService service;
	
	@ApiOperation(value = "로그인")
	@PostMapping("/")
	public ResponseContainer<LoginResponse> loginUser(
			@RequestParam(required = true) String email, 
			@RequestParam(required = true) String password) {
		ResponseContainer<LoginResponse> response = ResponseContainer.emptyResponse();		
		try {
			response.setPayload(service.loginUser(email, password));
		} catch(Exception e) {
			logger.error("login:\n{}",e);
			response.setError(e);
		}
		return response;
	}
	
	@ApiOperation(value = "회원가입")
	@PostMapping("/reg")
	public ResponseContainer<User> registerUser(
			@RequestParam(required = true) String email, 
			@RequestParam(required = true) String password,
			@RequestParam(required = false) String name,
			@RequestParam(required = false) String phone,
			@RequestParam(required = false, defaultValue = "US") String type,
			@RequestParam(required = false) String storeName,
			@RequestParam(required = false) String storePhone,
			@RequestParam(required = false) String storeType) {
		ResponseContainer<User> response = ResponseContainer.emptyResponse();		
		try {
			response.setPayload(service.registerUser(email, password, name, phone, type, storeName, storePhone, storeType));
		} catch(Exception e) {
			logger.error("register:\n{}",e);
			response.setError(e);
		}
		return response;
	}
}

package com.dv.login.model;



import com.dv.login.entity.User;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class LoginResponse {
	private String authToken;
	private User loginUser;
}

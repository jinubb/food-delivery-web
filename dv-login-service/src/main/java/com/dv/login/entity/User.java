package com.dv.login.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Entity
@Table(name = "user")
public class User {
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id; //유저 번호
	
	@Column(name="EMAIL")
	private String email; // 유저 이메일
	
	@Column(name="PASSWORD")
	private String password; // 유저 비밀번호
	
	@Column(name="NAME")
	private String name; // 유저 이름
	
	@Column(name="PHONE")
	private String phone; // 유저 전화번호
	
	@Column(name="TYPE")
	private String type; // 유저 타입, AD : admin(관리자) US : user(사용자)
	
	@Column(name="STORE_ID")
	private Long storeId; // 업체 id
	
}

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
@Table(name = "store")
public class Store {
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id; // id
	
	@Column(name="NAME")
	private String name; // 이름
	
	@Column(name="PHONE")
	private String phone; // 전화번호
	
	@Column(name="TYPE")
	private String type; // 가게 타입, CK : chicken(치킨) CH : chinese(중국음식) PZ : pizza(피자)
}

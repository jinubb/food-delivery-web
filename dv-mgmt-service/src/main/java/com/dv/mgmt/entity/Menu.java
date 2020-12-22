package com.dv.mgmt.entity;

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
@Table(name = "menu")
public class Menu {
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id; // id
	
	@Column(name="STORE_ID")
	private Long storeId; // 업체 id
	
	@Column(name="NAME")
	private String name; // 이름
	
	@Column(name="PRICE")
	private String price; // 가격
}

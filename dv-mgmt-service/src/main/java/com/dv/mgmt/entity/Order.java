package com.dv.mgmt.entity;

import java.util.Date;

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
@Table(name = "order")
public class Order {
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id; // id
	
	@Column(name="STAT_CODE")
	private Long statCode; // 주문
	
	@Column(name="STORE_ID")
	private Long storeId; // 업체 id
	
	@Column(name="USER_ID")
	private Long userId; // 주문자 id
	
	@Column(name="MENU_ID")
	private String menuId; // 메뉴 id
	
	//주문시간 추가
	@Column(name="CREATED_DT")
	private Date createdDate; // 생성시간
}

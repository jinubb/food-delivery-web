package com.dv.mgmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dv.mgmt.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{

}

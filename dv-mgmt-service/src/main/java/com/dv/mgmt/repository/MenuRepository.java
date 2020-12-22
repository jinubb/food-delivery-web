package com.dv.mgmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dv.mgmt.entity.Menu;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long>{

}

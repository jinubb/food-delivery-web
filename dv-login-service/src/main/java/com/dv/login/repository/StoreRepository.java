package com.dv.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dv.login.entity.Store;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long>{

}

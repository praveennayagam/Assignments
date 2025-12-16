package com.mphasis.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mphasis.entities.Orders;

public interface OrderRepository extends JpaRepository<Orders, Long>{

}

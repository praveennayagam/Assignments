package com.mphasis.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mphasis.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {}
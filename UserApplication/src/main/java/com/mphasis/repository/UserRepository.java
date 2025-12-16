package com.mphasis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mphasis.entity.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}

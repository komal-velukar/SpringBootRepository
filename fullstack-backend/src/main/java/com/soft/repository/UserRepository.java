package com.soft.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.soft.model.User;

public interface UserRepository extends JpaRepository<User,Long> {

}

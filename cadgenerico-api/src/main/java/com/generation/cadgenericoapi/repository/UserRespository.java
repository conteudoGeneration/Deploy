package com.generation.cadgenericoapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.cadgenericoapi.model.User;

public interface UserRespository extends JpaRepository<User, Long> {

}

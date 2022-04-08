package com.udemyjava.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.udemyjava.demo.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}

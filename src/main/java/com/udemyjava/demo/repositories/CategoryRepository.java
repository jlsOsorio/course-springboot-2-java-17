package com.udemyjava.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.udemyjava.demo.entities.Category;

//Aqui não é necessário registar @Repository porque já está a herdar de uma componente do Spring
public interface CategoryRepository extends JpaRepository<Category, Long>{

}

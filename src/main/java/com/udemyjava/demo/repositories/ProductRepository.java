package com.udemyjava.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.udemyjava.demo.entities.Product;

//Aqui não é necessário registar @Repository porque já está a herdar de uma componente do Spring
public interface ProductRepository extends JpaRepository<Product, Long>{

}

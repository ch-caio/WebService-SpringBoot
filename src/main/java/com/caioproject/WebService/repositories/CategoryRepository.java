package com.caioproject.WebService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.caioproject.WebService.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> { // informa a classe Orders e tipo do ID que é Long

}

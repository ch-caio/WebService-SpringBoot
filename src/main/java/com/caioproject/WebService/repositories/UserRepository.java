package com.caioproject.WebService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.caioproject.WebService.entities.User;

public interface UserRepository extends JpaRepository<User, Long> { // informa a classe Users e tipo do ID que é Long

}

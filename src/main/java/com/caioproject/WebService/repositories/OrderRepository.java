package com.caioproject.WebService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.caioproject.WebService.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> { // informa a classe Orders e tipo do ID que é Long

}

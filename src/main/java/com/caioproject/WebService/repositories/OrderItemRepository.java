package com.caioproject.WebService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.caioproject.WebService.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> { // informa a classe Users e tipo do ID que é Long

}

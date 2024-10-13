package com.example.shopping_cart_service.repo;

import com.example.shopping_cart_service.repo.entity.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart,Long> {

    Optional<ShoppingCart> findByUserId(String userId);

}

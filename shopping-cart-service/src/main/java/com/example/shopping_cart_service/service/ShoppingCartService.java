package com.example.shopping_cart_service.service;

import com.example.shopping_cart_service.repo.entity.ShoppingCart;

import java.util.List;
import java.util.Optional;

public interface ShoppingCartService {

    ShoppingCart createCart(String userId) ;

    Optional<ShoppingCart> getCart(Long id) ;

    List<ShoppingCart> getAllCarts() ;

    void deleteCart(Long id) ;
}

package com.example.shopping_cart_service.service.impl;

import com.example.shopping_cart_service.repo.ShoppingCartRepository;
import com.example.shopping_cart_service.repo.entity.ShoppingCart;
import com.example.shopping_cart_service.service.ShoppingCartService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@Transactional
@RequiredArgsConstructor
public class ShoppingCartServiceImpl implements ShoppingCartService {

    private final ShoppingCartRepository shoppingCartRepository;


    @Override
    public ShoppingCart createCart(String userId) {
        ShoppingCart cart = new ShoppingCart();
        cart.setUserId(userId);
        return shoppingCartRepository.save(cart);
    }

    @Override
    public Optional<ShoppingCart> getCart(Long id) {
        return shoppingCartRepository.findById(id);
    }

    @Override
    public List<ShoppingCart> getAllCarts() {
        return shoppingCartRepository.findAll();
    }

    @Override
    public void deleteCart(Long id) {
        shoppingCartRepository.deleteById(id);
    }
}

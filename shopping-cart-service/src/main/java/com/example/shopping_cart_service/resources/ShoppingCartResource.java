package com.example.shopping_cart_service.resources;

import com.example.shopping_cart_service.repo.entity.CartItem;
import com.example.shopping_cart_service.repo.entity.ShoppingCart;
import com.example.shopping_cart_service.service.ShoppingCartService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/carts")
@RequiredArgsConstructor
@Tag(name = "Shopping Cart Management APIs")
public class ShoppingCartResource {

    private final ShoppingCartService shoppingCartService;

    @PostMapping("/create")
    public ResponseEntity<ShoppingCart> createCart(@RequestParam String userId) {
        ShoppingCart cart = shoppingCartService.createCart(userId);
        return ResponseEntity.status(HttpStatus.CREATED).body(cart);
    }

    @PostMapping("/{cartId}/add")
    public ResponseEntity<ShoppingCart> addItem(@PathVariable Long cartId, @RequestBody CartItem item) {
        ShoppingCart updatedCart = shoppingCartService.addItem(cartId, item);
        return ResponseEntity.ok(updatedCart);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<ShoppingCart> getCart(@PathVariable String userId) {
        ShoppingCart cart = shoppingCartService.getCart(Long.valueOf(userId)).orElseThrow(() -> new RuntimeException("Cart not found"));;
        return ResponseEntity.ok(cart);
    }

    @PostMapping("/{cartId}/checkout")
    public ResponseEntity<Void> checkout(@PathVariable Long cartId) {
        shoppingCartService.checkout(cartId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}

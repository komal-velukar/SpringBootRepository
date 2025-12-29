package com.soft.controller;

import com.soft.dto.AddToCartRequest;
import com.soft.dto.CartItemDTO;
import com.soft.dto.CartResponceDTO;
import com.soft.entity.Cart;
import com.soft.entity.CartItem;
import com.soft.service.CartService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/carts")
@CrossOrigin(origins = "*")
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    
    @GetMapping("/{cartId}")
    public ResponseEntity<CartResponceDTO> getCart(@PathVariable Long cartId) {

        Optional<Cart> cart = cartService.getCartById(cartId);

        if (cart.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(convertCartToDto(cart.get()), HttpStatus.OK);
    }

    
    @PostMapping("/{cartId}/items")
    public ResponseEntity<CartResponceDTO> addItemToCart(
            @PathVariable(required = false) Long cartId,
            @RequestBody AddToCartRequest requestDTO) {

        Cart updatedCart = cartService.addProductToCart(
                cartId,
                requestDTO.getProductId(),
                requestDTO.getQuantity()
        );

        return new ResponseEntity<>(convertCartToDto(updatedCart), HttpStatus.OK);
    }

    @DeleteMapping("/{cartId}/items/{productId}")
    public ResponseEntity<CartResponceDTO> removeProductFromCart(
            @PathVariable Long cartId,
            @PathVariable Long productId) {

        Cart updatedCart = cartService.removeProductFromCart(cartId, productId);

        return new ResponseEntity<>(convertCartToDto(updatedCart), HttpStatus.OK);
    }

   
    private CartResponceDTO convertCartToDto(Cart cart) {

        CartResponceDTO dto = new CartResponceDTO();
        dto.setCartId(cart.getId());

        List<CartItemDTO> items = cart.getItems().stream()
                .map(item -> new CartItemDTO(
                        item.getId(),
                        item.getProduct().getId(),
                        item.getProduct().getName(),
                        item.getQuantity(),
                        BigDecimal.valueOf(item.getProduct().getPrice())
                ))
                .collect(Collectors.toList());

        dto.setItems(items);
        return dto;
    }
}
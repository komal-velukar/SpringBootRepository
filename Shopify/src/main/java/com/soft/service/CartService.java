package com.soft.service;



import com.soft.entity.Cart;
import com.soft.entity.CartItem;
import com.soft.entity.Product;
import com.soft.repository.CartItemRepository;
import com.soft.repository.CartRepository;
import com.soft.repository.ProductRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

@Service
public class CartService {

    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;
    private final ProductRepository productRepository;

    public CartService(
        CartRepository cartRepository,
        CartItemRepository cartItemRepository,
        ProductRepository productRepository
    ) {
        this.cartRepository = cartRepository;
        this.cartItemRepository = cartItemRepository;
        this.productRepository = productRepository;
    }

    @Transactional(readOnly = true)
    public Optional<Cart> getCartById(Long cartId) {
        return cartRepository.findById(cartId);
    }
    
    public Cart createNewCart() {
        return cartRepository.save(new Cart()); 
    }

    @Transactional
    public Cart addProductToCart(Long cartId, Long productId, int quantity) {
        
        
        Cart cart;
        if (cartId == null) {
            cart = createNewCart();
        } else {
            cart = cartRepository.findById(cartId).orElseGet(this::createNewCart);
        }
     
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found: " + productId));

        
        Optional<CartItem> existingItemOpt = cart.getItems().stream()
                .filter(item -> item.getProduct().getId().equals(productId))
                .findFirst();

        if (existingItemOpt.isPresent()) {
           
            CartItem item = existingItemOpt.get();
            item.setQuantity(item.getQuantity() + quantity);
            cartItemRepository.save(item); 
        } else {
           
            CartItem newItem = new CartItem();
            newItem.setProduct(product);
            newItem.setQuantity(quantity);
            
            
            newItem.setCart(cart); 
            cart.getItems().add(newItem);
            
            cartItemRepository.save(newItem); 
        }

        return cart; 
    }

    @Transactional
    public Cart removeProductFromCart(Long cartId, Long productId) {
        Cart cart = cartRepository.findById(cartId)
                    .orElseThrow(() -> new RuntimeException("Cart not found: " + cartId));
                    
        cart.getItems().removeIf(item -> {
            if (item.getProduct().getId().equals(productId)) {
                cartItemRepository.delete(item); 
                return true; 
            }
            return false;
        });

        return cartRepository.save(cart);
    }
}
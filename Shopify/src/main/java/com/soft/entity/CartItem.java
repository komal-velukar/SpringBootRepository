package com.soft.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "cart_items")
public class CartItem {

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;

 @ManyToOne(fetch = FetchType.LAZY) 
 @JoinColumn(name = "product_id", nullable = false)
 private Product product;

 private int quantity;

 @ManyToOne(fetch = FetchType.LAZY)
 @JoinColumn(name = "cart_id")
 private Cart cart;
 

  public CartItem() {
  }
 

  public CartItem(Long id, Product product, int quantity, Cart cart) {
      super();
      this.id = id;
      this.product = product;
      this.quantity = quantity;
      this.cart = cart;
  }

public Long getId() {
	return id;
}

public Product getProduct() {
	return product;
}

public int getQuantity() {
	return quantity;
}

public Cart getCart() {
	return cart;
}

public void setId(Long id) {
	this.id = id;
}

public void setProduct(Product product) {
	this.product = product;
}

public void setQuantity(int quantity) {
	this.quantity = quantity;
}

public void setCart(Cart cart) {
	this.cart = cart;
}


}
package com.soft.dto;



import java.math.BigDecimal;

public class CartItemDTO {
    
    private Long itemId;
    private Long productId;
    private String productName;
    private int quantity;
    private BigDecimal price;

    public CartItemDTO(Long itemId, Long productId, String productName, int quantity, BigDecimal price) {
        this.itemId = itemId;
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    public CartItemDTO() {}

    // Getters and Setters
    public Long getItemId() { return itemId; }
    public void setItemId(Long itemId) { this.itemId = itemId; }
    public Long getProductId() { return productId; }
    public void setProductId(Long productId) { this.productId = productId; }
    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }
}
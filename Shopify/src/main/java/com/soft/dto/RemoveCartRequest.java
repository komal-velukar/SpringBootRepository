package com.soft.dto;


public class RemoveCartRequest {
    private Long productId;
    private Integer quantity;

    public RemoveCartRequest() {}

    public Long getProductId() { return productId; }
    public void setProductId(Long productId) { this.productId = productId; }
    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }
}
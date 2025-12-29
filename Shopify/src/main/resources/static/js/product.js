// Product class to represent a product
class Product {
    constructor(id, name, description, price) {
        this.id = id;               // Product ID
        this.name = name;           // Product name
        this.description = description; // Product description
        this.price = price;         // Product price
    }
}

// Helper function to create a Product instance from backend JSON
function createProductFromJSON(json) {
    return new Product(
        json.id,
        json.name,
        json.description,
        json.price
    );
}

// Optional: You can add methods to Product class
// For example, to get price with tax or discount
Product.prototype.getPriceWithTax = function(taxPercent) {
    return this.price + (this.price * taxPercent / 100);
}
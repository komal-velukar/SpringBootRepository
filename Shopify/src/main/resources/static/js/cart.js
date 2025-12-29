// Load products from backend
async function loadProducts() {
    try {
        const response = await fetch('/api/products');
        const productsJSON = await response.json();

        const productContainer = document.getElementById('product-container');
        productContainer.innerHTML = '';

        productsJSON.forEach(pJSON => {
            const product = createProductFromJSON(pJSON);
            const productDiv = document.createElement('div');
            productDiv.className = 'product';
            productDiv.innerHTML = `
                <h3>${product.name}</h3>
                <p>${product.description}</p>
                <p>Price: ₹${product.price}</p>
                <button onclick="addToCart(${product.id}, '${product.name}', ${product.price})">Add to Cart</button>
            `;
            productContainer.appendChild(productDiv);
        });
    } catch (error) {
        console.error('Error fetching products:', error);
    }
}

// Add product to cart
function addToCart(id, name, price) {
    let cart = JSON.parse(localStorage.getItem('cart')) || [];
    const existingItem = cart.find(item => item.id === id);
    if (existingItem) {
        existingItem.quantity += 1;
    } else {
        cart.push({id, name, price, quantity: 1});
    }
    localStorage.setItem('cart', JSON.stringify(cart));
    updateCartCount();
    showCartSummary();
}

// Remove product from cart
function removeFromCart(id) {
    let cart = JSON.parse(localStorage.getItem('cart')) || [];
    cart = cart.filter(item => item.id !== id);
    localStorage.setItem('cart', JSON.stringify(cart));
    updateCartCount();
    showCartSummary();
}

// Update cart count in navbar
function updateCartCount() {
    const cart = JSON.parse(localStorage.getItem('cart')) || [];
    const totalItems = cart.reduce((sum, item) => sum + item.quantity, 0);
    document.getElementById('cart-count').textContent = totalItems;
}

// Initialize
window.onload = function() {
    loadProducts();
    updateCartCount();
    showCartSummary();
}
$('.add-to-cart-btn').click(function() {
    let productId = $(this).data('id');
    let quantity = parseInt($('#quantity-' + productId).val()) || 1;

    $.ajax({
        url: '/cart/add',
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify({ productId: productId, quantity: quantity }),
        success: function(response) {
            alert('Product added to cart');
            // Optional: update cart count
            $('#cart-count').text(response.totalItems);
        },
        error: function(err) {
            console.error('Error adding to cart:', err);
        }
    });
});
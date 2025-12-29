// Show cart summary
function showCartSummary() {
    const cart = JSON.parse(localStorage.getItem('cart')) || [];
    const summaryDiv = document.getElementById('cart-summary');
    if (cart.length === 0) {
        summaryDiv.textContent = 'Cart is empty';
        return;
    }

    let html = '<h3>Cart Summary:</h3><ul>';
    let totalPrice = 0;
    cart.forEach(item => {
        html += `<li>${item.name} x ${item.quantity} = ₹${item.price * item.quantity} 
                 <button onclick="removeFromCart(${item.id})">Remove</button></li>`;
        totalPrice += item.price * item.quantity;
    });
    html += ; ul > <p>Total: ₹${totalPrice}</p>;
    summaryDiv.innerHTML = html;
}

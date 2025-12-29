$(document).ready(function () {
  loadProducts();
  loadCart();
});

// toggle cart panel
function toggleCart() {
  const cart = document.getElementById("cart-section");
  cart.classList.toggle("visible");
}
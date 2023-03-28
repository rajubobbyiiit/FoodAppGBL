package app.food.controller;

import app.food.service.CartService;

public class CartController {
	private CartService cartService;

	public CartController(CartService cartService) {
		this.cartService = cartService;
	}

	public void addToCart(String userId, String restaurantId){
		this.cartService.order(userId, restaurantId);
	}
}

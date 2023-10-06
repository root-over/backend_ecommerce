package me.magliano.shopapi.service;

import me.magliano.shopapi.entity.Cart;
import me.magliano.shopapi.entity.ProductInOrder;
import me.magliano.shopapi.entity.User;

import java.util.Collection;


public interface CartService {
    Cart getCart(User user);

    void mergeLocalCart(Collection<ProductInOrder> productInOrders, User user);

    void delete(String itemId, User user);

    void checkout(User user);
}

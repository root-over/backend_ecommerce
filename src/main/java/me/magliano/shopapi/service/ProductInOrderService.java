package me.magliano.shopapi.service;

import me.magliano.shopapi.entity.ProductInOrder;
import me.magliano.shopapi.entity.User;

public interface ProductInOrderService {
    void update(String itemId, Integer quantity, User user);
    ProductInOrder findOne(String itemId, User user);
}

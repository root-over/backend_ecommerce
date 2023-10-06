package me.magliano.shopapi.repository;

import me.magliano.shopapi.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CartRepository extends JpaRepository<Cart, Integer> {
    //boolean existsCartByUserContaining(String userId);
}

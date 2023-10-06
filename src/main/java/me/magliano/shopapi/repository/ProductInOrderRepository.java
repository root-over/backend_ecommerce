package me.magliano.shopapi.repository;

import me.magliano.shopapi.entity.ProductInOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductInOrderRepository extends JpaRepository<ProductInOrder, Long> {
    ProductInOrder findProductInOrderByProductIdIs(String p);

}

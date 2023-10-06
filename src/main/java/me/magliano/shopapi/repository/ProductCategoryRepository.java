package me.magliano.shopapi.repository;

import me.magliano.shopapi.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {
    // Alcune categoriey
    List<ProductCategory> findByCategoryTypeInOrderByCategoryTypeAsc(List<Integer> categoryTypes);
    // Tutte le categorie
    List<ProductCategory> findAllByOrderByCategoryType();
    // Una categoria
    ProductCategory findByCategoryType(Integer categoryType);
}

package me.magliano.shopapi.service;


import me.magliano.shopapi.entity.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {

    ProductInfo findOne(String productId);

    // Tutti i prodotti in vendita
    Page<ProductInfo> findUpAll(Pageable pageable);
    // Tutti i prodotti
    Page<ProductInfo> findAll(Pageable pageable);
    // Tutti i prodotti in una categoria
    Page<ProductInfo> findAllInCategory(Integer categoryType, Pageable pageable);

    // Incrementa la disponibilità
    void increaseStock(String productId, int amount);

    //Decrementa la disponibilità
    void decreaseStock(String productId, int amount);

    ProductInfo offSale(String productId);

    ProductInfo onSale(String productId);

    ProductInfo update(ProductInfo productInfo);
    ProductInfo save(ProductInfo productInfo);

    void delete(String productId);


}

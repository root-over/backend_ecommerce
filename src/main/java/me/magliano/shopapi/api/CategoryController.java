package me.magliano.shopapi.api;


import me.magliano.shopapi.entity.ProductCategory;
import me.magliano.shopapi.service.CategoryService;
import me.magliano.shopapi.service.ProductService;
import me.magliano.shopapi.entity.ProductInfo;
import me.magliano.shopapi.vo.response.CategoryPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    @Autowired
    ProductService productService;


    //restistuisce la pagina dei prodotti di una specifica categoria
    @GetMapping("/category/{type}")
    public CategoryPage showOne(@PathVariable("type") Integer categoryType,
                                @RequestParam(value = "page", defaultValue = "1") Integer page,
                                @RequestParam(value = "size", defaultValue = "3") Integer size) {

        ProductCategory cat = categoryService.findByCategoryType(categoryType);
        PageRequest request = PageRequest.of(page - 1, size); //Indico la pagina desiderata e la dimensione
        Page<ProductInfo> productInCategory = productService.findAllInCategory(categoryType, request); //restituisce una pagina di oggetti associati ad una categoria specifica usando le informazioni di request
        var tmp = new CategoryPage("", productInCategory);
        tmp.setCategory(cat.getCategoryName());
        return tmp;
    }
}

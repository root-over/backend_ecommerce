package me.magliano.shopapi.api;


import me.magliano.shopapi.repository.CartRepository;
import me.magliano.shopapi.repository.ProductInOrderRepository;
import me.magliano.shopapi.repository.UserRepository;
import me.magliano.shopapi.service.CartService;
import me.magliano.shopapi.service.ProductInOrderService;
import me.magliano.shopapi.service.ProductService;
import me.magliano.shopapi.service.UserService;
import me.magliano.shopapi.entity.Cart;
import me.magliano.shopapi.entity.ProductInOrder;
import me.magliano.shopapi.entity.User;
import me.magliano.shopapi.form.ItemForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Collection;
import java.util.Collections;

//SERVE A CREARE LE RICHIESE POST E GET
@CrossOrigin
@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    CartService cartService;
    @Autowired
    CartRepository cartRepository;
    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;
    @Autowired
    ProductService productService;
    @Autowired
    ProductInOrderService productInOrderService;
    @Autowired
    ProductInOrderRepository productInOrderRepository;

    //UNISCE IL CARRELLO DELLA SESSIONE CON L'UTENTE AUTENTICATO
    //productInOrders sono gli articoli nel carrello e principal l'utente autenticato
    @PostMapping("")
    public ResponseEntity<Cart> mergeCart(@RequestBody Collection<ProductInOrder> productInOrders, Principal principal) {
        User user = userService.findOne(principal.getName());
        try {
            cartService.mergeLocalCart(productInOrders, user);
        } catch (Exception e) {
            ResponseEntity.badRequest().body("Errore con il carrello");
        }
        return ResponseEntity.ok(cartService.getCart(user));
    }

    @GetMapping("")
    public Cart getCart(Principal principal) {
        User user = userService.findOne(principal.getName());
        return cartService.getCart(user);
    }


    @PostMapping("/add")
    public boolean addToCart(@RequestBody ItemForm form, Principal principal) {
        var productInfo = productService.findOne(form.getProductId());
        try {
            //Uso singleton affinche il risultato sia immutabile, contenga solo quell'elemento e non possa essere modificato
            mergeCart(Collections.singleton(new ProductInOrder(productInfo, form.getQuantity())), principal);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @PutMapping("/{itemId}")
    public ProductInOrder modifyItem(@PathVariable("itemId") String itemId, @RequestBody Integer quantity, Principal principal) {
        User user = userService.findOne(principal.getName());
         productInOrderService.update(itemId, quantity, user);
        return productInOrderService.findOne(itemId, user);
    }

    @DeleteMapping("/{itemId}")
    public void deleteItem(@PathVariable("itemId") String itemId, Principal principal) {
        User user = userService.findOne(principal.getName());
         cartService.delete(itemId, user);
         // svuota la memoria del db
    }


    @PostMapping("/checkout")
    public ResponseEntity checkout(Principal principal) {
        User user = userService.findOne(principal.getName());// Email come username
        cartService.checkout(user);
        return ResponseEntity.ok(null);
    }


}

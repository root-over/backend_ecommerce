package me.magliano.shopapi.api;


import me.magliano.shopapi.service.OrderService;
import me.magliano.shopapi.service.UserService;
import me.magliano.shopapi.entity.OrderMain;
import me.magliano.shopapi.entity.ProductInOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;


@RestController
@CrossOrigin
public class OrderController {
    @Autowired
    OrderService orderService;
    @Autowired
    UserService userService;

    //restituisce tutti gli ordini dell'utente autenticato, se è l'admin restituisce gli ordini complessivi
    @GetMapping("/order")
    public Page<OrderMain> orderList(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                     @RequestParam(value = "size", defaultValue = "10") Integer size,
                                     Authentication authentication) {
        System.out.println("SONO ENTRATO NEGLI ORDINI RAGA");
        PageRequest request = PageRequest.of(page - 1, size);
        System.out.println("SONO AL PRIMO LIVELLO");
        Page<OrderMain> orderPage;
        System.out.println("SONO EAL SECONDO LIVELLO");
        if (authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_CUSTOMER"))) {
            System.out.println("SONO NELL'IF");
            orderPage = orderService.findByBuyerEmail(authentication.getName(), request);
            System.out.println("Mi ha dato: "+orderPage);
            System.out.println("La mail è: "+authentication.getName());
        } else {
            System.out.println("SONO NELL'ELSE");
            orderPage = orderService.findAll(request);
        }
        System.out.println("SONO FUORI DAL TUNNELELELELEL");
        return orderPage;
    }


    //Indovina un po? esatto cancella l'ordine
    @PatchMapping("/order/cancel/{id}")
    public ResponseEntity<OrderMain> cancel(@PathVariable("id") Long orderId, Authentication authentication) {
        OrderMain orderMain = orderService.findOne(orderId);
        if (!authentication.getName().equals(orderMain.getBuyerEmail()) && authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_CUSTOMER"))) {

            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        return ResponseEntity.ok(orderService.cancel(orderId));
    }

    @PatchMapping("/order/finish/{id}")
    public ResponseEntity<OrderMain> finish(@PathVariable("id") Long orderId, Authentication authentication) {
        if (authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_CUSTOMER"))) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        return ResponseEntity.ok(orderService.finish(orderId));
    }

    @GetMapping("/order/{id}")
    public ResponseEntity show(@PathVariable("id") Long orderId, Authentication authentication) {
        boolean isCustomer = authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_CUSTOMER"));
        OrderMain orderMain = orderService.findOne(orderId);
        if (isCustomer && !authentication.getName().equals(orderMain.getBuyerEmail())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        Collection<ProductInOrder> items = orderMain.getProducts();
        return ResponseEntity.ok(orderMain);
    }
}

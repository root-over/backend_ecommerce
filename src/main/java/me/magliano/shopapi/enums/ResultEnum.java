package me.magliano.shopapi.enums;

import lombok.Getter;



@Getter
public enum ResultEnum  {

    PARAM_ERROR(1, "Errore con i parametri!"),
    PRODUCT_NOT_EXIST(10, "Il prodotto non esiste!"),
    PRODUCT_NOT_ENOUGH(11, "Non ci sono abbastanza prodotti disponibili!"),
    PRODUCT_STATUS_ERROR(12, "Stato errato!"),
    PRODUCT_OFF_SALE(13,"Il prodotto non è in vendita!"),
    PRODUCT_NOT_IN_CART(14,"Il prodotto non è nel carrello!"),
    CART_CHECKOUT_SUCCESS(20, "Checkout avvenuto con successo! "),

    CATEGORY_NOT_FOUND(30, "La categoria non esiste!"),

    ORDER_NOT_FOUND(60, "L'ordine non esiste!"),
    ORDER_STATUS_ERROR(61, "Stato errato!"),


    VALID_ERROR(50, "Informazione errata"),
    USER_NOT_FOUNT(40,"Utente non trovato!")
    ;

    private final Integer code;

    private final String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}

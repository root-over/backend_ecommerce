package me.magliano.shopapi.enums;


public enum OrderStatusEnum implements CodeEnum {
    NEW(0, "Nuovo ordine"),
    FINISHED(1, "Finito"),
    CANCELED(2, "Cancellato")
    ;

    private final int code;
    private final String msg;

    OrderStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public Integer getCode() {
        return code;
    }
}

package me.magliano.shopapi.exception;


import me.magliano.shopapi.enums.ResultEnum;


public class MyException extends RuntimeException {

    private final Integer code;

    public MyException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());

        this.code = resultEnum.getCode();
    }

    public MyException(Integer code, String message) {
        super(message);
        this.code = code;
    }
}

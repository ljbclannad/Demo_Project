package com.example.demo.security;

/**
 * @author ：lejb
 * @date ：Created in 2019/9/9 19:10
 * @description :
 */

public class JwtException extends RuntimeException {

    public JwtException(String message){
        super(message);
    }

    public JwtException(){

    }
}

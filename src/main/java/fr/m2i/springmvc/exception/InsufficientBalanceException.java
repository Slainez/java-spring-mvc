
package fr.m2i.springmvc.exception;


public class InsufficientBalanceException extends RuntimeException{

    public InsufficientBalanceException(String message) {
        super(message);
    }
    
    
}

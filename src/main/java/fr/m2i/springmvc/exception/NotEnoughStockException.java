
package fr.m2i.springmvc.exception;


public class NotEnoughStockException extends RuntimeException{

    public NotEnoughStockException(String message) {
        super(message);
    }
    
    
}

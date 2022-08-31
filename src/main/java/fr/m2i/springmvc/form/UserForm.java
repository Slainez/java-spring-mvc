
package fr.m2i.springmvc.form;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


public class UserForm {
    
    @NotNull(message= "This field is mandatory")
    @Min(value = 0 , message = "Vous devez ajouter au moins 1 credit ")
    private Double balance ;

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
    
    
     
}

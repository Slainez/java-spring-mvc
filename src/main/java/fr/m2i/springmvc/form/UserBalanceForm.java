
package fr.m2i.springmvc.form;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


public class UserBalanceForm {
    
   @Min(value = 1, message = "Le montant que vous souhaitez ajouter doit être positif")
   @NotNull(message = "Le champs 'montant' est obligatoire")
    private Double balance ;

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
    
    
     
}

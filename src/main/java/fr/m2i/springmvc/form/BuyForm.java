
package fr.m2i.springmvc.form;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


public class BuyForm {
    
    @NotNull(message = " l\'id ne peut pas être null ")
    @Min(value = 1 , message = "L\'id doit être superieur a 0")
    private Long id ;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
   
    
}

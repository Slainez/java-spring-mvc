
package fr.m2i.springmvc.form;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


public class BuyProductForm {
    
    @NotNull(message = "Le champ numero de produit est obligatoire")
    @Min(value = 1 , message = "Veuillez entrez un numero de produit valide" )
    private Long id ;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
   
    
}

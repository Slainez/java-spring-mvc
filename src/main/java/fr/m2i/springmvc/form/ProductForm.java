
package fr.m2i.springmvc.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


public class ProductForm {
    
    @NotBlank(message= "Le champ non doit être rempli.")
    private String name ;
    
    @NotNull(message = "Le champ prix  doit etre rempli.")
    private Double price ;
    
    @NotNull(message = "Le champ quantité doit etre rempli.")
    private Integer quantity ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    
    
    
}

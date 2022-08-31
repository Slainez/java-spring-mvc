
package fr.m2i.springmvc.model;

import javax.persistence.*;

@Entity
@Table(name="products")
public class Product {
    
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id ;
    
    @Column(name= "name" , length = 100)
    private String name ;
    
    @Column(name = "price")
    private Double price ;
    
    @Column(name = "quantity")
    private Integer quantity ;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

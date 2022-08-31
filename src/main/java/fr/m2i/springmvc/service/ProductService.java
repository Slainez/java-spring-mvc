
package fr.m2i.springmvc.service;

import fr.m2i.springmvc.model.Product;
import fr.m2i.springmvc.repository.ProductRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    
    private final ProductRepository repo ;
    private final UserService userService ;

    public ProductService(ProductRepository repo, UserService userService) {
        this.repo = repo;
        this.userService = userService;
    }
    
    // lister les produits 
    
    public List<Product> findAll(){
        return repo.findAll();
    }
    // Find by Id 
    
    public Product findById(Long id) throws Exception {
        return repo.findById(id).orElseThrow( ()-> new Exception() );
    }
    
    // save 
    
    public void create(Product product)  {
        repo.save(product);
    }
    // acheetr un produit
    
    public void buyProduct(Long id) throws Exception{
        Product productToBuy = new Product();
        
          if(repo.existsById(id)){
               productToBuy = findById(id); 
           }else{
              throw new Exception("Ce produit n'existe pas !");
          }
        
        if(userService.getBalance() >= productToBuy.getPrice() && productToBuy.getQuantity() > 0){
            
           userService.decreaseBalance( productToBuy.getPrice());
           productToBuy.setQuantity(productToBuy.getQuantity() - 1) ;
           repo.save(productToBuy);
        }
    }
    // est ce que j'ai assez de credit ?
    
    
    
}

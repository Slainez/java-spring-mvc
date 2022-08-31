
package fr.m2i.springmvc.service;

import fr.m2i.springmvc.exception.InsufficientBalanceException;
import fr.m2i.springmvc.exception.NotEnoughStockException;
import fr.m2i.springmvc.exception.NotFoundException;
import fr.m2i.springmvc.model.Product;
import fr.m2i.springmvc.repository.ProductRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository repo;
    private final UserService userService;

    @Autowired
    public ProductService(ProductRepository repo, UserService userService) {
        this.repo = repo;
        this.userService = userService;
    }

    public List<Product> findAll() {
        return repo.findAll();
    }

   public Product findById(Long id) throws NotFoundException {
       return repo.findById(id).orElseThrow(()-> {
           throw new NotFoundException("Product with " + id + " was not found.");
       });
   }
    
    // save
    public void save(Product product){
        repo.save(product);
    }
    // acheter un produit
    // -> Est ce que j'ai assez de crédit ?
    // -> Est ce que le produit existe ? il reste du stock ?
    
    public void buyProduct(Long id) throws Exception {
        Product product = findById(id);
        
        if(product.getQuantity() < 1){
            throw new NotEnoughStockException("product with id:" + product.getId() + " has no more stock");
        }
        
        if(userService.getBalance() < product.getPrice()){
            throw new InsufficientBalanceException("User do not have enough balance for the product with id : " + product.getId());
        }
        
        product.setQuantity(product.getQuantity() - 1);
        
        userService.decreaseBalance(product.getPrice());
        
        save(product);
        
    }
}


package fr.m2i.springmvc.controller;

import fr.m2i.springmvc.form.BuyForm;
import fr.m2i.springmvc.form.ProductForm;
import fr.m2i.springmvc.form.UserForm;
import fr.m2i.springmvc.model.Product;
import fr.m2i.springmvc.service.ProductService;
import fr.m2i.springmvc.service.UserService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DistributeurController {
    private final UserService userService ;
    private final ProductService productService;

    @Autowired
    public DistributeurController(UserService userService, ProductService productService) {
        this.userService = userService;
        this.productService = productService;
    }
    
    @GetMapping("/distributeur")  
    public String showDistributeurPage(){
        return "distributeur";
    }
    
    @PostMapping("/addBalance")
    public String addBalance(@ModelAttribute("userForm")  @Valid UserForm user ,
                                        BindingResult result , ModelMap model) {
        
        if ( result.hasErrors()){
            return "distributeur";
        }  
        
        try{
            
            userService.addBalance( user.getBalance() );
            
        }catch (Exception e){
            
            return "distributeur";
        }
       
         try{
            model.addAttribute("balance",  userService.getBalance() );
        }catch (Exception e){
            
            return "distributeur";
        }

        return "redirect:distributeur";
    }
    
     @PostMapping("/addProducts")
    public String addProducts(@ModelAttribute("productForm")  @Valid ProductForm product ,
                                        BindingResult result , ModelMap model) {
        
        if ( result.hasErrors()){
            return "distributeur";
        }  
        
        try{
            
            Product productToCreate = new Product();
            productToCreate.setName(product.getName());
            productToCreate.setPrice(product.getPrice());
            productToCreate.setQuantity(product.getQuantity());
            
            productService.create(productToCreate);
            
        }catch (Exception e){
            
            return "distributeur";
        }
        
         try{
            model.addAttribute("products",  productService.findAll() );
        }catch (Exception e){
            
            return "distributeur";
        }

        return "redirect:distributeur";
    }
    
    @PostMapping("/buyProducts")
     public String buyProducts(@ModelAttribute("buyForm")  @Valid BuyForm buy ,
                                        BindingResult result , ModelMap model) {
         
          if ( result.hasErrors()){
            return "distributeur";
        }
          
         try{
             
             productService.buyProduct(buy.getId())  ;
             
         } catch (Exception e){
            
            return "distributeur";
        }
        
          try{
            model.addAttribute("products",  productService.findAll() );
            model.addAttribute("balance" , userService.getBalance() );
           
        }catch (Exception e){
            
            return "distributeur";
        }
        
         return "redirect:distributeur";
     }
    
    
     
    @ModelAttribute("balance")
    public Double addBalanceBean() throws Exception{
        return userService.getBalance();
    }
    
    @ModelAttribute("products")
    public List<Product> addProductsBean() throws Exception{
        return productService.findAll();
    }
    
    @ModelAttribute("userForm")
    public UserForm addUserForm() {
        return new UserForm();
    }
    
   @ModelAttribute("productForm")
    public ProductForm addProductForm() {
        return new ProductForm();
    }
    @ModelAttribute("buyForm")
    public BuyForm addBuyForm() {
        return new BuyForm();
    }
}

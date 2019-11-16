package storeLab.product_service.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import storeLab.product_service.entity.Product;
import storeLab.product_service.service.ProductEditingService;

import java.util.List;

@Controller
public class MainController {

    private final ProductEditingService productEditingService;

    public MainController(ProductEditingService productEditingService) {
        this.productEditingService = productEditingService;
    }


    @GetMapping("/")
    public String main(Model model){
        List<Product> products;
        products = productEditingService.getAllProducts();
        model.addAttribute("products", products);
        return "add";
    }

    @PostMapping("/add")
    public String addProduct(@RequestParam String name, @RequestParam String price,
                             @RequestParam String discount, Model model){
        float pricef = Float.parseFloat(price);
        productEditingService.addProduct(name,pricef,discount);
        List<Product> products;
        products = productEditingService.getAllProducts();
        model.addAttribute("products", products);
        return "add";
    }
}

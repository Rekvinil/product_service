package storeLab.product_service.controller;

import org.springframework.web.bind.annotation.*;
import storeLab.product_service.entity.Characteristic;
import storeLab.product_service.entity.Product;
import storeLab.product_service.entity.ProductCharacteristic;
import storeLab.product_service.service.ProductEditingService;

import java.util.List;

@RestController
@RequestMapping("/productEditing")
public class ProductEditingController {

    private final ProductEditingService productEditingService;

    public ProductEditingController(ProductEditingService productEditingService) {
        this.productEditingService = productEditingService;
    }

    @GetMapping("/getProducts")
    public List<Product> getProducts(){
        return productEditingService.getAllProducts();
    }

    @GetMapping("/{product}")
    public Product getProductById(@PathVariable Product product){
        return productEditingService.getProductById(product.getId());
    }

    @GetMapping("/getCharacteristicsOfProduct/{product}")
    public List<ProductCharacteristic> getCharacteristicsOfProduct(@PathVariable Product product){
        return productEditingService.getCharacteristicsOfProduct(product);
    }

    @PostMapping("/addProduct")
    public void addProduct(@RequestBody Product product){
        productEditingService.addProduct(product.getName(), product.getPrice(), product.getDiscount(), product.getImg());
    }

    @PostMapping("/addProduct/addCharacteristic")
    public void addCharacteristic(@RequestBody ProductCharacteristic productCharacteristic){
        productEditingService.addCharacteristic(productCharacteristic.getProduct(), productCharacteristic.getCharacteristics(),
                productCharacteristic.getValue());
    }

    @PutMapping("/changeProduct")
    public void changeProduct(@RequestBody Product product){
        productEditingService.changeProduct(product.getId(), product.getName(), product.getPrice(), product.getDiscount(),
                product.getImg());
    }

    @PutMapping("/changeCharacteristicsOfProduct")
    public void changeCharacteristicsOfProduct(@RequestBody ProductCharacteristic[] productCharacteristics){
        productEditingService.changeCharacteristicsOfProduct(productCharacteristics);
    }

    @DeleteMapping("/deleteProduct/{product}")
    public void deleteProduct(@PathVariable Product product){
        productEditingService.deleteProduct(product.getId());
    }
}

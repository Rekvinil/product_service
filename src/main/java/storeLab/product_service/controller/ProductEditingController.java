package storeLab.product_service.controller;

import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import storeLab.product_service.entity.Characteristic;
import storeLab.product_service.entity.Product;
import storeLab.product_service.entity.ProductCharacteristic;
import storeLab.product_service.service.ProductEditingService;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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

    @GetMapping("/getProductsByCharacteristics")
    public List<Product> getProductsByCharacteristics(@RequestParam MultiValueMap<String, String> params){
        return productEditingService.getProductsByCharacteristics(params);
    }

    @PostMapping("/addProduct")
    public void addProduct(@RequestBody Product product){
        productEditingService.addProduct(product.getName(), product.getPrice(), product.getDiscount(), product.getImg(), product.getCount());
    }

    @PostMapping("/addProduct/addCharacteristic")
    public void addCharacteristic(@RequestBody ProductCharacteristic productCharacteristic){
        productEditingService.addCharacteristic(productCharacteristic.getProduct(), productCharacteristic.getCharacteristics(),
                productCharacteristic.getValue());
    }

    @PutMapping("/changeProduct")
    public void changeProduct(@RequestBody Product product){
        productEditingService.changeProduct(product.getId(), product.getName(), product.getPrice(), product.getDiscount(),
                product.getImg(), product.getCount());
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

package storeLab.product_service.service;

import org.springframework.stereotype.Service;
import storeLab.product_service.entity.Characteristic;
import storeLab.product_service.entity.Product;
import storeLab.product_service.entity.ProductCharacteristic;
import storeLab.product_service.repository.CharacteristicRepository;
import storeLab.product_service.repository.ProductCharacteristicRepository;
import storeLab.product_service.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductEditingService {
    private final ProductRepository productRepository;

    private final ProductCharacteristicRepository productCharacteristicRepository;


    public ProductEditingService(ProductRepository productRepository, ProductCharacteristicRepository productCharacteristicRepository, CharacteristicRepository characteristicRepository) {
        this.productRepository = productRepository;
        this.productCharacteristicRepository = productCharacteristicRepository;
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Product getProductById(Integer id){
        return productRepository.findById(id).orElse(null);
    }

    public List<ProductCharacteristic> getCharacteristicsOfProduct(Product product){
        return productCharacteristicRepository.findByProduct(product);
    }

    public String getValueOfCharacteristic(Product product, Characteristic characteristic){
        return productCharacteristicRepository.findByProductAndCharacteristics(product, characteristic).getValue();
    }

    public void addCharacteristic(Product pr, Characteristic ch, String value){
        productCharacteristicRepository.save(new ProductCharacteristic(pr,ch,value));
    }

    public void addProduct(String name, float price, String discount, String img){
        productRepository.save(new Product(name, price, discount, img));
    }

    public void changeProduct(Integer id, String name, float price, String discount, String img){
        Product p = productRepository.findById(id).orElse(null);
        if(p==null){
            return;
        }
        p.setName(name);
        p.setPrice(price);
        p.setDiscount(discount);
        p.setImg(img);
        productRepository.save(p);
    }

    public void changeCharacteristicOfProduct(Product product, Characteristic characteristic, String value){
        ProductCharacteristic pc = productCharacteristicRepository.findByProductAndCharacteristics(product, characteristic);
        pc.setValue(value);
        productCharacteristicRepository.save(pc);
    }

    public void deleteProduct(Product product){
        productRepository.deleteById(product.getId());
        productCharacteristicRepository.deleteByProduct(product);
    }

}

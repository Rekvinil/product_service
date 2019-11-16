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

    private final CharacteristicRepository characteristicRepository;


    public ProductEditingService(ProductRepository productRepository, ProductCharacteristicRepository productCharacteristicRepository, CharacteristicRepository characteristicRepository) {
        this.productRepository = productRepository;
        this.productCharacteristicRepository = productCharacteristicRepository;
        this.characteristicRepository = characteristicRepository;
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public List<Characteristic> getCharacteristicOfProduct(Product product){
        List<ProductCharacteristic> pc = productCharacteristicRepository.findByProduct(product);
        List<Characteristic> lst = new ArrayList<>();
        for(ProductCharacteristic p : pc){
            lst.add(p.getCharacteristics());
        }
        return lst;
    }

    public String getValueOfCharacteristic(Product product, Characteristic characteristic){
        return productCharacteristicRepository.findByProductAndCharacteristics(product, characteristic).getValue();
    }

    public void addCharacteristic(Product pr, Characteristic ch, String value){
        productCharacteristicRepository.save(new ProductCharacteristic(pr,ch,value));
    }

    public void addProduct(String name, float price, String discount){
        productRepository.save(new Product(name,price,discount));
    }
}

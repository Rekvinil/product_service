package storeLab.product_service.service;

import com.sun.jndi.toolkit.url.Uri;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.MultiValueMap;
import org.springframework.web.util.UriUtils;
import storeLab.product_service.entity.Characteristic;
import storeLab.product_service.entity.Product;
import storeLab.product_service.entity.ProductCharacteristic;
import storeLab.product_service.repository.CharacteristicRepository;
import storeLab.product_service.repository.ProductCharacteristicRepository;
import storeLab.product_service.repository.ProductRepository;

import javax.persistence.criteria.CriteriaBuilder;
import java.nio.charset.Charset;
import java.util.*;

@Service
@Transactional
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

    public void changeCharacteristicsOfProduct(ProductCharacteristic[] productCharacteristics){
        for(ProductCharacteristic pc : productCharacteristics){
            productCharacteristicRepository.save(pc);
        }
    }

    public void deleteProduct(Integer id){
        productCharacteristicRepository.deleteByProduct(productRepository.findById(id).orElse(null));
        //productRepository.deleteById(id);
    }

    public List<Product> getProductsByCharacteristics(MultiValueMap<String,String> params){
        Set<Integer> products = new LinkedHashSet<>();
        boolean flag;
        for(Product product : productRepository.findAll()){
            flag=true;
            for(ProductCharacteristic pc : getCharacteristicsOfProduct(product)){
                if(params.containsKey(UriUtils.encode(pc.getCharacteristics().getName(), Charset.defaultCharset()))){
                    if(!params.get(UriUtils.encode(pc.getCharacteristics().getName(),Charset.defaultCharset())).contains(UriUtils.encode(pc.getValue(), Charset.defaultCharset()))){
                        flag = false;
                    }
                }
            }
            if(flag){
                products.add(product.getId());
            }
        }
        List<Product> productList = new ArrayList<>();
        for(Integer id : products){
            productList.add(productRepository.findById(id).orElse(null));
        }
        return productList;
    }

}

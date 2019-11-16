package storeLab.product_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import storeLab.product_service.entity.Characteristic;
import storeLab.product_service.entity.Product;
import storeLab.product_service.entity.ProductCharacteristic;

import java.util.List;

public interface ProductCharacteristicRepository extends JpaRepository<ProductCharacteristic, Integer> {
    List<ProductCharacteristic> findByProduct(Product product);
    ProductCharacteristic findByProductAndCharacteristics(Product product, Characteristic characteristic);
}

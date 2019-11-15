package storeLab.product_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import storeLab.product_service.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}

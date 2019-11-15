package storeLab.product_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import storeLab.product_service.entity.Characteristic;

public interface CharacteristicRepository extends JpaRepository<Characteristic, Integer> {
}

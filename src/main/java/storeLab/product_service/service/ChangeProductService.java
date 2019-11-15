package storeLab.product_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import storeLab.product_service.repository.CharacteristicRepository;
import storeLab.product_service.repository.ProductCharacteristicRepository;
import storeLab.product_service.repository.ProductRepository;

@Service
public class ChangeProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductCharacteristicRepository productCharacteristicRepository;

    @Autowired
    private CharacteristicRepository characteristicRepository;


}

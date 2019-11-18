package storeLab.product_service.service;

import org.springframework.stereotype.Service;
import storeLab.product_service.entity.Characteristic;
import storeLab.product_service.repository.CharacteristicRepository;
import storeLab.product_service.repository.ProductCharacteristicRepository;

import java.util.List;

@Service
public class CharacteristicEditingService {
    private final CharacteristicRepository characteristicRepository;

    private final ProductCharacteristicRepository productCharRep;

    public CharacteristicEditingService(CharacteristicRepository characteristicRepository, ProductCharacteristicRepository productCharRep) {
        this.characteristicRepository = characteristicRepository;
        this.productCharRep = productCharRep;
    }

    public void addCharacteristic(String name, String description){
        characteristicRepository.save(new Characteristic(name, description));
    }

    public List<Characteristic> getCharacterisitics(){
        return characteristicRepository.findAll();
    }



}

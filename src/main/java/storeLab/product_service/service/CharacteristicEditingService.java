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

    public Characteristic getCharacteristicByName(String name){
        return characteristicRepository.getCharacteristicByName(name);
    }

    public Characteristic getCharacteristic(Integer id){
        return characteristicRepository.findById(id).orElse(null);
    }

    public void changeCharacteristic(Integer id, String name, String description){
        Characteristic c = characteristicRepository.findById(id).orElse(null);
        if(c!=null){
            c.setName(name);
            c.setDescription(description);
            characteristicRepository.save(c);
        }
    }

    public void deleteCharacteristic(Integer id){
        characteristicRepository.deleteById(id);
    }

}

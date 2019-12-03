package storeLab.product_service.controller;

import org.springframework.web.bind.annotation.*;
import storeLab.product_service.entity.Characteristic;
import storeLab.product_service.service.CharacteristicEditingService;

import java.util.List;

@RequestMapping("/characteristicsEditing")
@RestController
public class CharacteristicEditingController {
    private final CharacteristicEditingService charEditServ;

    public CharacteristicEditingController(CharacteristicEditingService charEditServ) {
        this.charEditServ = charEditServ;
    }

    @GetMapping("/getCharacteristics")
    public @ResponseBody List<Characteristic> getCharacteristics(){
        return charEditServ.getCharacterisitics();
    }

    @PostMapping("/addCharacteristic")
    public void addCharacteristic(@RequestBody Characteristic characteristic){
        charEditServ.addCharacteristic(characteristic.getName(), characteristic.getDescription());
    }

    @GetMapping("/getCharacteristics/{characteristic}")
    public Characteristic getCharacteristic(@PathVariable Characteristic characteristic){
        return characteristic;
    }

    @PutMapping("/characteristicEdit")
    public void changeCharacteristic(@RequestBody Characteristic characteristic){
        charEditServ.changeCharacteristic(characteristic.getId(),characteristic.getName(),characteristic.getDescription());
    }

    @DeleteMapping("/deleteCharacteristic/{characteristic}")
    public void deleteCharacteristic(@PathVariable Characteristic characteristic){
        charEditServ.deleteCharacteristic(characteristic.getId());
    }
}

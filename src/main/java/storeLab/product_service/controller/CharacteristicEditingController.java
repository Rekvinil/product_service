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
    public void addCharacteristic(@RequestParam String name, @RequestParam String description){
        charEditServ.addCharacteristic(name,description);
    }

    @GetMapping("/getCharacteristics/{characteristic}")
    public Characteristic getCharacteristic(@PathVariable Characteristic characteristic){
        return characteristic;
    }

    @PutMapping("/characteristicEdit/{characteristic}")
    public void changeCharacteristic(@RequestParam String name,
                                       @RequestParam String description,
                                       @PathVariable Characteristic characteristic){
        charEditServ.changeCharacteristic(characteristic.getId(),name,description);
    }

    @DeleteMapping("/deleteCharacteristic/{characteristic}")
    public void deleteCharacteristic(@PathVariable Characteristic characteristic){
        charEditServ.deleteCharacteristic(characteristic.getId());
    }


}

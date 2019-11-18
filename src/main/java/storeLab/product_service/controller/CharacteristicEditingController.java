package storeLab.product_service.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import storeLab.product_service.entity.Characteristic;
import storeLab.product_service.service.CharacteristicEditingService;

import java.util.List;

@Controller

public class CharacteristicEditingController {
    private final CharacteristicEditingService charEditServ;

    public CharacteristicEditingController(CharacteristicEditingService charEditServ) {
        this.charEditServ = charEditServ;
    }

    @GetMapping("/addCharacteristic")
    public String getCharacteristics(Model model){
        List<Characteristic> characteristics = charEditServ.getCharacterisitics();
        model.addAttribute("characteristics", characteristics);
        return "addCharacteristic";
    }

    @PostMapping("/addCharacteristic")
    public String addCharacteristic(@RequestParam String name, @RequestParam String description,
                                    Model model){
        charEditServ.addCharacteristic(name,description);
        List<Characteristic> characteristics = charEditServ.getCharacterisitics();
        model.addAttribute("characteristics", characteristics);
        return "addCharacteristic";
    }
}

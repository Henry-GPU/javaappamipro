package com.example.mysql.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mysql.model.battery.Battery;
import com.example.mysql.model.battery.BatteryBrand;
import com.example.mysql.model.battery.BatteryDto;
import com.example.mysql.model.battery.BatteryModel;
import com.example.mysql.model.response.ApiResponse;
import com.example.mysql.repository.battery.BatteryBrandRepository;
import com.example.mysql.repository.battery.BatteryModelRepository;
import com.example.mysql.service.BatteryService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("api/battery")
public class BatteryController {
    @Autowired
    private BatteryService batteryService;

    @Autowired
    private BatteryBrandRepository batteryBrandRepository;

    @Autowired
    private BatteryModelRepository batteryModelRepository;

    @PostMapping
    public ResponseEntity<ApiResponse<Battery>> createBattery(@RequestBody BatteryDto batteryDto){
        Optional<BatteryBrand> brandOptional = batteryBrandRepository.findById(batteryDto.getBrandId());
        Optional<BatteryModel> modelOptional = batteryModelRepository.findById(batteryDto.getModelId());
  
        if(!brandOptional.isPresent() || !modelOptional.isPresent()){
            return ResponseEntity.badRequest().body(null);
        }

        Battery bat = new Battery();
        bat.setBrand(brandOptional.get());
        bat.setModel(modelOptional.get());
        bat.setSerie(batteryDto.getSerie());
        bat.setState(batteryDto.getState());

        ApiResponse<Battery> createdBattery = batteryService.createBattery(bat);
        return new ResponseEntity<>(createdBattery, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Battery> getAllBatteries() {
        return batteryService.getAllBatteries();
    }
    
}

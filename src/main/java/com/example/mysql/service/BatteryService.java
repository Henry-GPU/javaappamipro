package com.example.mysql.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mysql.model.battery.Battery;
import com.example.mysql.model.response.ApiResponse;
import com.example.mysql.repository.battery.BatteryBrandRepository;
import com.example.mysql.repository.battery.BatteryModelRepository;
import com.example.mysql.repository.battery.BatteryRepository;

@Service
public class BatteryService {
    @Autowired
    private BatteryRepository batteryRepository;

    @Autowired
    private BatteryModelRepository batteryModelRepository;

    @Autowired
    private BatteryBrandRepository batteryBrandRepository;

    public ApiResponse<Battery> createBattery(Battery battery){
        if(!batteryRepository.existsBySerie(battery.getSerie())){
            Battery savedBattery = batteryRepository.save(battery);
            
            return new ApiResponse<>("Batería almacenada correctamente.", savedBattery);
        }

        return new ApiResponse<>("La batería con la serie " 
        + battery.getSerie() 
        + " ya existe.",
         null);
    }
    public List<Battery> getAllBatteries(){
        return batteryRepository.findAll();
    }

}

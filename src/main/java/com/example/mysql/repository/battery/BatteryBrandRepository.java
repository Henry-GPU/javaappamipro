package com.example.mysql.repository.battery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.mysql.model.battery.BatteryBrand;

@Repository
public interface BatteryBrandRepository extends JpaRepository<BatteryBrand, Integer>{
    
}

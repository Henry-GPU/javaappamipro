package com.example.mysql.repository.battery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.mysql.model.battery.Battery;

@Repository
public interface BatteryRepository extends JpaRepository<Battery, Integer>{
    boolean existsBySerie(String serie); 
}

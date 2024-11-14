package com.example.mysql.repository.battery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.mysql.model.battery.BatteryBrand;
import com.example.mysql.model.battery.BatteryModel;
import java.util.List;

@Repository
public interface BatteryModelRepository extends JpaRepository<BatteryModel, Integer>{
    List<BatteryModel> findByBrand(BatteryBrand brand);
}

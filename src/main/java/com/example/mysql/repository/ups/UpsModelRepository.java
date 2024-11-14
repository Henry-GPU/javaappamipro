package com.example.mysql.repository.ups;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.mysql.model.ups.UpsBrand;
import com.example.mysql.model.ups.UpsModel;

@Repository
public interface UpsModelRepository extends JpaRepository<UpsModel, Integer>{
    List<UpsModel> findByBrand(UpsBrand brand);
}

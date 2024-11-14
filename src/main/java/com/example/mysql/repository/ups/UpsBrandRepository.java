package com.example.mysql.repository.ups;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.mysql.model.ups.UpsBrand;

@Repository
public interface UpsBrandRepository extends JpaRepository<UpsBrand, Integer> {

}
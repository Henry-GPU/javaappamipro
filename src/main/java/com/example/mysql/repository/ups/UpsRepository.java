package com.example.mysql.repository.ups;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.mysql.model.ups.Ups;

@Repository
public interface UpsRepository extends JpaRepository<Ups, Integer> {
    
}

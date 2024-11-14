package com.example.mysql.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mysql.model.ups.Ups;
import com.example.mysql.model.ups.UpsBrand;
import com.example.mysql.model.ups.UpsModel;
import com.example.mysql.repository.ups.UpsBrandRepository;
import com.example.mysql.repository.ups.UpsModelRepository;
import com.example.mysql.repository.ups.UpsRepository;

@Service
public class UpsService {

    @Autowired
    private UpsRepository upsRepository;

    @Autowired
    private UpsModelRepository upsModelRepository;

    @Autowired
    private UpsBrandRepository upsBrandRepository;

    public Ups createUps(Ups ups){
        return upsRepository.save(ups);
    }
    
    public List<Ups> getAllUps(){
        return upsRepository.findAll();
    }

    public Ups updateUps(Ups ups){
        return upsRepository.save(ups);
    }
    public Optional<Ups> getById(Integer id){
        return upsRepository.findById(id);
    }
    public void deleteUps(Integer id){
        upsRepository.deleteById(id);;
    }

    public List<UpsBrand> getAllBrands(){
        return upsBrandRepository.findAll();
    }

    public List<UpsModel> getModelsByBrandId(Integer brandId){
        Optional<UpsBrand> upsBrandOptional = upsBrandRepository.findById(brandId);
        if(upsBrandOptional.isPresent()){
            return upsModelRepository.findByBrand(upsBrandOptional.get());
        }
        return new ArrayList<>();
    }
}

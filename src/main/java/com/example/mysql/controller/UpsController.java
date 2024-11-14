package com.example.mysql.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mysql.model.ups.Ups;
import com.example.mysql.model.ups.UpsBrand;
import com.example.mysql.model.ups.UpsDto;
import com.example.mysql.model.ups.UpsModel;
import com.example.mysql.repository.ups.UpsBrandRepository;
import com.example.mysql.repository.ups.UpsModelRepository;
import com.example.mysql.service.UpsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;





@RestController
@RequestMapping("api/ups")
public class UpsController {
    
    @Autowired
    private UpsService upsService;

    @Autowired
    private UpsBrandRepository upsBrandRepository;

    @Autowired
    private UpsModelRepository upsModelRepository;

    @PostMapping
    public ResponseEntity<Ups> createUps(@RequestBody UpsDto upsDto) {

        Optional<UpsBrand> brandOptional = upsBrandRepository.findById(upsDto.getBrandId());
        Optional<UpsModel> modelOptional = upsModelRepository.findById(upsDto.getModelId());

        if (!brandOptional.isPresent() || !modelOptional.isPresent()) {
            return ResponseEntity.badRequest().body(null); 
        }

        Ups ups = new Ups();
        ups.setBrand(brandOptional.get());
        ups.setModel(modelOptional.get());
        ups.setSerie(upsDto.getSerie());
        ups.setState(upsDto.getState());

        Ups createdUps = upsService.createUps(ups);

        return new ResponseEntity<>(createdUps, HttpStatus.CREATED);
    }
    
    @GetMapping
    public List<Ups> getAllUps() {
        return upsService.getAllUps();
    }
    
    @GetMapping("/brands")
    public List<UpsBrand> getAllBrands() {
        return upsService.getAllBrands();
    }

    @GetMapping("brands/{id}/models")
    public ResponseEntity<List<UpsModel>> getModelsByBrand(@PathVariable Integer id) {
        List<UpsModel> models = upsService.getModelsByBrandId(id);

        if(models.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(models);
    }
    
    public String getMethodName(@RequestParam String param) {
        return new String();
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Ups> updateUps(@PathVariable Integer id, @RequestBody UpsDto upsDto) {
        
        Optional<Ups> existingUpsOptional = upsService.getById(id);
        if (!existingUpsOptional.isPresent()) {
            return ResponseEntity.notFound().build(); // Retorna 404 si el objeto no existe
        }

        Optional<UpsBrand> brandOptional = upsBrandRepository.findById(upsDto.getBrandId());
        Optional<UpsModel> modelOptional = upsModelRepository.findById(upsDto.getModelId());
        if (!brandOptional.isPresent() || !modelOptional.isPresent()) {
            return ResponseEntity.badRequest().body(null); 
        }

        Ups ups = existingUpsOptional.get();
        ups.setBrand(brandOptional.get());
        ups.setModel(modelOptional.get());
        ups.setSerie(upsDto.getSerie());
        ups.setEntryDate(upsDto.getEntryDate());
        ups.setSaleDate(upsDto.getSaleDate());
        ups.setState(upsDto.getState());
        
        Ups updatedUps = upsService.updateUps(ups);
        return new ResponseEntity<>(updatedUps, HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Ups> partialUpdateUps(@PathVariable Integer id, @RequestBody UpsDto upsDto) {
        
        Optional<Ups> existingUpsOptional = upsService.getById(id);
        if (!existingUpsOptional.isPresent()) {
            return ResponseEntity.notFound().build(); // Si no se encuentra el UPS, devolver 404
        }

        Ups ups = existingUpsOptional.get();

        // Actualiza solo los campos proporcionados

        if (upsDto.getState() != null) {
            ups.setState(upsDto.getState());
        }

        if (upsDto.getSerie() != null) {
            ups.setSerie(upsDto.getSerie());
        }

        if (upsDto.getBrandId() != null) {
            Optional<UpsBrand> brandOptional = upsBrandRepository.findById(upsDto.getBrandId());
            if (brandOptional.isPresent()) {
                ups.setBrand(brandOptional.get());
            }
        }

        if (upsDto.getModelId() != null) {
            Optional<UpsModel> modelOptional = upsModelRepository.findById(upsDto.getModelId());
            if (modelOptional.isPresent()) {
                ups.setModel(modelOptional.get());
            }
        }

        // Guardar los cambios
        Ups updatedUps = upsService.updateUps(ups);
        return new ResponseEntity<>(updatedUps, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUps(@PathVariable Integer id) {
        Optional<Ups> upsOptional = upsService.getById(id);
        if (!upsOptional.isPresent()) {
            return ResponseEntity.notFound().build(); // Retorna 404 si el objeto no existe
        }

        upsService.deleteUps(id); // Llama al servicio para eliminar el UPS
        return ResponseEntity.noContent().build(); // Retorna 204 si se eliminó correctamente
    }


}

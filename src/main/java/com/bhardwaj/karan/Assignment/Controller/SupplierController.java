package com.bhardwaj.karan.Assignment.Controller;

import com.bhardwaj.karan.Assignment.Entity.ManufacturingProcess;
import com.bhardwaj.karan.Assignment.Entity.NatureOfBusiness;
import com.bhardwaj.karan.Assignment.Entity.Supplier;
import com.bhardwaj.karan.Assignment.Exception.SupplierNotFoundException;
import com.bhardwaj.karan.Assignment.Service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/supplier")
public class SupplierController {

    @Autowired
    private SupplierService service;

    @PostMapping("/add")
    public Supplier addSupplier(@RequestBody Supplier newSupplier){
        return service.addSupplier(newSupplier);
    }
    @GetMapping("/query")
    public ResponseEntity<Page<Supplier>> searchSupplier(@RequestParam String location,
                                                         @RequestParam NatureOfBusiness natureOfBusiness,
                                                         @RequestParam ManufacturingProcess process,
                                                         @RequestParam(defaultValue = "10") int size) throws Exception {
        Page<Supplier> result;
        try{
            result = service.specifiedSupplier(location,natureOfBusiness,process, size);
        }catch (Exception e){
            throw new SupplierNotFoundException("Record not found");
        }
        return ResponseEntity.ok(result);
    }
}

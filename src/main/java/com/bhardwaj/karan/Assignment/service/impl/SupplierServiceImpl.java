package com.bhardwaj.karan.Assignment.service.impl;


import com.bhardwaj.karan.Assignment.entity.ManufacturingProcess;
import com.bhardwaj.karan.Assignment.entity.NatureOfBusiness;
import com.bhardwaj.karan.Assignment.entity.Supplier;
import com.bhardwaj.karan.Assignment.exception.SupplierNotFoundException;
import com.bhardwaj.karan.Assignment.repository.SupplierRepository;
import com.bhardwaj.karan.Assignment.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    private SupplierRepository repository;

    @Override
    public Supplier addSupplier(Supplier newSupplier){
        return repository.save(newSupplier);
    }
    @Override
    public Page<Supplier> specifiedSupplier(String location, NatureOfBusiness natureOfBusiness,
                                            ManufacturingProcess process, int size) {
        Pageable pageable = Pageable.ofSize(size);
        Page<Supplier> suppliers = repository.findSuppliers(location, natureOfBusiness, process, pageable);
        if(suppliers.isEmpty()) {
            throw new SupplierNotFoundException("Requested Supplier does not found");
        }
        return suppliers;
    }



}


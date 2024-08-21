package com.bhardwaj.karan.Assignment.service;

import com.bhardwaj.karan.Assignment.entity.ManufacturingProcess;
import com.bhardwaj.karan.Assignment.entity.NatureOfBusiness;
import com.bhardwaj.karan.Assignment.entity.Supplier;
import org.springframework.data.domain.Page;

public interface SupplierService {

   Supplier addSupplier(Supplier supplier);

   Page<Supplier> specifiedSupplier(String location, NatureOfBusiness natureOfBusiness,
                                      ManufacturingProcess process, int size);
}

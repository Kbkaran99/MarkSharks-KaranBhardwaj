package com.bhardwaj.karan.Assignment.Service;

import com.bhardwaj.karan.Assignment.Entity.ManufacturingProcess;
import com.bhardwaj.karan.Assignment.Entity.NatureOfBusiness;
import com.bhardwaj.karan.Assignment.Entity.Supplier;
import org.springframework.data.domain.Page;

import java.util.List;

public interface SupplierService {

   Supplier addSupplier(Supplier supplier);

   Page<Supplier> specifiedSupplier(String location, NatureOfBusiness natureOfBusiness,
                                      ManufacturingProcess process, int size);
}

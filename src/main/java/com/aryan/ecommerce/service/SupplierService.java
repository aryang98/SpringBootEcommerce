package com.aryan.ecommerce.service;

import java.util.List;

import com.aryan.ecommerce.entity.Supplier;

public interface SupplierService {
	Supplier addSupplier(Supplier supplier);

	Supplier updateSupplier(int supplierId, Supplier supplier);

	boolean deleteSupplier(int supplierId);

	List<Supplier> getAllSuppliers();

	Supplier getSupplierById(int supplierId);
}

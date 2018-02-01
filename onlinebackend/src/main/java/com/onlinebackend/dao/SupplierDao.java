package com.onlinebackend.dao;

import java.util.List;

import com.onlinebackend.model.Supplier;

public interface SupplierDao {
	Supplier getSupplierById(int id);
	List<Supplier> getAllSupplier();
	boolean insertSupp(Supplier supplier);
	boolean updateSupp(Supplier supplier);
	boolean deleteSupp(Supplier supplier);

}

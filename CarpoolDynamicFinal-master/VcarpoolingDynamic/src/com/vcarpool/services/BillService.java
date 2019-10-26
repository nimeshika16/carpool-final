package com.vcarpool.services;

import com.vcarpool.exception.VCarpoolException;
import com.vcarpool.model.Bill;

public interface BillService {

	public int insert(Bill bill) throws VCarpoolException;

	public int update(Bill bill, String field, String value) throws VCarpoolException;

	public int delete(Bill bill) throws VCarpoolException;
	
	
}

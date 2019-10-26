package com.vcarpool.services;

import com.vcarpool.dao.BillDao;
import com.vcarpool.exception.VCarpoolException;
import com.vcarpool.model.Bill;

public class BillServiceImpl implements BillService {

	private BillDao billDao = new BillDao();

	public int insert(Bill bill) throws VCarpoolException {
  
		return billDao.insert(bill);
	}

	public int update(Bill bill, String field, String value) throws VCarpoolException {

		return billDao.update(bill, field, value);
	}

	public int delete(Bill bill) throws VCarpoolException {
		
		return billDao.delete(bill);
	}

}
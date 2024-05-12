package com.mytech.pretest2.services;

import java.util.List;

import com.mytech.pretest2.entities.EBook;

public interface EBookService {

	public void save(EBook ebook);
	public List<EBook> listAll();
	public EBook get(int id);
	public void delete(int id);
}

package com.mytech.pretest2.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mytech.pretest2.entities.EBook;
import com.mytech.pretest2.repositories.EBookRepository;
import com.mytech.pretest2.services.EBookService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class EBookServiceImpl implements EBookService{

	@Autowired
	private EBookRepository eBookRepository;
	
	@Override
	public void save(EBook ebook) {
		// TODO Auto-generated method stub
		eBookRepository.save(ebook);
	}

	@Override
	public List<EBook> listAll() {
		// TODO Auto-generated method stub
		return (List<EBook>) eBookRepository.findAll();
	}

	@Override
	public EBook get(int id) {
		// TODO Auto-generated method stub
		return eBookRepository.findById(id).get();
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		eBookRepository.deleteById(id);
	}

}

package com.hellojava.mybatis01.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hellojava.mbatis01.entity.Book;
import com.hellojava.mybatis01.dao.IBookDao;

@Service("bookService")
public class BookService {
	@Autowired
	private IBookDao bookDao;
	
	public List<Book> loadAll(){
		return bookDao.loadAll();
	}
}

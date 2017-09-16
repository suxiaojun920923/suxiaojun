package com.hellojava.spring.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hellojava.spring.business.IBookService;
import com.hellojava.spring.dao.IBookDao;
import com.hellojava.spring.entity.Book;

@Service("bookService")
public class BookService implements IBookService {
	@Autowired
	private IBookDao bookDao;
	@Override
	public List<Book> loadAll(int page,int displayCount) {
		return bookDao.loadAll(page, displayCount);
	}
	@Override
	public int calctorMaxPage(int displayCount) {
		int totalCount=bookDao.getTotalCount();
		return totalCount%displayCount==0?totalCount/displayCount:totalCount/displayCount+1;
	}
	
	public boolean save(Book b) {
		int count=bookDao.save(b);
		return count>0?true:false;
	}
	
	@Override
	public boolean delete(int bookId) {
		int count=bookDao.delete(bookId);
		return count>0?true:false;
	}
	
	@Override
	public boolean update(Book b) {
		int count=bookDao.update(b);
		return count>0?true:false;
	}
	@Override
	public Book loadBookById(int bookId) {
		return bookDao.loadBookById(bookId);
	}
}

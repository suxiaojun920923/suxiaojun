package com.hellojava.spring.business;

import java.util.List;

import com.hellojava.spring.entity.Book;

public interface IBookService {
	public List<Book> loadAll(int page,int displayCount);
	public int calctorMaxPage(int displayCount);
	public boolean save(Book b);
	public boolean delete(int bookId);
	public boolean update(Book b);
	public Book loadBookById(int bookId);
}

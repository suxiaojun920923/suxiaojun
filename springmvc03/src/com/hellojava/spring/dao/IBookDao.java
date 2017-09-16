package com.hellojava.spring.dao;

import java.util.List;

import com.hellojava.spring.entity.Book;

public interface IBookDao {
	public List<Book> loadAll(int page,int displaryCount);
	public int getTotalCount();
	public int save(Book b);
	public int delete(int bookId);
	public int update(Book b);
	public Book loadBookById(int bookId);
}

package com.hellojava.ssm.business;

import java.util.List;

import com.hellojava.ssm.entity.Book;

public interface IBookService {
	public List<Book> loadAll();
}

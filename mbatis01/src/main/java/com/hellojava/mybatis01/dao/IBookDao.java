package com.hellojava.mybatis01.dao;

import java.util.List;

import com.hellojava.mbatis01.entity.Book;

public interface IBookDao {
	public List<Book> loadAll();
}

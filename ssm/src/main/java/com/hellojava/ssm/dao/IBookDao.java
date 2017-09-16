package com.hellojava.ssm.dao;

import java.util.List;

import com.hellojava.ssm.entity.Book;

public interface IBookDao {
	public List<Book> loadAll();
}

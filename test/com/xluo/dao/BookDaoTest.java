package com.xluo.dao;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import com.xluo.po.Book;
import com.xluo.util.UUIDUtil;

public class BookDaoTest {

	private BookDao bookDao = new BookDao();

	@Test
	public void testInsert() {
		try {
			bookDao.insert(new String[] { "id", "bookname", "author", "account", "publishTime", "type", "img"},
					new Object[] { UUIDUtil.getUUID(), "oracle", "xiaoming", 2, "2015-01-01", "database", "/door.jpg"});
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testSelectList(){
		try {
			List<Book> books = bookDao.selectList(new String[] { "type" }, new Object[] {"database"},
					new String[] { "img", "bookname" });
			for(Book book : books){
				System.out.println(book.getBookname());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
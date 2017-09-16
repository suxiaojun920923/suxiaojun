package com.hellojava.spring.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.hellojava.spring.business.IBookService;
import com.hellojava.spring.entity.Book;

@Controller
//��model�� ���ڵ�keyΪbookList page maxPage�����ݱ��浽session��
@SessionAttributes(names= {"bookList","page","maxPage"})
public class BookController {
	@Autowired
	private IBookService bookService;
	//@ModelAttribute 1:�����һ��Controller���г�����ʹ��ModelAttribute
	//ע���ʶ�ķ�����ô ��ǰ������е�RequestMapping��ʶ�ķ���ִ��֮ǰһ����ִ��ModelAttribute��ʶ�ķ���
	
	//2:ʹ��ModelAttributeע���ʶ�ķ�������з���ֵ��ô��ѷ���ָ�洢Model�� key ���ǵ�ǰ����ֵ�����͵ĵ�һ��ĸСд
	
	//3:ModelAttribute ���԰ѵ�ǰmodel�е����ݺͱ��ύ�����ݽ��кϲ�
	@ModelAttribute
	public Book initBook(@RequestParam(required=false,defaultValue="0")int bookId) {
		System.out.println("initBook");
		Book b=null;
		if(bookId>0) {
			b=bookService.loadBookById(bookId);
		}else {
			b=new Book();
		}
		return b;
	}
	
	//Model ģ������(Map)
	@RequestMapping("/loadAll")
	public String loadAll(@RequestParam(required=false,defaultValue="0")int page,Model model) {
		int displayCount=10;
		int maxPage=bookService.calctorMaxPage(displayCount);
		if(page<0) {
			page=maxPage-1;
		}
		
		if(page>=maxPage) {
			page=0;
		}
		List<Book> bookList=bookService.loadAll(page, displayCount);
		model.addAttribute("bookList", bookList);
		model.addAttribute("page", page);
		model.addAttribute("maxPage", maxPage);
		return "index";
	}
	
	@RequestMapping("/save")
	public String saveView() {
		return "save";
	}
	
	@RequestMapping("/saveHandler")
	public String saveHandler(Book b,HttpSession session) {
		boolean bool=bookService.save(b);
		return bool?"forward:/loadAll?page="+((Integer)(session.getAttribute("maxPage"))-1):"error";
	}
	
	@RequestMapping("/deleteHandler/{bookId}")
	public String delete(@PathVariable("bookId")int bookId,HttpSession session) {
		boolean bool=bookService.delete(bookId);
		return bool?"forward:../loadAll?page="+((Integer)(session.getAttribute("page"))):"error";
	}
	
	@RequestMapping("/loadUpdate/{bookId}")
	public String loadUpdate(@PathVariable("bookId")int bookId,Model model) {
		Book b=bookService.loadBookById(bookId);
		model.addAttribute("book",b);
		return "update";
	}
	
	@RequestMapping("/updateHandler")
	public String update(Book book,HttpSession session) {
		boolean bool=bookService.update(book);
		return bool?"forward:/loadAll?page="+((Integer)(session.getAttribute("page"))):"error";
	}
	
	
//	@RequestMapping("/loadAll")
//	public ModelAndView loadAll(@RequestParam(required=false,defaultValue="0")int page,Model model) {
//		ModelAndView andView=new ModelAndView();
//		int displayCount=10;
//		List<Book> bookList=bookService.loadAll(page, displayCount);
//		andView.setViewName("index");
//		andView.addObject("bookList", bookList);
//		return andView;
//	}
}

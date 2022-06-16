package com.ning.controller;

import com.ning.entity.Books;
import com.ning.service.BookService;
import com.ning.utils.MessageAndData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class NewController {
    @Autowired
    @Qualifier("BookServiceImpl")
    private BookService bookService;

    @RequestMapping(value = "/new",method = RequestMethod.GET)
    public MessageAndData newBook(){
        List<Books> list = bookService.queryAllBook();
        MessageAndData messageAndData = MessageAndData.success();
        messageAndData.add("list",list).setMessage("打印书籍");
        return messageAndData;
    }


}

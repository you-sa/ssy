package top.lz.basedao.dao;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import top.lz.basedao.context.DataContext;
import top.lz.basedao.dao.impl.BookDaoImpl;
import top.lz.basedao.entity.Book;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SuppressWarnings("unchecked")
@Slf4j
class BaseDaoTest {

    private void init() {
        Book book1 = new Book(1L, "1001", "Java从入门到精通", 99.9, LocalDate.of(2021,11,14));
        Book book2 = new Book(2L, "1002", "Java编程思想", 9.9, LocalDate.of(2021,11,15));
        Book book3 = new Book(3L, "1003", "Java并发编程", 99.9, LocalDate.of(2021,11,16));
        List<Book> list = new ArrayList<>(Arrays.asList(book1,book2,book3));
        DataContext.setData(list);
        log.info("**************************初始化**************************");
        printData();
    }

    private void printData() {
        List<Book> books = (List<Book>) DataContext.getData();
        books.forEach(item -> log.info(String.valueOf(item)));
    }

    @Test
    void add() {
        init();
        BookDao<Book> bookDao = new BookDaoImpl();
        Book book = new Book(4L, "1004", "测试书", 66.6, LocalDate.of(2021,11,11));
        bookDao.add(book);
        assertEquals(4, ((List<Book>)DataContext.getData()).size());
        log.info("**************************新增**************************");
        printData();
    }

    @Test
    void delete() {
        init();
        BookDao<Book> bookDao = new BookDaoImpl();
        Book delBook = ((List<Book>) DataContext.getData()).get(2);
        bookDao.delete(delBook);
        assertEquals(2, ((List<Book>)DataContext.getData()).size());
        log.info("**************************删除**************************");
        printData();
    }

    @Test
    void get() {
        init();
        BookDao<Book> bookDao = new BookDaoImpl();
        Book book = bookDao.get(2L);
        assertEquals(book, ((List<Book>)DataContext.getData()).get(1));
        log.info("**************************根据id查询**************************");
        log.info(String.valueOf(book));
    }

    @Test
    void findByField() {
        init();
        BookDao<Book> bookDao = new BookDaoImpl();
        List<Book> books = bookDao.findByField("price", "99.9");
        assertEquals(books.size(), 2);
        log.info("**************************根据字段查询**************************");
        books.forEach(item -> log.info(String.valueOf(item)));
    }

    @Test
    void update() {
        init();
        BookDao<Book> bookDao = new BookDaoImpl();
        Book updateBook = new Book(1L, "1001", "修改后的书名", 88.8, LocalDate.of(2021,11,11));
        bookDao.update(updateBook, 1L);
        assertEquals("修改后的书名", ((List<Book>)DataContext.getData()).get(0).getName());
        assertEquals(88.8, ((List<Book>)DataContext.getData()).get(0).getPrice());
        log.info("**************************修改**************************");
        printData();
    }

    @Test
    void findAll() {
        init();
        BookDao<Book> bookDao = new BookDaoImpl();
        List<Book> books = bookDao.findAll();
        assertEquals(3, books.size());
        log.info("**************************查询所有数据**************************");
        books.forEach(item -> log.info(String.valueOf(item)));
    }
}
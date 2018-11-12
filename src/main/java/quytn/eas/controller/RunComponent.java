package quytn.eas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import quytn.eas.service.BookService;

@Component
public class RunComponent implements CommandLineRunner {

    @Autowired
    private BookService bookService;

    @Override
    public void run(String... args) throws Exception {
        System.out.println(bookService.findAll());
    }
}

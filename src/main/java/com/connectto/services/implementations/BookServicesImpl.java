package com.connectto.services.implementations;

import com.connectto.model.Book;
import com.connectto.repositores.BookRepository;
import com.connectto.services.interfaces.BookServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServicesImpl implements BookServices {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public void save(Book book) {
        bookRepository.save(book);
    }
}

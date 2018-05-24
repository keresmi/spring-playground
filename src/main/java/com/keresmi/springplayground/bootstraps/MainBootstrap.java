package com.keresmi.springplayground.bootstraps;

import com.keresmi.springplayground.models.Author;
import com.keresmi.springplayground.models.Book;
import com.keresmi.springplayground.repositories.AuthorRepository;
import com.keresmi.springplayground.repositories.BookRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * Created by keresmi on 24.05.18.
 */
@Component
public class MainBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    public MainBootstrap(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {

        Book springInAction = new Book("Spring in Action, Fourth Edition", "978-83-283-0849-7", "Helion");
        Author cWalls = new Author("Craig", "Walls");

        springInAction.getAuthors().add(cWalls);
        cWalls.getBooks().add(springInAction);

        authorRepository.save(cWalls);
        bookRepository.save(springInAction);
    }
}

package com.keresmi.springplayground.bootstraps;

import com.keresmi.springplayground.models.Author;
import com.keresmi.springplayground.models.Book;
import com.keresmi.springplayground.models.Publisher;
import com.keresmi.springplayground.repositories.AuthorRepository;
import com.keresmi.springplayground.repositories.BookRepository;
import com.keresmi.springplayground.repositories.PublisherRepository;
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
    private PublisherRepository publisherRepository;

    public MainBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {
        Publisher helion = new Publisher("Helion");
        Publisher albatros = new Publisher("Albatros");

        publisherRepository.save(helion);
        publisherRepository.save(albatros);

        Author cWalls = new Author("Craig", "Walls");
        Book springInAction = new Book("Spring in Action, Fourth Edition",
                "978-83-283-0849-7",
                helion);

        cWalls.getBooks().add(springInAction);
        springInAction.getAuthors().add(cWalls);

        authorRepository.save(cWalls);
        bookRepository.save(springInAction);

        Author nicholasSparks = new Author("Nicholas", "Sparks");
        Book theLastSong = new Book("The Last Song",
                "9788379856800",
                albatros);

        nicholasSparks.getBooks().add(theLastSong);
        theLastSong.getAuthors().add(nicholasSparks);

        authorRepository.save(nicholasSparks);
        bookRepository.save(theLastSong);

        Author stephenKing = new Author("Stephen", "King");
        Book theGreenMile = new Book("The Green Mile",
                "9788380973091",
                albatros);

        stephenKing.getBooks().add(theGreenMile);
        theGreenMile.getAuthors().add(stephenKing);

        authorRepository.save(stephenKing);
        bookRepository.save(theGreenMile);
    }
}

package com.keresmi.springplayground.repositories;

import com.keresmi.springplayground.models.Book;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by keresmi on 24.05.18.
 */
public interface BookRepository extends CrudRepository<Book, Long> {
}

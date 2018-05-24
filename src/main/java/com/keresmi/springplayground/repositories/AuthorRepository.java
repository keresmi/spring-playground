package com.keresmi.springplayground.repositories;

import com.keresmi.springplayground.models.Author;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by keresmi on 24.05.18.
 */
public interface AuthorRepository extends CrudRepository<Author, Long> {
}

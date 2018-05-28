package com.keresmi.springplayground.repositories;

import com.keresmi.springplayground.models.Publisher;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by keresmi on 28.05.18.
 */
public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}

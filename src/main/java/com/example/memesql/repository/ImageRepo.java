package com.example.memesql.repository;

import com.example.memesql.models.Image;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ImageRepo extends CrudRepository<Image, Long> {

    Optional<Image> findByName(String name);

}

package com.example.memesql.repository;

import com.example.memesql.models.Meme;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemeRepo extends CrudRepository<Meme, Long> {
}

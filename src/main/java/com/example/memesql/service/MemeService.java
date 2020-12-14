package com.example.memesql.service;

import com.example.memesql.models.Meme;
import com.example.memesql.repository.MemeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemeService {

    private final MemeRepo memeRepo;

    @Autowired
    public MemeService(MemeRepo memeDao) {
        this.memeRepo = memeDao;
    }

    public Long addMeme(Meme meme) {
        return memeRepo.save(meme).getId();
    }

    public Iterable<Meme> getMemes() {
        return memeRepo.findAll();
    };

}


package com.example.memesql;

import com.example.memesql.models.*;
import com.example.memesql.repository.ImageRepo;
import com.example.memesql.repository.MemeRepo;
import com.example.memesql.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Start {

    private final UserRepo userRepo;
    private final ImageRepo imageRepo;
    private final MemeRepo memeRepo;

    @Autowired
    public Start(UserRepo userRepo, ImageRepo imageRepo, MemeRepo memeRepo) {
        this.userRepo = userRepo;
        this.imageRepo = imageRepo;
        this.memeRepo = memeRepo;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void runExample() {

        Image newImage = new Image((long) 123, "imageName", "url1", "url2", "url3", null);
        imageRepo.save(newImage);
        User newUser = new User((long) 123, "admin", "admin", "admin");
        userRepo.save(newUser);

        Meme newMeme = new Meme((long) 123, "title1", "desc", null, null);

        Optional<User> optionalUser = userRepo.findByUsername("admin");
        Optional<Image> optionalImage = imageRepo.findByName("imageName");

        optionalUser.ifPresent(newMeme::setUser);
        optionalImage.ifPresent(newMeme::setImage);

        memeRepo.save(newMeme);

    }
}

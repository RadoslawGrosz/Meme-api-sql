package com.example.memesql.service;

import com.example.memesql.models.Image;
import com.example.memesql.repository.ImageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageService {

    private final ImageRepo imageRepo;

    @Autowired
    public ImageService(ImageRepo imageRepo) {
        this.imageRepo = imageRepo;
    }

    public Long addImage(Image image) {
        return imageRepo.save(image).getId();
    }

    public Long deleteImage(Long id) {

        try {
            imageRepo.deleteById(id);
            return id;
        } catch (Exception e) {
            System.out.println("error while deleting image");
            return (long) -1;
        }

    }

    public Iterable<Image> getImages() {
        return imageRepo.findAll();
    }

}

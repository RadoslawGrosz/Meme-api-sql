package com.example.memesql.api;

import com.example.memesql.models.Image;
import com.example.memesql.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/image")
@RestController
@CrossOrigin()
public class ImageController {

    private final ImageService imageService;

    @Autowired
    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @PostMapping("/add")
    public Long addImage(@RequestBody Image image) {
        return imageService.addImage(image);
    }

    @GetMapping("/get")
    public Iterable<Image> getImages() {
        return imageService.getImages();
    }
}

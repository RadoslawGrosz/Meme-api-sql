package com.example.memesql.api;

import com.example.memesql.models.Meme;
import com.example.memesql.service.MemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/meme")
@RestController
@CrossOrigin()
public class MemeController {

    private final MemeService memeService;

    @Autowired
    public MemeController(MemeService memeService) {
        this.memeService = memeService;
    }

    @PostMapping("/add")
    public Long addMeme(@RequestBody Meme meme) {
        return memeService.addMeme(meme);
    }

    @PostMapping("/delete/{id}")
    public Long deleteMeme(@PathVariable Long id) {
        return memeService.deleteMeme(id);
    }

    @GetMapping("/get")
    public Iterable<Meme> getMemes() {
        return memeService.getMemes();
    }

}

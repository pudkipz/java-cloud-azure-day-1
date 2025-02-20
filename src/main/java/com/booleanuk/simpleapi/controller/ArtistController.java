package com.booleanuk.simpleapi.controller;

import com.booleanuk.simpleapi.model.Artist;
import com.booleanuk.simpleapi.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/artists")
public class ArtistController {
    @Autowired
    private ArtistRepository artistRepository;

    @GetMapping
    public List<Artist> getAllArtists() {
        return this.artistRepository.findAll();
    }

    @PostMapping
    public Artist createArtist(@RequestBody Artist artist) {
        Artist a = this.artistRepository.save(artist);
        System.out.println(a);
        return a;
    }
}

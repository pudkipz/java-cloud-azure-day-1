package com.booleanuk.simpleapi.controller;

import com.booleanuk.simpleapi.model.Album;
import com.booleanuk.simpleapi.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/albums")
public class AlbumController {
    @Autowired
    private AlbumRepository albumRepository;

    @GetMapping
    public List<Album> getAllAlbums() {
        return this.albumRepository.findAll();
    }

    @GetMapping("/{id}")
    public Album getById(@PathVariable int id) {
        return albumRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Album createAlbum(@RequestBody Album album) {
        return this.albumRepository.save(album);
    }
}

package com.booleanuk.simpleapi.controller;

import com.booleanuk.simpleapi.model.Song;
import com.booleanuk.simpleapi.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/songs")
public class SongController {
    @Autowired
    private SongRepository songRepository;

    @GetMapping
    public List<Song> getAllSongs() {
        return this.songRepository.findAll();
    }

    @PostMapping
    public Song createSong(@RequestBody Song song) {
        return this.songRepository.save(song);
    }
}

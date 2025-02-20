package com.booleanuk.simpleapi.controller;

import com.booleanuk.simpleapi.model.Album;
import com.booleanuk.simpleapi.model.Artist;
import com.booleanuk.simpleapi.model.Song;
import com.booleanuk.simpleapi.repository.AlbumRepository;
import com.booleanuk.simpleapi.repository.ArtistRepository;
import com.booleanuk.simpleapi.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/songs")
public class SongController {
    @Autowired
    private SongRepository songRepository;
    @Autowired
    private ArtistRepository artistRepository;
    @Autowired
    private AlbumRepository albumRepository;

    @GetMapping
    public List<Song> getAllSongs() {
        return this.songRepository.findAll();
    }

    @PostMapping
    public Song createSong(@RequestBody Song song) {
        Artist artist = artistRepository.findById(song.getArtist().getId()).orElse(null);
        Album album = albumRepository.findById(song.getAlbum().getId()).orElse(null);
        if (artist == null || album == null) return null;
        return this.songRepository.save(song);
    }
}

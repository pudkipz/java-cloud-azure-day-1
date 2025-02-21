package com.booleanuk.simpleapi.controller;

import com.booleanuk.simpleapi.model.Playlist;
import com.booleanuk.simpleapi.model.Song;
import com.booleanuk.simpleapi.repository.PlaylistRepository;
import com.booleanuk.simpleapi.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/playlists")
public class PlaylistController {
    @Autowired
    private PlaylistRepository playlistRepository;
//    @Autowired
//    private SongRepository songRepository;

    @GetMapping
    public List<Playlist> getAllPlaylists() {
        return this.playlistRepository.findAll();
    }

    @PostMapping
    public Playlist createPlaylist(@RequestBody Playlist playlist) {
        // TODO: Maybe error handling for existing playlist name
        return this.playlistRepository.save(playlist);
    }

    @PutMapping("/{id}/add")
    public Playlist addSong(@PathVariable int playlistId, @RequestBody Song song) {
        // TODO: Error handling for non-existent song
        Playlist playlist = this.playlistRepository.findById(playlistId).orElse(null);
        if (playlist == null) return null;
        playlist.getSongs().add(song);
        this.playlistRepository.save(playlist);
        return playlist;
    }

    @PutMapping("/{id}/addsongs")
    public Playlist addSongs(@PathVariable(name = "id") int playlistId, @RequestBody List<Song> songs) {
        // TODO: Error handling for non-existent song
        Playlist playlist = this.playlistRepository.findById(playlistId).orElse(null);
        if (playlist == null) return null;
        playlist.getSongs().addAll(songs);
        this.playlistRepository.save(playlist);
        return playlist;
    }

//    @PutMapping("/{id}/remove")
//    public Playlist removeSong(@PathVariable int playlistId, @RequestBody Song song) {
//        Playlist playlist = this.playlistRepository.findById(playlistId).orElse(null);
//        if (playlist == null) return null;
//        if (!playlist.getSongs().contains(song)) return null;
//        playlist.getSongs().removeIf(s -> s.getId() == song.getId());
//        this.playlistRepository.save(playlist);
//        return playlist;
//    }

    @PutMapping("/{id}/remove")
    public Playlist removeSong(@PathVariable(name = "id") int playlistId, @RequestBody List<Integer> songIndices) {
        Playlist playlist = this.playlistRepository.findById(playlistId).orElse(null);
        if (playlist == null) return null;
        for (int i : songIndices) {
            if (i >= playlist.getSongs().size()) {
                return null;
            }
            playlist.getSongs().remove(i);
        }

        this.playlistRepository.save(playlist);
        return playlist;
    }

    @PutMapping("/{id}")
    // Only updates name -- I don't think changing songs list ref is useful.
    public Playlist updatePlaylist(@PathVariable int playlistId, @RequestBody Playlist updatedPlaylist) {
        Playlist playlist = this.playlistRepository.findById(playlistId).orElse(null);
        if (playlist == null) return null;
        playlist.setName(updatedPlaylist.getName());
        this.playlistRepository.save(playlist);
        return playlist;
    }

    @DeleteMapping("/{id}")
    public Playlist deletePlaylist(@PathVariable int playlistId) {
        Playlist playlist = this.playlistRepository.findById(playlistId).orElse(null);
        if (playlist == null) return null;
        this.playlistRepository.delete(playlist);
        return playlist;
    }
}

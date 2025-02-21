package com.booleanuk.simpleapi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "playlists", uniqueConstraints = {@UniqueConstraint(columnNames = "name")})
public class Playlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToMany
    private List<Song> songs;

    public Playlist(int id, String name, List<Song> songs) {
        this.id = id;
        this.name = name;
        this.songs = songs;
    }

    public Playlist(int id) {
        this.id = id;
    }

    public Playlist(String name, List<Song> songs) {
        this.name = name;
        this.songs = songs;
    }

    public Playlist() {
    }
}

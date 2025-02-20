package com.booleanuk.simpleapi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "artists", uniqueConstraints = {@UniqueConstraint(columnNames = "name")})
public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "artist")
    private List<Song> songs;

    @OneToMany(mappedBy = "artist")
    private List<Album> albums;

    public Artist(int id, String name, List<Song> songs, List<Album> albums) {
        this.id = id;
        this.name = name;
        this.songs = songs;
        this.albums = albums;
    }

    public Artist(String name, List<Song> songs, List<Album> albums) {
        this.name = name;
        this.songs = songs;
        this.albums = albums;
    }

    public Artist(String name) {
        this.name = name;
    }

    public Artist(int id) {
        this.id = id;
    }

    public Artist() {
    }
}

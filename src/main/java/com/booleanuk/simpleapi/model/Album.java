package com.booleanuk.simpleapi.model;

import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "albums", uniqueConstraints = {@UniqueConstraint(columnNames = "title")})
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title")
    private String title;

    @OneToMany(mappedBy = "album")
    private List<Song> songs;

    @ManyToOne
//    @JoinColumn(name = "artist_id")
    @JsonIncludeProperties("name")
    private Artist artist;

    public Album(int id, String title, List<Song> songs, Artist artist) {
        this.id = id;
        this.title = title;
        this.songs = songs;
        this.artist = artist;
    }

    public Album(String title, Artist artist) {
        this.title = title;
        this.artist = artist;
    }

    public Album(int id) {
        this.id = id;
    }

    public Album() {
    }
}

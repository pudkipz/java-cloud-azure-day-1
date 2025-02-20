package com.booleanuk.simpleapi.model;

import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "songs")
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title")
    private String title;

    @ManyToOne
    @JoinColumn(name = "album_id")
    @JsonIncludeProperties({"title"})
    private Album album;

    @ManyToOne
    @JoinColumn(name = "artist_id")
    @JsonIncludeProperties("name")
    private Artist artist;

    public Song(String title, Album album) {
        this.title = title;
        this.album = album;
    }

    public Song(int id, String title, Album album) {
        this.id = id;
        this.title = title;
        this.album = album;
    }

}

package com.booleanuk.simpleapi.model;

import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "albums")
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title")
    private String title;

    @OneToMany(mappedBy = "song")
    private List<Song> songs;

    @ManyToOne
    @JoinColumn(name = "artist_id")
    @JsonIncludeProperties("name")
    private Artist artist;

    public Album(int id, String title, List<Song> songs) {
        this.id = id;
        this.title = title;
        this.songs = songs;
    }

    public Album(String title, List<Song> songs) {
        this.title = title;
        this.songs = songs;
    }

}

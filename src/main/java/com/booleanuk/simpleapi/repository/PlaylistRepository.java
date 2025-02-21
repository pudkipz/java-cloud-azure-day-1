package com.booleanuk.simpleapi.repository;

import com.booleanuk.simpleapi.model.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaylistRepository extends JpaRepository<Playlist, Integer> {
}

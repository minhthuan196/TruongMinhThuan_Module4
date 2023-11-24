package com.example.music_web.service;

import com.example.music_web.model.Song;

import java.util.List;

public interface ISongService {
    void saveSong(Song song);

    void updateSong(Song song);

    List<Song> findAllSong();

    Song findById(int id);
}

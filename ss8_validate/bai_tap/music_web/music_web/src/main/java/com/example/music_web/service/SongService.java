package com.example.music_web.service;

import com.example.music_web.model.Song;
import com.example.music_web.repository.ISongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService implements ISongService {
    @Autowired
    private ISongRepository songRepository;

    @Override
    public void saveSong(Song song) {
        songRepository.save(song);
    }

    @Override
    public void updateSong(Song song) {
        if (songRepository.existsById(song.getId())) {
            songRepository.save(song);
        }
    }

    @Override
    public List<Song> findAllSong() {
        return songRepository.findAll();
    }

    @Override
    public Song findById(int id) {
        return songRepository.findById(id).get();
    }
}

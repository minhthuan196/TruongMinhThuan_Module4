package com.example.music_web.controller;

import com.example.music_web.dto.SongDto;
import com.example.music_web.model.Song;
import com.example.music_web.service.ISongService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/song")
public class SongController {
    @Autowired
    private ISongService songService;

    @GetMapping
    public String showSong(Model model) {
        List<Song> songList = songService.findAllSong();
        model.addAttribute("songList", songList);
        return "/songs/list";
    }

    @GetMapping("/create")
    public String showFromCreate(Model model) {
        SongDto songDto = new SongDto();
        model.addAttribute("songDto", songDto);
        return "/songs/create";
    }

    @PostMapping("/save")
    public String save(RedirectAttributes redirectAttributes, @Valid SongDto songDto, BindingResult bindingResult) {
        Song song = new Song();
        new SongDto().validate(songDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return "/songs/create";
        }
        BeanUtils.copyProperties(songDto, song);
        songService.saveSong(song);
        redirectAttributes.addFlashAttribute("mess", "add song success");
        return "redirect:/song";
    }

    @GetMapping("/edit")
    public String showFromEdit(Model model, @RequestParam int id) {
        Song song = songService.findById(id);
        model.addAttribute("song", song);
        return "/songs/edit";
    }

    @PostMapping("/update")
    public String updateProduct(@Valid RedirectAttributes redirectAttributes, Song song, BindingResult bindingResult) {
        SongDto songDto = new SongDto();
        BeanUtils.copyProperties(song, songDto);
        new SongDto().validate(songDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return "/songs/edit";
        }

        songService.updateSong(song);
        redirectAttributes.addFlashAttribute("mess", "update blog success!!!");
        return "redirect:/song";
    }
}

package com.example.music_web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SongDto implements Validator {

    private String name;
    private String singer;
    private String type;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        SongDto songDto = (SongDto) target;
        if ("".equals(songDto.name)) {
            errors.rejectValue("name", null, "Not empty");
        } else if (songDto.name.length() > 800 || songDto.name.length() < 1) {
            errors.rejectValue("name", null, "Name >0 and name <=800");
        } else if (!songDto.name.matches("^[a-zA-Z0-9 ]*$")) {
            errors.rejectValue("name", null, "Name not format");
        } else if ("".equals(songDto.singer)) {
            errors.rejectValue("singer", null, "Not empty");
        } else if (songDto.singer.length() > 300 || songDto.singer.length() < 1) {
            errors.rejectValue("singer", null, "singer >0 and singer <=300");
        } else if (!songDto.singer.matches("^[a-zA-Z0-9 ]*$")) {
            errors.rejectValue("singer", null, "singer not format");
        } else if ("".equals(songDto.type)) {
            errors.rejectValue("type", null, "Not empty");
        } else if (songDto.type.length() > 1000 || songDto.type.length() < 1) {
            errors.rejectValue("type", null, "type >0 and type <=300");
        } else if (!songDto.type.matches("^[^,]*$")) {
            errors.rejectValue("type", null, "type not format");
        }
    }
}

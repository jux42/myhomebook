package com.jux.myhomebook.Controller;

import com.jux.myhomebook.Model.Media;
import com.jux.myhomebook.Model.User;
import com.jux.myhomebook.Service.MediaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class MediaController {

    @Autowired
    private MediaService mediaService;

    @PostMapping("/media")
    public Media createMedia(@RequestBody Media media) {
        return mediaService.saveMedia(media);
    }

    @GetMapping("/media/{id}")
    public Media getMedia(@PathVariable("id") final Long id) {
        Optional<Media> media = mediaService.getMedia(id);
        return media.orElse(null);
    }

    @GetMapping("/medias")
    public Iterable<Media> getMedias() {
        return mediaService.getMedias();
    }


    @PutMapping("/media/{id}")
    public Media updateMedia(@PathVariable("id") Long id, @RequestBody Media media) {
        Optional<Media> m = mediaService.getMedia(id);
        if (m.isPresent()) {
            Media currentMedia = m.get();

            String title = media.getTitle();
            if (title != null) {
                currentMedia.setTitle(title);
            }

            String location = media.getLocation();
            if (location != null) {
                currentMedia.setLocation(location);
            }


            mediaService.saveMedia(currentMedia);
            return currentMedia;
        } else {
            return null;
        }

    }

    @DeleteMapping("/media/{id}")
    public void deleteMedia(@PathVariable("id") Long id){
        mediaService.deleteMedia(id);
    }
}



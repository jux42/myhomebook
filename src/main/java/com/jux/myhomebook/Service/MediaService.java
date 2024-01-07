package com.jux.myhomebook.Service;

import com.jux.myhomebook.Model.Media;
import com.jux.myhomebook.Repository.MediaRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Data
@Service
public class MediaService {

    @Autowired
    private MediaRepository mediaRepository;

    public Iterable<Media> getMedias(){
        return mediaRepository.findAll();
    }

    public Optional<Media> getMedia(final Long id){
        return mediaRepository.findById(id);
    }

    public Media saveMedia (Media media){
        Media savedMedia = mediaRepository.save(media);
        return savedMedia;
    }

    public void deleteMedia(Long id){
        mediaRepository.deleteById(id);
    }
}

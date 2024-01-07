package com.jux.myhomebook.Repository;

import com.jux.myhomebook.Model.Media;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MediaRepository extends CrudRepository<Media, Long> {

}

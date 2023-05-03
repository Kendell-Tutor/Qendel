package com.qendel.authenticationservice.repository;

import com.qendel.authenticationservice.model.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VideoRepository extends JpaRepository<Video, Long> {

    Video findByName(String name);
    boolean existsByName(String name);
    @Query(nativeQuery = true, value="SELECT name FROM video")
    List<String> getAllEntryNames();
    @Query(nativeQuery = true, value = "SELECT * from video v WHERE v.price <=:price")
    List<Video> findAllByPriceIsLessThanOrPriceEquals(int price);

}

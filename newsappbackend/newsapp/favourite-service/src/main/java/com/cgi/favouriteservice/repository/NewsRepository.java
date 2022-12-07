package com.cgi.favouriteservice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cgi.favouriteservice.model.News;

@Repository
public interface NewsRepository extends JpaRepository<News, Integer> {
    List<News> findByUserId(String userId);
	
	Optional<News> findByUserIdAndTitle(String userId, String title);

}

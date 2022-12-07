package com.grpf.adminservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grpf.adminservices.model.News;

public interface NewsRepository extends JpaRepository<News, Integer>{

	
	News findByAuthor(String autor);
}

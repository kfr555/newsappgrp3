package com.cgi.favouriteservice.service;

import java.util.List;

import com.cgi.favouriteservice.exception.NewsAlreadyExistsException;
import com.cgi.favouriteservice.exception.NewsNotFoundException;
import com.cgi.favouriteservice.model.News;

public interface NewsService {
    boolean saveNews(News news) throws NewsAlreadyExistsException;
	
	boolean deleteNewsById(int id) throws NewsNotFoundException;
	
	List<News> getNews(String userId) throws NewsNotFoundException;

}

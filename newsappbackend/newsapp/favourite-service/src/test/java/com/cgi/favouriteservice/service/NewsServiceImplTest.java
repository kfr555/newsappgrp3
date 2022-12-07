package com.cgi.favouriteservice.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.cgi.favouriteservice.exception.NewsAlreadyExistsException;
import com.cgi.favouriteservice.exception.NewsNotFoundException;
import com.cgi.favouriteservice.model.News;
import com.cgi.favouriteservice.repository.NewsRepository;

import java.util.ArrayList;
import java.util.List;

import java.util.Optional;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {NewsServiceImpl.class})
@ExtendWith(SpringExtension.class)
class NewsServiceImplTest {
    @MockBean
    private NewsRepository newsRepository;

    @Autowired
    private NewsServiceImpl newsServiceImpl;

    /**
     * Method under test: {@link NewsServiceImpl#saveNews(News)}
     */
    @Test
    void testSaveNews() throws NewsAlreadyExistsException {
        News news = new News();
        news.setContent("Life is short");
        news.setDescription("The characteristics of someone");
        news.setId(1);
        news.setPublishedAt("Published At");
        news.setSourceWebsiteName("Source Website Name");
        news.setTitle("Mr");
        news.setUrl("https://example.org/example");
        news.setUrlToImage("https://example.org/example");
        news.setUserId("42");

        News news1 = new News();
        news1.setContent("Life is all about Happiness");
        news1.setDescription("The characteristics ofsomething");
        news1.setId(1);
        news1.setPublishedAt("Published At");
        news1.setSourceWebsiteName("Source Website Name");
        news1.setTitle("Ms");
        news1.setUrl("https://example.org/example");
        news1.setUrlToImage("https://example.org/example");
        news1.setUserId("22");
        Optional<News> ofResult = Optional.of(news1);
        when(newsRepository.save((News) any())).thenReturn(news);
        when(newsRepository.findByUserIdAndTitle((String) any(), (String) any())).thenReturn(ofResult);

        News news2 = new News();
        news2.setContent("Chase your dreams");
        news2.setDescription("The characteristics of someone or something");
        news2.setId(1);
        news2.setPublishedAt("Published At");
        news2.setSourceWebsiteName("Source Website Name");
        news2.setTitle("Dr");
        news2.setUrl("https://example.org/example");
        news2.setUrlToImage("https://example.org/example");
        news2.setUserId("44");
        assertThrows(NewsAlreadyExistsException.class, () -> newsServiceImpl.saveNews(news2));
        verify(newsRepository).findByUserIdAndTitle((String) any(), (String) any());
    }

    /**
     * Method under test: {@link NewsServiceImpl#saveNews(News)}
     */
    @Test
    void testSaveNews2() throws NewsAlreadyExistsException {
        News news = new News();
        news.setContent("Love the life you live");
        news.setDescription("The characteristics of someone or something");
        news.setId(1);
        news.setPublishedAt("Published At");
        news.setSourceWebsiteName("Source Website Name");
        news.setTitle("Mrs");
        news.setUrl("https://example.org/example");
        news.setUrlToImage("https://example.org/example");
        news.setUserId("48");
        when(newsRepository.save((News) any())).thenReturn(news);
        when(newsRepository.findByUserIdAndTitle((String) any(), (String) any())).thenReturn(Optional.empty());

        News news1 = new News();
        news1.setContent("Love is life");
        news1.setDescription("The characteristics of someone or something");
        news1.setId(1);
        news1.setPublishedAt("Published At");
        news1.setSourceWebsiteName("Source Website Name");
        news1.setTitle("Ms");
        news1.setUrl("https://example.org/example");
        news1.setUrlToImage("https://example.org/example");
        news1.setUserId("22");
        assertTrue(newsServiceImpl.saveNews(news1));
        verify(newsRepository).save((News) any());
        verify(newsRepository).findByUserIdAndTitle((String) any(), (String) any());
    }

    /**
     * Method under test: {@link NewsServiceImpl#deleteNewsById(int)}
     */
    @Test
    void testDeleteNewsById() throws NewsNotFoundException {
        News news = new News();
        news.setContent("Set Goals");
        news.setDescription("The characteristics of someone or something");
        news.setId(1);
        news.setPublishedAt("Published At");
        news.setSourceWebsiteName("Source Website Name");
        news.setTitle("Dr");
        news.setUrl("https://example.org/example");
        news.setUrlToImage("https://example.org/example");
        news.setUserId("44");
        Optional<News> ofResult = Optional.of(news);
        doNothing().when(newsRepository).delete((News) any());
        when(newsRepository.findById((Integer) any())).thenReturn(ofResult);
        assertTrue(newsServiceImpl.deleteNewsById(1));
        verify(newsRepository).findById((Integer) any());
        verify(newsRepository).delete((News) any());
    }

    /**
     * Method under test: {@link NewsServiceImpl#deleteNewsById(int)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testDeleteNewsById2() throws NewsNotFoundException {
        
        doNothing().when(newsRepository).delete((News) any());
        when(newsRepository.findById((Integer) any())).thenReturn(null);
        newsServiceImpl.deleteNewsById(1);
    }

    /**
     * Method under test: {@link NewsServiceImpl#deleteNewsById(int)}
     */
    @Test
    void testDeleteNewsById3() throws NewsNotFoundException {
        doNothing().when(newsRepository).delete((News) any());
        when(newsRepository.findById((Integer) any())).thenReturn(Optional.empty());
        assertThrows(NewsNotFoundException.class, () -> newsServiceImpl.deleteNewsById(1));
        verify(newsRepository).findById((Integer) any());
    }

    /**
     * Method under test: {@link NewsServiceImpl#getNews(String)}
     */
    @Test
    void testGetNews() throws NewsNotFoundException {
        when(newsRepository.findByUserId((String) any())).thenReturn(new ArrayList<>());
        assertThrows(NewsNotFoundException.class, () -> newsServiceImpl.getNews("42"));
        verify(newsRepository).findByUserId((String) any());
    }

    /**
     * Method under test: {@link NewsServiceImpl#getNews(String)}
     */
    @Test
    void testGetNews2() throws NewsNotFoundException {
        News news = new News();
        news.setContent("Not all who wander are lost");
        news.setDescription("The characteristics of someone or something");
        news.setId(1);
        news.setPublishedAt("News not found!");
        news.setSourceWebsiteName("News not found!");
        news.setTitle("Dr");
        news.setUrl("https://example.org/example");
        news.setUrlToImage("https://example.org/example");
        news.setUserId("42");

        ArrayList<News> newsList = new ArrayList<>();
        newsList.add(news);
        when(newsRepository.findByUserId((String) any())).thenReturn(newsList);
        List<News> actualNews = newsServiceImpl.getNews("42");
        assertSame(newsList, actualNews);
        assertEquals(1, actualNews.size());
        verify(newsRepository).findByUserId((String) any());
    }
}
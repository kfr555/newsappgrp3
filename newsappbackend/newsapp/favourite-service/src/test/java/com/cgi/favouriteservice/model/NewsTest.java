package com.cgi.favouriteservice.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class NewsTest {
   
    @Test
    void testConstructor() {
        News actualNews = new News();
        actualNews.setContent("Not all who wander are lost");
        actualNews.setDescription("The characteristics of someone or something");
        actualNews.setId(1);
        actualNews.setPublishedAt("Published At");
        actualNews.setSourceWebsiteName("Source Website Name");
        actualNews.setTitle("Mr");
        actualNews.setUrl("https://example.org/example");
        actualNews.setUrlToImage("https://example.org/example");
        actualNews.setUserId("42");
        assertEquals("Not all who wander are lost", actualNews.getContent());
        assertEquals("The characteristics of someone or something", actualNews.getDescription());
        assertEquals(1, actualNews.getId());
        assertEquals("Published At", actualNews.getPublishedAt());
        assertEquals("Source Website Name", actualNews.getSourceWebsiteName());
        assertEquals("Mr", actualNews.getTitle());
        assertEquals("https://example.org/example", actualNews.getUrl());
        assertEquals("https://example.org/example", actualNews.getUrlToImage());
        assertEquals("42", actualNews.getUserId());
    }

  
    @Test
    void testConstructor2() {
        News actualNews = new News(1, "42", "Mr", "The characteristics of someone or something",
                "Not all who wander are lost", "Published At", "Source Website Name", "https://example.org/example",
                "https://example.org/example");
        actualNews.setContent("Not all who wander are lost");
        actualNews.setDescription("The characteristics of someone or something");
        actualNews.setId(1);
        actualNews.setPublishedAt("Published At");
        actualNews.setSourceWebsiteName("Source Website Name");
        actualNews.setTitle("Mr");
        actualNews.setUrl("https://example.org/example");
        actualNews.setUrlToImage("https://example.org/example");
        actualNews.setUserId("42");
        assertEquals("Not all who wander are lost", actualNews.getContent());
        assertEquals("The characteristics of someone or something", actualNews.getDescription());
        assertEquals(1, actualNews.getId());
        assertEquals("Published At", actualNews.getPublishedAt());
        assertEquals("Source Website Name", actualNews.getSourceWebsiteName());
        assertEquals("Mr", actualNews.getTitle());
        assertEquals("https://example.org/example", actualNews.getUrl());
        assertEquals("https://example.org/example", actualNews.getUrlToImage());
        assertEquals("42", actualNews.getUserId());
    }
}
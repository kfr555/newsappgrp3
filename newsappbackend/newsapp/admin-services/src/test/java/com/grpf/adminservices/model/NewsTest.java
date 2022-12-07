package com.grpf.adminservices.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class NewsTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link News}
     *   <li>{@link News#setAuthor(String)}
     *   <li>{@link News#setContent(String)}
     *   <li>{@link News#setDescription(String)}
     *   <li>{@link News#setId(int)}
     *   <li>{@link News#setName(String)}
     *   <li>{@link News#setPublishedAt(String)}
     *   <li>{@link News#setTitle(String)}
     *   <li>{@link News#setUrl(String)}
     *   <li>{@link News#setUrlToImage(String)}
     *   <li>{@link News#toString()}
     *   <li>{@link News#getAuthor()}
     *   <li>{@link News#getContent()}
     *   <li>{@link News#getDescription()}
     *   <li>{@link News#getId()}
     *   <li>{@link News#getName()}
     *   <li>{@link News#getPublishedAt()}
     *   <li>{@link News#getTitle()}
     *   <li>{@link News#getUrl()}
     *   <li>{@link News#getUrlToImage()}
     * </ul>
     */
    @Test
    void testConstructor() {
        News actualNews = new News();
        actualNews.setAuthor("JaneDoe");
        actualNews.setContent("Not all who wander are lost");
        actualNews.setDescription("The characteristics of someone or something");
        actualNews.setId(1);
        actualNews.setName("Name");
        actualNews.setPublishedAt("Published At");
        actualNews.setTitle("Dr");
        actualNews.setUrl("https://example.org/example");
        actualNews.setUrlToImage("https://example.org/example");
        String actualToStringResult = actualNews.toString();
        assertEquals("JaneDoe", actualNews.getAuthor());
        assertEquals("Not all who wander are lost", actualNews.getContent());
        assertEquals("The characteristics of someone or something", actualNews.getDescription());
        assertEquals(1, actualNews.getId());
        assertEquals("Name", actualNews.getName());
        assertEquals("Published At", actualNews.getPublishedAt());
        assertEquals("Dr", actualNews.getTitle());
        assertEquals("https://example.org/example", actualNews.getUrl());
        assertEquals("https://example.org/example", actualNews.getUrlToImage());
        assertEquals(
                "News [id=1, author=JaneDoe, title=Dr, description=The characteristics of someone or something, content=Not"
                        + " all who wander are lost, publishedAt=Published At, name=Name, url=https://example.org/example,"
                        + " urlToImage=https://example.org/example]",
                actualToStringResult);
    }
}


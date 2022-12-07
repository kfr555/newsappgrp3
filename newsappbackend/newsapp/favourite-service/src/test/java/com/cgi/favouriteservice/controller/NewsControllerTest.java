package com.cgi.favouriteservice.controller;

import com.cgi.favouriteservice.model.News;
import com.cgi.favouriteservice.service.NewsService;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {NewsController.class})
@ExtendWith(SpringExtension.class)
class NewsControllerTest {
    @Autowired
    private NewsController newsController;

    @MockBean
    private NewsService newsService;

    /**
     * Method under test: {@link NewsController#getToken(HttpServletRequest)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetToken() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "String.substring(int)" because "authHeader" is null
        //       at com.cgi.favouriteservice.controller.NewsController.getToken(NewsController.java:35)
        //   See https://diff.blue/R013 to resolve this issue.

        newsController.getToken(new MockHttpServletRequest());
    }

    /**
     * Method under test: {@link NewsController#getToken(HttpServletRequest)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetToken2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "javax.servlet.http.HttpServletRequest.getHeader(String)" because "request" is null
        //       at com.cgi.favouriteservice.controller.NewsController.getToken(NewsController.java:34)
        //   See https://diff.blue/R013 to resolve this issue.

        newsController.getToken(null);
    }

    /**
     * Method under test: {@link NewsController#deleteNews(int)}
     */
    @Test
    void testDeleteNews() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/{id}", 1);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(newsController).build().perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    /**
     * Method under test: {@link NewsController#getMyFavouriteNews(HttpServletRequest, HttpServletResponse)}
     */
    @Test
    void testGetMyFavouriteNews() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/");
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(newsController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    /**
     * Method under test: {@link NewsController#saveNews(News, HttpServletRequest, HttpServletResponse)}
     */
    @Test
    void testSaveNews() throws Exception {
        News news = new News();
        news.setContent("Not all who wander are lost");
        news.setDescription("The characteristics of someone or something");
        news.setId(1);
        news.setPublishedAt("Published At");
        news.setSourceWebsiteName("Source Website Name");
        news.setTitle("Dr");
        news.setUrl("https://example.org/example");
        news.setUrlToImage("https://example.org/example");
        news.setUserId("42");
        String content = (new ObjectMapper()).writeValueAsString(news);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(newsController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNotFound());
    }
}


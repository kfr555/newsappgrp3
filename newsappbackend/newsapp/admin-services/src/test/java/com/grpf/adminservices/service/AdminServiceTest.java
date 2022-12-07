package com.grpf.adminservices.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.grpf.adminservices.exception.NewsNotFoundException;
import com.grpf.adminservices.exception.UserNameAlreadyExistsException;
import com.grpf.adminservices.model.AdminRegister;
import com.grpf.adminservices.model.News;
import com.grpf.adminservices.repository.AdminRepository;
import com.grpf.adminservices.repository.NewsRepository;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {AdminService.class})
@ExtendWith(SpringExtension.class)
class AdminServiceTest {
    @MockBean
    private AdminRepository adminRepository;

    @Autowired
    private AdminService adminService;

    @MockBean
    private NewsRepository newsRepository;

    /**
     * Method under test: {@link AdminService#registerAdminDetails(AdminRegister)}
     */
    @Test
    void testRegisterAdminDetails() {
        AdminRegister adminRegister = new AdminRegister();
        adminRegister.setAdminId(123);
        adminRegister.setEmailId("42");
        adminRegister.setPassword("iloveyou");
        adminRegister.setUserName("janedoe");
        when(adminRepository.save((AdminRegister) any())).thenReturn(adminRegister);

        AdminRegister adminRegister1 = new AdminRegister();
        adminRegister1.setAdminId(123);
        adminRegister1.setEmailId("42");
        adminRegister1.setPassword("iloveyou");
        adminRegister1.setUserName("janedoe");
        assertSame(adminRegister, adminService.registerAdminDetails(adminRegister1));
        verify(adminRepository).save((AdminRegister) any());
    }

    /**
     * Method under test: {@link AdminService#checkForUserName(AdminRegister)}
     */
    @Test
    void testCheckForUserName() throws UserNameAlreadyExistsException {
        AdminRegister adminRegister = new AdminRegister();
        adminRegister.setAdminId(123);
        adminRegister.setEmailId("42");
        adminRegister.setPassword("iloveyou");
        adminRegister.setUserName("janedoe");
        when(adminRepository.findByUserName((String) any())).thenReturn(adminRegister);

        AdminRegister adminRegister1 = new AdminRegister();
        adminRegister1.setAdminId(123);
        adminRegister1.setEmailId("42");
        adminRegister1.setPassword("iloveyou");
        adminRegister1.setUserName("janedoe");
        assertEquals("User Name Exists", adminService.checkForUserName(adminRegister1));
        verify(adminRepository).findByUserName((String) any());
    }

    /**
     * Method under test: {@link AdminService#checkForEmailId(AdminRegister)}
     */
    @Test
    void testCheckForEmailId() {
        AdminRegister adminRegister = new AdminRegister();
        adminRegister.setAdminId(123);
        adminRegister.setEmailId("42");
        adminRegister.setPassword("iloveyou");
        adminRegister.setUserName("janedoe");
        when(adminRepository.findByEmailId((String) any())).thenReturn(adminRegister);

        AdminRegister adminRegister1 = new AdminRegister();
        adminRegister1.setAdminId(123);
        adminRegister1.setEmailId("42");
        adminRegister1.setPassword("iloveyou");
        adminRegister1.setUserName("janedoe");
        assertEquals("EmailId Exists", adminService.checkForEmailId(adminRegister1));
        verify(adminRepository).findByEmailId((String) any());
    }

    /**
     * Method under test: {@link AdminService#addNews(News)}
     */
    @Test
    void testAddNews() {
        News news = new News();
        news.setAuthor("JaneDoe");
        news.setContent("Not all who wander are lost");
        news.setDescription("The characteristics of someone or something");
        news.setId(1);
        news.setName("Name");
        news.setPublishedAt("Published At");
        news.setTitle("Dr");
        news.setUrl("https://example.org/example");
        news.setUrlToImage("https://example.org/example");
        when(newsRepository.save((News) any())).thenReturn(news);

        News news1 = new News();
        news1.setAuthor("JaneDoe");
        news1.setContent("Not all who wander are lost");
        news1.setDescription("The characteristics of someone or something");
        news1.setId(1);
        news1.setName("Name");
        news1.setPublishedAt("Published At");
        news1.setTitle("Dr");
        news1.setUrl("https://example.org/example");
        news1.setUrlToImage("https://example.org/example");
        assertSame(news, adminService.addNews(news1));
        verify(newsRepository).save((News) any());
    }

    /**
     * Method under test: {@link AdminService#deleteNews(Integer)}
     */
    @Test
    void testDeleteNews() throws NewsNotFoundException {
        News news = new News();
        news.setAuthor("JaneDoe");
        news.setContent("Not all who wander are lost");
        news.setDescription("The characteristics of someone or something");
        news.setId(1);
        news.setName("Name");
        news.setPublishedAt("Published At");
        news.setTitle("Dr");
        news.setUrl("https://example.org/example");
        news.setUrlToImage("https://example.org/example");
        Optional<News> ofResult = Optional.of(news);
        doNothing().when(newsRepository).delete((News) any());
        when(newsRepository.findById((Integer) any())).thenReturn(ofResult);
        assertEquals("News deleted successfully", adminService.deleteNews(1));
        verify(newsRepository).findById((Integer) any());
        verify(newsRepository).delete((News) any());
    }

    /**
     * Method under test: {@link AdminService#deleteNews(Integer)}
     */
    @Test
    void testDeleteNews2() throws NewsNotFoundException {
        doNothing().when(newsRepository).delete((News) any());
        when(newsRepository.findById((Integer) any())).thenReturn(Optional.empty());
        assertEquals("News not Exists", adminService.deleteNews(1));
        verify(newsRepository).findById((Integer) any());
    }
}


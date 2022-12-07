package com.grpf.adminservices.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.grpf.adminservices.model.AdminLogin;
import com.grpf.adminservices.model.AdminRegister;
import com.grpf.adminservices.model.News;
import com.grpf.adminservices.service.AdminService;
import com.grpf.adminservices.util.JwtUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {AdminController.class})
@ExtendWith(SpringExtension.class)
class AdminControllerTest {
    @Autowired
    private AdminController adminController;

    @MockBean
    private AdminService adminService;

    @MockBean
    private AuthenticationManager authenticationManager;

    @MockBean
    private JwtUtil jwtUtil;

    /**
     * Method under test: {@link AdminController#addNews(News)}
     */
    @Test
    void testAddNews() throws Exception {
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
        when(adminService.addNews((News) any())).thenReturn(news);

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
        String content = (new ObjectMapper()).writeValueAsString(news1);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/admin/saveNews")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(adminController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":1,\"author\":\"JaneDoe\",\"title\":\"Dr\",\"description\":\"The characteristics of someone or something\","
                                        + "\"content\":\"Not all who wander are lost\",\"publishedAt\":\"Published At\",\"name\":\"Name\",\"url\":\"https:/"
                                        + "/example.org/example\",\"urlToImage\":\"https://example.org/example\"}"));
    }

    /**
     * Method under test: {@link AdminController#deleteNewsById(Integer)}
     */
    @Test
    void testDeleteNewsById() throws Exception {
        when(adminService.deleteNews((Integer) any())).thenReturn("Delete News");
        MockHttpServletRequestBuilder deleteResult = MockMvcRequestBuilders.delete("/admin/deleteNews");
        MockHttpServletRequestBuilder requestBuilder = deleteResult.param("id", String.valueOf(1));
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(adminController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isAccepted())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("{\"status\":\"Delete News\"}"));
    }

    /**
     * Method under test: {@link AdminController#login(AdminLogin)}
     */
    @Test
    void testLogin() throws Exception {
        when(jwtUtil.generateToken((String) any())).thenReturn("ABC123");
        when(authenticationManager.authenticate((Authentication) any()))
                .thenReturn(new TestingAuthenticationToken("Principal", "Credentials"));

        AdminLogin adminLogin = new AdminLogin();
        adminLogin.setPassword("iloveyou");
        adminLogin.setUserName("janedoe");
        String content = (new ObjectMapper()).writeValueAsString(adminLogin);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/admin/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(adminController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("{\"Jwt token\":\"ABC123\"}"));
    }

    /**
     * Method under test: {@link AdminController#register(AdminRegister)}
     */
    @Test
    void testRegister() throws Exception {
        AdminRegister adminRegister = new AdminRegister();
        adminRegister.setAdminId(123);
        adminRegister.setEmailId("42");
        adminRegister.setPassword("iloveyou");
        adminRegister.setUserName("janedoe");
        when(adminService.registerAdminDetails((AdminRegister) any())).thenReturn(adminRegister);
        when(adminService.checkForEmailId((AdminRegister) any())).thenReturn("42");
        when(adminService.checkForUserName((AdminRegister) any())).thenReturn("janedoe");

        AdminRegister adminRegister1 = new AdminRegister();
        adminRegister1.setAdminId(123);
        adminRegister1.setEmailId("42");
        adminRegister1.setPassword("iloveyou");
        adminRegister1.setUserName("janedoe");
        String content = (new ObjectMapper()).writeValueAsString(adminRegister1);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/admin/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(adminController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(409))
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("{\"Error\":\"User already exists\"}"));
    }

    /**
     * Method under test: {@link AdminController#register(AdminRegister)}
     */
    @Test
    void testRegister2() throws Exception {
        AdminRegister adminRegister = new AdminRegister();
        adminRegister.setAdminId(123);
        adminRegister.setEmailId("42");
        adminRegister.setPassword("iloveyou");
        adminRegister.setUserName("janedoe");
        when(adminService.registerAdminDetails((AdminRegister) any())).thenReturn(adminRegister);
        when(adminService.checkForEmailId((AdminRegister) any())).thenReturn("42");
        when(adminService.checkForUserName((AdminRegister) any())).thenReturn(null);

        AdminRegister adminRegister1 = new AdminRegister();
        adminRegister1.setAdminId(123);
        adminRegister1.setEmailId("42");
        adminRegister1.setPassword("iloveyou");
        adminRegister1.setUserName("janedoe");
        String content = (new ObjectMapper()).writeValueAsString(adminRegister1);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/admin/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(adminController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(409))
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("{\"Error\":\"Email already exists\"}"));
    }

    /**
     * Method under test: {@link AdminController#register(AdminRegister)}
     */
    @Test
    void testRegister3() throws Exception {
        AdminRegister adminRegister = new AdminRegister();
        adminRegister.setAdminId(123);
        adminRegister.setEmailId("42");
        adminRegister.setPassword("iloveyou");
        adminRegister.setUserName("janedoe");
        when(adminService.registerAdminDetails((AdminRegister) any())).thenReturn(adminRegister);
        when(adminService.checkForEmailId((AdminRegister) any())).thenReturn(null);
        when(adminService.checkForUserName((AdminRegister) any())).thenReturn(null);

        AdminRegister adminRegister1 = new AdminRegister();
        adminRegister1.setAdminId(123);
        adminRegister1.setEmailId("42");
        adminRegister1.setPassword("iloveyou");
        adminRegister1.setUserName("janedoe");
        String content = (new ObjectMapper()).writeValueAsString(adminRegister1);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/admin/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(adminController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"adminId\":123,\"userName\":\"janedoe\",\"emailId\":\"42\",\"password\":\"iloveyou\"}"));
    }
}


package com.cgi.favouriteservice.swagger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.servlet.ServletContext;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import springfox.documentation.spring.web.plugins.Docket;

@ContextConfiguration(classes = {SwaggerConfig.class})
@ExtendWith(SpringExtension.class)
class SwaggerConfigTest {
    @MockBean
    private ServletContext servletContext;

    @Autowired
    private SwaggerConfig swaggerConfig;

    /**
     * Method under test: {@link SwaggerConfig#api()}
     */
    @Test
    void testApi() {
       

        Docket actualApiResult = (new SwaggerConfig()).api();
        assertTrue(actualApiResult.isEnabled());
        assertEquals("default", actualApiResult.getGroupName());
    }

    /**
     * Method under test: {@link SwaggerConfig#customImplementation()}
     */
    @Test
    void testCustomImplementation() {
        assertNull(swaggerConfig.customImplementation());
    }
}
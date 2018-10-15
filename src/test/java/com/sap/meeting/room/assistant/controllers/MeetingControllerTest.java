package com.sap.meeting.room.assistant.controllers;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.io.IOException;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sap.meeting.room.assistant.config.WebAppContextConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { WebAppContextConfig.class })
@WebAppConfiguration

public class MeetingControllerTest {

    private static final String AUTHORS = "authors";
    
    @Inject
    WebApplicationContext context;

    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }
    
    @Test
    public void authors() throws Exception {
        mockMvc.perform(buildGetRequest(AUTHORS))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.authors[0]", is("Stefan Misik")))
                .andExpect(jsonPath("$.authors[1]", is("Libor Bucek"))); // requires com.jayway.jsonpath:json-path
    }
    
    private MockHttpServletRequestBuilder buildGetRequest(String uri) throws Exception {
        return get(MeetingController.PATH + "/" + uri);
    }
    
}

package com.jamesdube.notesgradle;

import com.google.gson.Gson;
import com.jamesdube.notesgradle.config.NotesGradleConfig;
import com.jamesdube.notesgradle.controllers.NotesController;
import com.jamesdube.notesgradle.domain.Note;
import com.jamesdube.notesgradle.repositories.NotesRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletContext;

import java.util.Arrays;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { NotesGradleConfig.class })
@WebAppConfiguration
public class IntegrationTests {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private NotesRepository notesRepository;

    private MockMvc mockMvc;

    @Before
    public void setup() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }

    @Test
    public void verifySetup() {
        ServletContext servletContext = webApplicationContext.getServletContext();

        Assert.assertNotNull(servletContext);
        Assert.assertTrue(servletContext instanceof MockServletContext);
        webApplicationContext.getBeanDefinitionNames();
        Assert.assertNotNull(webApplicationContext.getBean(NotesController.class));
    }

    @Test
    public void itCanPostANote()throws Exception{

        Gson gson = new Gson();

        String content = gson.toJson(new Note(2L, "a sample note"));

        this.mockMvc.perform(post("/notes")
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .content(content))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(2))
                .andExpect(jsonPath("$.text").value("a sample note"));

    }

    @Test
    public void itCanGetAllNotes() throws Exception{

        notesRepository.saveAll(Arrays
                .asList(new Note(1L,"neverland show cancelled"),new Note(2L,"Michael is a douche")));
        Assert.assertEquals(2,notesRepository.findAll().size());

        this.mockMvc.perform(get("/notes")
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[?(@.text==\"neverland show cancelled\")]").exists())
                .andExpect(jsonPath("$[?(@.text==\"Michael is a douche\")]").exists());

    }

    @Test
    public void itCanSearchNotes() throws Exception{

        notesRepository.saveAll(Arrays
                .asList(new Note(1L,"neverland show cancelled"),new Note(2L,"Michael is a douche"),
                        new Note(3L,"foo"),new Note(4L,"foo")));
        Assert.assertEquals(4,notesRepository.findAll().size());

        this.mockMvc.perform(get("/notes?text=foo")
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[?(@.text==\"foo\")]").exists());

    }
}

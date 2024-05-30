package com.example.demo.BHYT.Quan;

import com.example.demo.BHYT.Quan.Quan;
import com.example.demo.BHYT.Quan.QuanRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import static org.junit.Assert.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Nevir2002
 */

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class QuanRepositoryTest {
    @Autowired
    private TestEntityManager testEntityManager;
    @Autowired
    private QuanRepository repo;
    
    @BeforeEach
    public void setUp(){
        Quan x = new Quan();
        x.setId(1);
        x.setIdBHYT("Q001");
        testEntityManager.persist(x);
    }
    @Test
    public void testFindByIdBHYT() {
        List<Quan> entities = repo.findByIdBHYT("Q001");
        assertEquals(1, entities.size());
    }
    @Test
    public void testFindByIdBHYT_FAIL() {
        List<Quan> entities = repo.findByIdBHYT("Q002");
        assertEquals(0, entities.size());
    }
}

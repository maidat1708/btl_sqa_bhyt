package com.example.demo.BHYT.Phuong;

import com.example.demo.BHYT.Phuong.Phuong;
import com.example.demo.BHYT.Phuong.PhuongRepository;
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
public class PhuongRepositoryTest {
    @Autowired
    private TestEntityManager testEntityManager;
    @Autowired
    private PhuongRepository repo;
    
    @BeforeEach
    public void setUp(){
        Phuong x = new Phuong();
        x.setId(1);
        x.setIdBHYT("P001");
        x.setIdBHYTQuan("Q001");
        testEntityManager.persist(x);
    }
    @Test
    public void testFindByIdBHYT() {
        List<Phuong> entities = repo.findByIdBHYT("P001");
        assertEquals(1, entities.size());
    }
    @Test
    public void testFindByIdBHYTQuan() {
        List<Phuong> entities = repo.findByIdBHYTQuan("Q001");
        assertEquals(1, entities.size());
    }
    @Test
    public void testFindByIdBHYT_FAIL() {
        List<Phuong> entities = repo.findByIdBHYT("P002");
        assertEquals(0, entities.size());
    }
    @Test
    public void testFindByIdBHYTQuan_FAIL() {
        List<Phuong> entities = repo.findByIdBHYTQuan("Q002");
        assertEquals(0, entities.size());
    }
}

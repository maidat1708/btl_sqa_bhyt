package com.example.demo.BHYT.TruongHoc;

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
public class TruongHocRepositoryTest {
    @Autowired
    private TestEntityManager testEntityManager;
    @Autowired
    private TruongHocRepository repo;
    
    @BeforeEach
    public void setUp(){
        TruongHoc x = new TruongHoc();
        x.setId(1);
        x.setTen("Name");
        x.setIdBHYT("T001");
        x.setIdBHYTPhuong("P001");
        testEntityManager.persist(x);
    }
    @Test
    public void testFindByTen() {
        TruongHoc entity = repo.findByTen("Name");
        assertNotNull(entity);
    }
    @Test
    public void testFindByIdBHYT() {
        List<TruongHoc> entities = repo.findByIdBHYT("T001");
        assertEquals(1, entities.size());
    }
    @Test
    public void testFindByIdBHYTPhuong() {
        List<TruongHoc> entities = repo.findByIdBHYTPhuong("P001");
        assertEquals(1, entities.size());
    }
    @Test
    public void testFindByTen_FAIL() {
        TruongHoc entity = repo.findByTen("Name2");
        assertNull(entity);
    }
    @Test
    public void testFindByIdBHYT_FAIL() {
        List<TruongHoc> entities = repo.findByIdBHYT("T002");
        assertEquals(0, entities.size());
    }
    @Test
    public void testFindByIdBHYTPhuong_FAIL() {
        List<TruongHoc> entities = repo.findByIdBHYTPhuong("P002");
        assertEquals(0, entities.size());
    }
}

package com.example.demo.BHYT.HoGiaDinh;

import com.example.demo.BHYT.HoGiaDinh.HoGiaDinh;
import com.example.demo.BHYT.HoGiaDinh.HoGiaDinhRepository;
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
public class HoGiaDinhRepositoryTest {
    @Autowired
    private TestEntityManager testEntityManager;
    @Autowired
    private HoGiaDinhRepository repo;
    
    @BeforeEach
    public void setUp(){
        HoGiaDinh x = new HoGiaDinh();
        x.setId(1);
        x.setTen("Name");
        x.setIdBHYT("CN001");
        x.setIdBHYTPhuong("P001");
        testEntityManager.persist(x);
    }
    @Test
    public void testFindByTen() {
        HoGiaDinh entity = repo.findByTen("Name");
        assertNotNull(entity);
    }
    @Test
    public void testFindByIdBHYT() {
        List<HoGiaDinh> entities = repo.findByIdBHYT("CN001");
        assertEquals(1, entities.size());
    }
    @Test
    public void testFindByIdBHYTPhuong() {
        List<HoGiaDinh> entities = repo.findByIdBHYTPhuong("P001");
        assertEquals(1, entities.size());
    }
    @Test
    public void testFindByTen_FAIL() {
        HoGiaDinh entity = repo.findByTen("Name2");
        assertNull(entity);
    }
    @Test
    public void testFindByIdBHYT_FAIL() {
        List<HoGiaDinh> entities = repo.findByIdBHYT("CN002");
        assertEquals(0, entities.size());
    }
    @Test
    public void testFindByIdBHYTPhuong_FAIL() {
        List<HoGiaDinh> entities = repo.findByIdBHYTPhuong("P002");
        assertEquals(0, entities.size());
    }
}

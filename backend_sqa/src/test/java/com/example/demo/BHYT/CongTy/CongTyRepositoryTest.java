package com.example.demo.BHYT.CongTy;

import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import static org.junit.Assert.assertEquals;
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
public class CongTyRepositoryTest {
    @Autowired
    private TestEntityManager testEntityManager;
    @Autowired
    private CongTyRepository repo;
//    @Test
//    public void testGetAllCongTy() throws JsonProcessingException {
//        // data
//        // call and assert
//        String id = "CT024";
//        System.out.println(congTyRepository.findByIdBHYTPhuong(id));
//        assertEquals("CT", congTyRepository.findByIdBHYTPhuong(id));
////        assertEquals(1, 1);
//    }
    @BeforeEach
    public void setUp(){
        CongTy x = new CongTy();
        x.setId(1);
        x.setIdBHYT("CN001");
        x.setIdBHYTPhuong("P001");
        testEntityManager.persist(x);
    }
//    @Test
//    public void testFindAll() {
//        List<CongTy> entities = congTyRepository.findAll();
//        System.out.println(entities.size());
//        assertEquals(1, entities.size());
//    }
//    @Test
//    public void testFindAll2() {
////        CongTy x = new CongTy(1);
////        testEntityManager.persist(x);
//        List<CongTy> entities = congTyRepository.findAll();
//        System.out.println(entities.size());
//        assertEquals(1, entities.size());
//    }
    @Test
    public void testFindByIdBHYT() {
        List<CongTy> entities = repo.findByIdBHYT("CN001");
        assertEquals(1, entities.size());
    }
    @Test
    public void testFindByIdBHYTPhuong() {
        List<CongTy> entities = repo.findByIdBHYTPhuong("P001");
        assertEquals(1, entities.size());
    }
    @Test
    public void testFindByIdBHYT_FAIL() {
        List<CongTy> entities = repo.findByIdBHYT("CN002");
        assertEquals(0, entities.size());
    }
    @Test
    public void testFindByIdBHYTPhuong_FAIL() {
        List<CongTy> entities = repo.findByIdBHYTPhuong("P002");
        assertEquals(0, entities.size());
    }
}

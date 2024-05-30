package com.example.demo.BHYT.CaNhan;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.BHYT.CongTy.CongTy;



@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class CaNhanRepositoryTest {
    @Autowired
    private TestEntityManager testEntityManager;
    @Autowired
    private CaNhanRepository repo;
    
    @BeforeEach
    public void setUp(){
        CaNhan caNhan = new CaNhan(2,"CN002");
        testEntityManager.persist(caNhan);
    }

    @Test
    public void testGetAllCaNhan(){
        List<CaNhan> listCaNhan = repo.findAll();
        assertEquals(1,listCaNhan.size());
    }

    @Test
    public void testFindByIdBHYT(){
        List<CaNhan> listCaNhan = repo.findByIdBHYT("CN001");
        assertEquals(1, listCaNhan.size());
    }

}

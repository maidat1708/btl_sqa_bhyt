package com.example.demo.BHYT.CaNhan;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.data.domain.Example;
import org.springframework.test.context.junit4.SpringRunner;

import jakarta.inject.Inject;


@DataJpaTest
@ExtendWith(MockitoExtension.class)
public class CaNhanServiceTest {

    @Mock
    private CaNhanRepository repository;

    @InjectMocks
    private CaNhanService service;
    private List<CaNhan> listCaNhan = new ArrayList<>();


    @Test
    public void testGetAllCaNhan(){
        CaNhan caNhan = new CaNhan(2,"CN002");
        // when(repository.save(Mockito.any(CaNhan.class))).thenReturn(caNhan);
        listCaNhan.add(caNhan);
        when(repository.findAll()).thenReturn(listCaNhan);
        assertEquals(1,service.findAllCaNhan().size());
    }

    @Test
    public void testAddCaNhan(){
        CaNhan caNhan = new CaNhan(2,"CN002");
        when(repository.save(caNhan)).thenReturn(caNhan);
        assertEquals(caNhan.getIdBHYT(), service.addCaNhan(caNhan).getIdBHYT());
    }

    @Test
    public void testGetCaNhanByIdBHYT(){
        CaNhan caNhan2 = new CaNhan(2,"CN002");
        CaNhan caNhan1 = new CaNhan(1,"CN001");
        listCaNhan.add(caNhan1);
        listCaNhan.add(caNhan2);
        List<CaNhan> listCaNhanByIdBHYT = new ArrayList<>();
        listCaNhanByIdBHYT.add(caNhan1);
        String idBHYT = caNhan1.getIdBHYT();
        when(repository.findByIdBHYT(idBHYT)).thenReturn(listCaNhanByIdBHYT);
        assertEquals(1, service.findCaNhanByID(idBHYT).size()); 
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.BHYT.CaNhan;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 *
 * @author Admin
 */
@Service
public class CaNhanService {

    @Autowired
    private CaNhanRepository repo;

    public List<CaNhan> findAllCaNhan(){
        System.out.println("running findAllCaNhan");
        return repo.findAll();
    }
    public CaNhan addCaNhan(CaNhan p){
        System.out.println("running addCaNhan");
        return repo.save(p);
    }
    public List<CaNhan> findCaNhanByID(String id){
        System.out.println("running findCaNhanByID " + id);
        if(id == null) return null;
        return repo.findByIdBHYT(id);
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.BHYT.MienGiam;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class MienGiamService {
    @Autowired
    private MienGiamRepository repo;

    public List<MienGiam> findAllMienGiam(){
        System.out.println("running findAllMienGiam");
        return repo.findAll();
    }
    public void addMienGiam(MienGiam p){
        System.out.println("running addMienGiam");
        repo.save(p);
    }
    public MienGiam findByID(int id){
        System.out.println("running findByID");
        return repo.findById(id).get();
    }
}

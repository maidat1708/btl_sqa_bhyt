/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.BHYT.CauHinh;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class CauHinhService {
    @Autowired
    private CauHinhRepository repo;

    public List<CauHinh> findAllCauHinh(){
        System.out.println("running findAllCauHinh");
        return repo.findAll();
    }
    public CauHinh getLastCauHinh(){
        System.out.println("running getLastCauHinh");
        List<CauHinh> lst = repo.findAll();
        return lst.get(lst.size()-1);
    }
    public void updateCauHinh(CauHinh p){
        System.out.println("running updateCauHinh");
        repo.save(p);
    }
    public void changeCauHinh(CauHinh p){
        System.out.println("running changeCauHinh");
        repo.deleteAll();
        repo.save(p);
    }
}

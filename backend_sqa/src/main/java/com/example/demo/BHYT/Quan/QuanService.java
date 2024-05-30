/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.BHYT.Quan;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class QuanService {
    @Autowired
    private QuanRepository repo;

    public List<Quan> findAllQuan(){
        System.out.println("running findAllQuan");
        return repo.findAll();
    }

    public void addQuan(Quan q){
        System.out.println("running addQuan");
        repo.save(q);
    }
    public List<Quan> findQuanByIdBHYT(String id){
        System.out.println("running findQuanByIdBHYT " + id);
        if(id == null) return null;
        return repo.findByIdBHYT(id);
    }
    public Quan findLastByIdBHYT(String id) {
        System.out.println("running findLastByIdBHYT " + id);
        if(id == null) return null;
        List<Quan> lst = repo.findByIdBHYT(id);
        return lst.get(lst.size()-1);
    }
//    public List<String> findPhuongTrongQuan(String idQuan){
//        return repo.findByTen(idQuan).getListPhuong();
//    }
}

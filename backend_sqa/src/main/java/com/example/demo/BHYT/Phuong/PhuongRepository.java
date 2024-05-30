/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.BHYT.Phuong;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Admin
 */
@Repository
public interface PhuongRepository extends JpaRepository<Phuong, Integer>{
    List<Phuong> findByIdBHYT(String idbhyt);
    List<Phuong> findByIdBHYTQuan(String idbhytquan);
}
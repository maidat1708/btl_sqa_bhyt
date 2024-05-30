/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.BHYT.TruongHoc;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Admin
 */
@Repository
public interface TruongHocRepository extends JpaRepository<TruongHoc, Integer>{
    TruongHoc findByTen(String ten);
    List<TruongHoc> findByIdBHYT(String id);
    List<TruongHoc> findByIdBHYTPhuong(String idbhytphuong);
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.BHYT.HoGiaDinh;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Admin
 */
@Repository
public interface HoGiaDinhRepository extends JpaRepository<HoGiaDinh, Integer>{
    HoGiaDinh findByTen(String ten);
    List<HoGiaDinh> findByIdBHYT(String id);
    List<HoGiaDinh> findByIdBHYTPhuong(String id);
//    List<String> findAllTenDistinctByIdBHYTPhuong(String idbhytphuong);
//    List<String> findDistinctTenByIdBHYTPhuong(String idbhytphuong);
}
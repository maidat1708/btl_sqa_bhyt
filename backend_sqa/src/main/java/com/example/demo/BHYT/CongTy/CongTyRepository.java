/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.BHYT.CongTy;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Admin
 */
@Repository
public interface CongTyRepository extends JpaRepository<CongTy, Integer>{
    List<CongTy> findByIdBHYTPhuong(String idbhytphuong);
    List<CongTy> findByIdBHYT(String id);

//    List<CongTy> findDistinctByTen();
//    List<String> findTenDistinctByTen();
//    List<String> findIdBHYTPhuongDistinctByTen();
//    List<String> findDistinctTenByIdBHYTPhuong(String idbhytphuong);
}
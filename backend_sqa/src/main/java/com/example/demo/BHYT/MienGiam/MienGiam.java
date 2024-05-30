package com.example.demo.BHYT.MienGiam;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "miengiam")
public class MienGiam {
    @Id
    private Integer idmiengiam;
    private Double phanTramMienGiam;
    private String loaiMienGiam;

    public MienGiam() {
    }

    public MienGiam(Integer idmiengiam, Double phanTramMienGiam, String loaiMienGiam) {
        this.idmiengiam = idmiengiam;
        this.phanTramMienGiam = phanTramMienGiam;
        this.loaiMienGiam = loaiMienGiam;
    }

    public Integer getIdmiengiam() {
        return idmiengiam;
    }

    public void setIdmiengiam(Integer idmiengiam) {
        this.idmiengiam = idmiengiam;
    }

    public Double getPhanTramMienGiam() {
        return phanTramMienGiam;
    }

    public void setPhanTramMienGiam(Double phanTramMienGiam) {
        this.phanTramMienGiam = phanTramMienGiam;
    }

    public String getLoaiMienGiam() {
        return loaiMienGiam;
    }

    public void setLoaiMienGiam(String loaiMienGiam) {
        this.loaiMienGiam = loaiMienGiam;
    }




}

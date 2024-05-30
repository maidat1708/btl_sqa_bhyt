package com.example.demo.BHYT.CauHinh;

import java.util.Date;

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
@Table(name = "cauhinh")
public class CauHinh {
    @Id
    private int id;
    private Double luongCoBan;
    private Float tiLeHS;
    private Float tiLePhaiDongHS;
    private Float tiLeCT;
    private Float tiLeCN;
    private Float tiLeTV1;
    private Float tiLeTV2;
    private Float tiLeTV3;
    private Float tiLeTV4;
    private Float tiLeTV5;
    private Date ngayHieuLuc;

    public CauHinh() {
    }

    public CauHinh(int id, Double luongCoBan, Float tiLeHS, Float tiLePhaiDongHS, Float tiLeCT, Float tiLeCN,
            Float tiLeTV1, Float tiLeTV2, Float tiLeTV3, Float tiLeTV4, Float tiLeTV5, Date ngayHieuLuc) {
        this.id = id;
        this.luongCoBan = luongCoBan;
        this.tiLeHS = tiLeHS;
        this.tiLePhaiDongHS = tiLePhaiDongHS;
        this.tiLeCT = tiLeCT;
        this.tiLeCN = tiLeCN;
        this.tiLeTV1 = tiLeTV1;
        this.tiLeTV2 = tiLeTV2;
        this.tiLeTV3 = tiLeTV3;
        this.tiLeTV4 = tiLeTV4;
        this.tiLeTV5 = tiLeTV5;
        this.ngayHieuLuc = ngayHieuLuc;
    }

    public Double getLuongCoBan() {
        return luongCoBan;
    }

    public void setLuongCoBan(Double luongCoBan) {
        this.luongCoBan = luongCoBan;
    }

    public Float getTiLeHS() {
        return tiLeHS;
    }

    public void setTiLeHS(Float tiLeHS) {
        this.tiLeHS = tiLeHS;
    }

    public Float getTiLePhaiDongHS() {
        return tiLePhaiDongHS;
    }

    public void setTiLePhaiDongHS(Float tiLePhaiDongHS) {
        this.tiLePhaiDongHS = tiLePhaiDongHS;
    }

    public Float getTiLeCT() {
        return tiLeCT;
    }

    public void setTiLeCT(Float tiLeCT) {
        this.tiLeCT = tiLeCT;
    }

    public Float getTiLeCN() {
        return tiLeCN;
    }

    public void setTiLeCN(Float tiLeCN) {
        this.tiLeCN = tiLeCN;
    }

    public Float getTiLeTV1() {
        return tiLeTV1;
    }

    public void setTiLeTV1(Float tiLeTV1) {
        this.tiLeTV1 = tiLeTV1;
    }

    public Float getTiLeTV2() {
        return tiLeTV2;
    }

    public void setTiLeTV2(Float tiLeTV2) {
        this.tiLeTV2 = tiLeTV2;
    }

    public Float getTiLeTV3() {
        return tiLeTV3;
    }

    public void setTiLeTV3(Float tiLeTV3) {
        this.tiLeTV3 = tiLeTV3;
    }

    public Float getTiLeTV4() {
        return tiLeTV4;
    }

    public void setTiLeTV4(Float tiLeTV4) {
        this.tiLeTV4 = tiLeTV4;
    }

    public Float getTiLeTV5() {
        return tiLeTV5;
    }

    public void setTiLeTV5(Float tiLeTV5) {
        this.tiLeTV5 = tiLeTV5;
    }

    public Date getNgayHieuLuc() {
        return ngayHieuLuc;
    }

    public void setNgayHieuLuc(Date ngayHieuLuc) {
        this.ngayHieuLuc = ngayHieuLuc;
    }



    public int getId() {
        return id;
    }



    public void setId(int id) {
        this.id = id;
    }



}

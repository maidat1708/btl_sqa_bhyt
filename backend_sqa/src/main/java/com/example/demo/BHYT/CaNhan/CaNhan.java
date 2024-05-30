package com.example.demo.BHYT.CaNhan;

import java.sql.Date;

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
@Table(name = "canhan")
public class CaNhan {
    @Id
    private Integer id;
    private String idBHYT;
    private String ten;
    private String diaChi;
    private String ngaySinh;
    private Integer gioiTinh;
    private Double luong;
    private Double mucDong;
    private Double daDong;
    private Double conNo;
    private Integer dienMienGiam;
    private Date tuNgay;
    private Date denNgay;
    private Integer dongTheo;
    private String noiDki;
    private String idMucTren;
//    private List<> listCaNhan;

    public CaNhan() {
    }
    public CaNhan(Integer id, String idBHYT) {
        this.id = id;
        this.idBHYT = idBHYT;
        this.ten = "";
        this.diaChi = "";
        this.ngaySinh = "ngaySinh";
        this.gioiTinh = 0;
        this.luong = 0.0;
        this.mucDong = 0.0;
        this.daDong = 0.0;
        this.conNo = 0.0;
        this.dienMienGiam = 0;
        this.tuNgay = Date.valueOf("2024-01-01");
        this.denNgay = Date.valueOf("2025-01-01");
        this.dongTheo = 2;
        this.idMucTren = "";
        this.noiDki = "";
    }
    public CaNhan(Integer id, String idBHYT, String ten, String diaChi, String ngaySinh, Integer gioiTinh, Double luong, Double mucDong, Double daDong, Double conNo, Integer dienMienGiam, Date tuNgay, Date denNgay, Integer dongTheo, String idMucTren, String noiDki) {
        this.id = id;
        this.idBHYT = idBHYT;
        this.ten = ten;
        this.diaChi = diaChi;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.luong = luong;
        this.mucDong = mucDong;
        this.daDong = daDong;
        this.conNo = conNo;
        this.dienMienGiam = dienMienGiam;
        this.tuNgay = tuNgay;
        this.denNgay = denNgay;
        this.dongTheo = dongTheo;
        this.idMucTren = idMucTren;
        this.noiDki = noiDki;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIdBHYT() {
        return idBHYT;
    }

    public void setIdBHYT(String idBHYT) {
        this.idBHYT = idBHYT;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public Integer getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(Integer gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public Double getLuong() {
        return luong;
    }

    public void setLuong(Double luong) {
        this.luong = luong;
    }

    public Double getMucDong() {
        return mucDong;
    }

    public void setMucDong(Double mucDong) {
        this.mucDong = mucDong;
    }

    public Double getDaDong() {
        return daDong;
    }

    public void setDaDong(Double daDong) {
        this.daDong = daDong;
    }

    public Double getConNo() {
        return conNo;
    }

    public void setConNo(Double conNo) {
        this.conNo = conNo;
    }

    public Integer getDienMienGiam() {
        return dienMienGiam;
    }

    public void setDienMienGiam(Integer dienMienGiam) {
        this.dienMienGiam = dienMienGiam;
    }

    public Date getTuNgay() {
        return tuNgay;
    }

    public void setTuNgay(Date tuNgay) {
        this.tuNgay = tuNgay;
    }

    public Date getDenNgay() {
        return denNgay;
    }

    public void setDenNgay(Date denNgay) {
        this.denNgay = denNgay;
    }

    public Integer getDongTheo() {
        return dongTheo;
    }

    public void setDongTheo(Integer dongTheo) {
        this.dongTheo = dongTheo;
    }

    public String getIdMucTren() {
        return idMucTren;
    }

    public void setIdMucTren(String idMucTren) {
        this.idMucTren = idMucTren;
    }

    public String getNoiDki() {
        return noiDki;
    }

    public void setNoiDki(String noiDki) {
        this.noiDki = noiDki;
    }




}

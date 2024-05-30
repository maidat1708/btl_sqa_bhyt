package com.example.demo.BHYT.TruongHoc;

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
@Table(name = "truonghoc")
public class TruongHoc {
    @Id
    private Integer id;
    private String idBHYT;
    private String ten;
    private String diaChi;
    private Double mucDong;
    private Double daDong;
    private Double conNo;
    private Integer soLuong;
    private Date tuNgay;
    private Date denNgay;
    private Integer dongTheo;
    private String idBHYTPhuong;
    private String listCaNhan;

    public TruongHoc() {
    }

    public TruongHoc(Integer id, String idBHYT, String ten, String diaChi, Double mucDong, Double daDong, Double conNo, Integer soLuong, Date tuNgay, Date denNgay, Integer dongTheo, String idBHYTPhuong, String listCaNhan) {
        this.id = id;
        this.idBHYT = idBHYT;
        this.ten = ten;
        this.diaChi = diaChi;
        this.mucDong = mucDong;
        this.daDong = daDong;
        this.conNo = conNo;
        this.soLuong = soLuong;
        this.tuNgay = tuNgay;
        this.denNgay = denNgay;
        this.dongTheo = dongTheo;
        this.idBHYTPhuong = idBHYTPhuong;
        this.listCaNhan = listCaNhan;
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

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
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

    public String getIdBHYTPhuong() {
        return idBHYTPhuong;
    }

    public void setIdBHYTPhuong(String idBHYTPhuong) {
        this.idBHYTPhuong = idBHYTPhuong;
    }

    public String getListCaNhan() {
        return listCaNhan;
    }

    public void setListCaNhan(String listCaNhan) {
        this.listCaNhan = listCaNhan;
    }




}

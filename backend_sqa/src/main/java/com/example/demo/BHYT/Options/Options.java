package com.example.demo.BHYT.Options;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Admin
 */
@Entity
public class Options {
    @Id
    private String quan;
    private String phuong;
    private boolean truongHoc;
    private boolean congTy;
    private boolean hoGiaDinh;

    public Options() {
    }

    public Options(String quan, String phuong, boolean truongHoc, boolean congTy, boolean hoGiaDinh) {
        this.quan = quan;
        this.phuong = phuong;
        this.truongHoc = truongHoc;
        this.congTy = congTy;
        this.hoGiaDinh = hoGiaDinh;
    }



    @Override
    public String toString(){
        return String.format("Quan %s,Phuong %s, Truong hoc %b, Cong Ty %b, Ho Gia Dinh %b",this.quan,this.phuong,this.truongHoc,this.congTy,this.hoGiaDinh);
    }

    public String getQuan() {
        return quan;
    }

    public void setQuan(String quan) {
        this.quan = quan;
    }

    public String getPhuong() {
        return phuong;
    }

    public void setPhuong(String phuong) {
        this.phuong = phuong;
    }

    public boolean isTruongHoc() {
        return truongHoc;
    }

    public void setTruongHoc(boolean truongHoc) {
        this.truongHoc = truongHoc;
    }

    public boolean isCongTy() {
        return congTy;
    }

    public void setCongTy(boolean congTy) {
        this.congTy = congTy;
    }

    public boolean isHoGiaDinh() {
        return hoGiaDinh;
    }

    public void setHoGiaDinh(boolean hoGiaDinh) {
        this.hoGiaDinh = hoGiaDinh;
    }


}

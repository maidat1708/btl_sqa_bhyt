/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.BHYT.CauHinh;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.BHYT.CaNhan.CaNhan;
import com.example.demo.BHYT.CaNhan.CaNhanService;
import com.example.demo.BHYT.CongTy.CongTy;
import com.example.demo.BHYT.CongTy.CongTyService;
import com.example.demo.BHYT.HoGiaDinh.HoGiaDinh;
import com.example.demo.BHYT.HoGiaDinh.HoGiaDinhService;
import com.example.demo.BHYT.Phuong.Phuong;
import com.example.demo.BHYT.Phuong.PhuongService;
import com.example.demo.BHYT.Quan.Quan;
import com.example.demo.BHYT.Quan.QuanService;
import com.example.demo.BHYT.TruongHoc.TruongHoc;
import com.example.demo.BHYT.TruongHoc.TruongHocService;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

/**
 *
 * @author Admin
 */
@CrossOrigin
@Controller
public class CauHinhController {

    @Autowired
    private CauHinhService service;
    @Autowired
    private QuanService quanService;
    @Autowired
    private PhuongService phuongService;
    @Autowired
    private CongTyService congTyService;
    @Autowired
    private TruongHocService truongHocService;
    @Autowired
    private HoGiaDinhService hoGiaDinhService;
    @Autowired
    private CaNhanService caNhanService;

    @ResponseBody
    @GetMapping("/getallcauhinh")
    public String getAllCauHinh() throws JsonProcessingException {
        return ListToJSON(service.findAllCauHinh());
    }

    @ResponseBody
    @GetMapping("/getcauhinh")
    public String getCauHinh() throws JsonProcessingException {
        return ListToJSON(service.getLastCauHinh());
    }

    @ResponseBody
    @PostMapping("/updatecauhinh")
    public String updateCauHinh(@RequestBody String s) throws JsonProcessingException {
        CauHinh obj;
        try {
            obj = new ObjectMapper().readValue(s, CauHinh.class);
        } catch (Error e) {
            return "Invalid json";
        }
        // CauHinh successfully initialized
        service.updateCauHinh(obj);
        return "";
        // String updateStatus = testUpdate(s);
        // return ("success " + updateStatus);
    }

    @ResponseBody
    @PostMapping("/testupdate")
    public String testUpdate(@RequestBody String s) throws JsonProcessingException {
        CauHinh obj;
        try {
            obj = new ObjectMapper().readValue(s, CauHinh.class);
        } catch (Error e) {
            return "Invalid json";
        }
        Date newDate = obj.getNgayHieuLuc();
        double luongCoBan = obj.getLuongCoBan();
        double tiLeCN = obj.getTiLeCN();
        double tiLeCT = obj.getTiLeCT();
        double tiLeHS = obj.getTiLeHS();
        double tiLePhaiDongHS = obj.getTiLePhaiDongHS();
        ArrayList<Float> tiLeTV = new ArrayList<>();
        tiLeTV.add(obj.getTiLeTV1());
        tiLeTV.add(obj.getTiLeTV2());
        tiLeTV.add(obj.getTiLeTV3());
        tiLeTV.add(obj.getTiLeTV4());
        tiLeTV.add(obj.getTiLeTV5());
        // update the upper levels (infrastructure, district, province)
        // reset everything to 0 -> add up later
        List<Quan> lstQuan = (quanService.findAllQuan());
        for (Quan q : lstQuan) {
           if (q.getTuNgay().compareTo(newDate) >= 0) {
                q.setMucDong(0.0);
                q.setSoLuong(0);
                List<String> lstPhuong = JSONToList(q.getListPhuong());
                for (String str : lstPhuong) {
                    List<Phuong> lP = phuongService.findPhuongByIdBHYT(str);
                    Phuong p = lP.get(lP.size() - 1);
                   if (p.getTuNgay().compareTo(newDate) >= 0) {
                        p.setMucDong(0.0);
                        p.setSoLuong(0);
                        List<String> lstCongTy = JSONToList(p.getListCongTy());
                        for (String cty : lstCongTy) {
                            CongTy ct = congTyService.findLastByIdBHYT(cty);
                            if (ct.getTuNgay().compareTo(newDate) >= 0) {
                                ct.setMucDong(0.0);
                                ct.setSoLuong(0);
                            }
                        }
                        List<String> lstTruongHoc = JSONToList(p.getListTruongHoc());
                        for (String trg : lstTruongHoc) {
                            TruongHoc th = truongHocService.findLastByIdBHYT(trg);
                            if (th.getTuNgay().compareTo(newDate) >= 0) {
                                th.setMucDong(0.0);
                                th.setSoLuong(0);
                            }
                        }
                        List<String> lstHoGiaDinh = JSONToList(p.getListHoGiaDinh());
                        for (String hgd : lstHoGiaDinh) {
                            HoGiaDinh gd = hoGiaDinhService.findLastByIdBHYT(hgd);
                            if (gd.getTuNgay().compareTo(newDate) >= 0) {
                                gd.setMucDong(0.0);
                                gd.setSoLuong(0);
                            }
                        }
                   }
                }
           }
        }
        // update the price for records of individuals that has starting date >= ngayHieuLuc
        List<CaNhan> lstCaNhan = caNhanService.findAllCaNhan();
        for (CaNhan x : lstCaNhan) {
            String idMucTren = x.getIdMucTren();
            String id = x.getIdBHYT();
            System.out.println(String.format("%s %s %s %s", id, idMucTren, id.substring(0, 2), id.substring(0, 1)));
            if (x.getTuNgay().compareTo(newDate) >= 0) {
                // if yes, recalculate
                double newCost = luongCoBan;
                switch (idMucTren.substring(0, 2)) {
                    case "CT" -> { // Cong Ty
                        double luong = x.getLuong();
                        newCost = luong / 100 * tiLeCN; // divide first because else it'll be bad xddd (small double division -> bad accuracy)
                        newCost = round(newCost);
                        System.out.println(String.format("%f %f %f", luong, tiLeCN, newCost));
                        CongTy ct = congTyService.findLastByIdBHYT(idMucTren);
                        double newCostCty = newCost / tiLeCN * (tiLeCN + tiLeCT);
                        newCostCty = round(newCostCty);
                        ct.setMucDong(ct.getMucDong() + newCostCty);
                        ct.setSoLuong(ct.getSoLuong()+1);
                        Phuong p = phuongService.findLastByIdBHYT(ct.getIdBHYTPhuong());
                        p.setMucDong(p.getMucDong() + newCostCty);
                        p.setSoLuong(p.getSoLuong()+1);
                        Quan q = quanService.findLastByIdBHYT(p.getIdBHYTQuan());
                        q.setMucDong(q.getMucDong() + newCostCty);
                        q.setSoLuong(q.getSoLuong()+1);
                    }
                    case "GD" -> { // Ho Gia Dinh
                        List<HoGiaDinh> lstHoGiaDinh = hoGiaDinhService.findByIdBHYT(idMucTren);
                        System.out.println("lstHoGiaDinh size " + lstHoGiaDinh.size());
                        HoGiaDinh gd = lstHoGiaDinh.get(lstHoGiaDinh.size() - 1);
                        List<String> lstThanhVien = JSONToList(gd.getListCaNhan());
                        int i = 0;
                        while (i < lstThanhVien.size() - 1 && lstThanhVien.get(i).compareTo(id) != 0) {
                            i++;
                        }
                        System.out.println("i " + i);
                        if (i > 5) {
                            i = 5;
                        }
                        System.out.println(i);
                        float rate = tiLeTV.get(0);
                        if (i > 0) {
                            rate = rate * tiLeTV.get(i);
                            newCost /= 100; // divide this instead of rate, avoid small number inaccuracy
                        }
                        newCost = newCost / 100 * rate;
                        newCost = round(newCost);
                        System.out.println(String.format("%f %d %f", luongCoBan, i + 1, newCost));
                        // get hogiadinh . last -> + newcost
                        HoGiaDinh hgd = hoGiaDinhService.findLastByIdBHYT(idMucTren);
                        System.out.println("oldcost hgd " + hgd.getMucDong() + " " + newCost + " " + (hgd.getMucDong() + newCost));
                        hgd.setMucDong(hgd.getMucDong() + newCost);
                        hgd.setSoLuong(hgd.getSoLuong()+1);
                        System.out.println("newcost hgd " + hgd.getMucDong());
                        Phuong p = phuongService.findLastByIdBHYT(hgd.getIdBHYTPhuong());
                        p.setMucDong(p.getMucDong() + newCost);
                        p.setSoLuong(p.getSoLuong()+1);
                        Quan q = quanService.findLastByIdBHYT(p.getIdBHYTQuan());
                        q.setMucDong(q.getMucDong() + newCost);
                        q.setSoLuong(q.getSoLuong()+1);
                    }
                    default -> {
                        if (idMucTren.substring(0, 1).equals("T")) { // Truong Hoc
                            newCost = newCost / 100 / 100 * 12 * tiLeHS * tiLePhaiDongHS;
                            newCost = round(newCost);
                            System.out.println("newCost hsinh " + newCost);
                            TruongHoc th = truongHocService.findLastByIdBHYT(idMucTren);
                            th.setMucDong(th.getMucDong() + newCost);
                            th.setSoLuong(th.getSoLuong()+1);
                            Phuong p = phuongService.findLastByIdBHYT(th.getIdBHYTPhuong());
                            p.setMucDong(p.getMucDong() + newCost);
                            p.setSoLuong(p.getSoLuong()+1);
                            Quan q = quanService.findLastByIdBHYT(p.getIdBHYTQuan());
                            q.setMucDong(q.getMucDong() + newCost);
                            q.setSoLuong(q.getSoLuong()+1);
                        } else {
                            return ("Invalid institution code " + x.getIdBHYT());
                        }
                    }
                }
                if (newCost != 0) {
                    newCost = Math.round(newCost);
                    x.setMucDong(newCost);
                    if (x.getDaDong() > newCost) {
                        x.setDaDong(newCost);
                    }
                    x.setConNo(newCost - x.getDaDong());
                    CaNhan test = caNhanService.addCaNhan(x);
                }
            }
        }

        // update infrastructure based on upper level ID from individuals and starting date
        // update district based on district ID from infrastructures
        for (Quan q : lstQuan) {
            if (q.getTuNgay().compareTo(newDate) >= 0) {
                if (q.getDaDong() > q.getMucDong()) {
                    q.setDaDong(q.getMucDong());
                }
                q.setConNo(q.getMucDong() - q.getDaDong());
                quanService.addQuan(q);
                List<String> lstPhuong = JSONToList(q.getListPhuong());
                for (String str : lstPhuong) {
                    List<Phuong> lP = phuongService.findPhuongByIdBHYT(str);
                    Phuong p = lP.get(lP.size() - 1);
                    if (p.getTuNgay().compareTo(newDate) >= 0) {
                        if (p.getDaDong() > p.getMucDong()) {
                            p.setDaDong(p.getMucDong());
                        }
                        p.setConNo(p.getMucDong() - p.getDaDong());
                        phuongService.addPhuong(p);
                        List<String> lstCongTy = JSONToList(p.getListCongTy());
                        for (String cty : lstCongTy) {
                            CongTy ct = congTyService.findLastByIdBHYT(cty);
                            if (ct.getTuNgay().compareTo(newDate) >= 0) {
                                if (ct.getDaDong() > ct.getMucDong()) {
                                    ct.setDaDong(ct.getMucDong());
                                }
                                ct.setConNo(ct.getMucDong() - ct.getDaDong());
                                congTyService.addCongTy(ct);
                            }
                        }
                        List<String> lstTruongHoc = JSONToList(p.getListTruongHoc());
                        for (String trg : lstTruongHoc) {
                            TruongHoc th = truongHocService.findLastByIdBHYT(trg);
                            if (th.getTuNgay().compareTo(newDate) >= 0) {
                                if (th.getDaDong() > th.getMucDong()) {
                                    th.setDaDong(th.getMucDong());
                                }
                                th.setConNo(th.getMucDong() - th.getDaDong());
                                truongHocService.addTruongHoc(th);
                            }
                        }
                        List<String> lstHoGiaDinh = JSONToList(p.getListHoGiaDinh());
                        for (String hgd : lstHoGiaDinh) {
                            HoGiaDinh gd = hoGiaDinhService.findLastByIdBHYT(hgd);
                            if (gd.getTuNgay().compareTo(newDate) >= 0) {
                                if (gd.getDaDong() > gd.getMucDong()) {
                                    gd.setDaDong(gd.getMucDong());
                                }
                                gd.setConNo(gd.getMucDong() - gd.getDaDong());
                                hoGiaDinhService.addHoGiaDinh(gd);
                            }
                        }
                    }
                }
            }
        }
        return "okayge";
    }

    private double round(double n){
        return Math.round(n);
    }

    private static <T> List<T> JSONToList(String json) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        List<T> lst = mapper.readValue(json, new TypeReference<List<T>>() {
        });
        return lst;
    }

    private static <T> String ListToJSON(T input) throws JsonProcessingException {
        ObjectWriter ow = new ObjectMapper().setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY).writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(input);
        return json;
    }
}

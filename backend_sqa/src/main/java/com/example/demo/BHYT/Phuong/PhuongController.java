/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.BHYT.Phuong;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.BHYT.CaNhan.CaNhanService;
import com.example.demo.BHYT.CongTy.CongTyService;
import com.example.demo.BHYT.HoGiaDinh.HoGiaDinhService;
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
public class PhuongController {

    @Autowired
    private PhuongService service;
    @Autowired
    private CongTyService congTyService;
    @Autowired
    private HoGiaDinhService hoGiaDinhService;
    @Autowired
    private TruongHocService truongHocService;
    @Autowired
    private CaNhanService caNhanService;

    @ResponseBody
    @GetMapping("/getallphuong")
    public List<Phuong> getAllPhuong() {
        return service.findAllPhuong();
    }

    @ResponseBody
    @PostMapping("/addphuong")
    public String addPhuong(@RequestBody Phuong p) {
        service.addPhuong(p);
        return "success";
    }

    @ResponseBody
    @PostMapping("/getphuong")
    public Phuong getPhuong(@RequestBody String idPhuong) {
        System.out.println("Running getPhuong " + idPhuong);
        if(idPhuong == null) return null;
        return service.findPhuongByIdBHYT(idPhuong).get(0);
    }
//    @ResponseBody
//    @PostMapping("/getphuongtrongquan")
//    public List<Phuong> getPhuongTrongQuan(@RequestBody String idPhuong) {
//        System.out.println("Running getPhuongTrongQuan " + idPhuong);
//        if(idPhuong == null) return null;
//        return service.findPhuongByIdBHYT(idPhuong);
//    }
    @ResponseBody
    @PostMapping("/getcanhantrongphuong")
    public String getCaNhanTrongPhuong(@RequestBody String idPhuong) throws JsonProcessingException {
        System.out.println("Running getCaNhanTrongPhuong " + idPhuong);

        if(idPhuong == null) return "null input";
        return service.findCaNhanTrongPhuong(idPhuong);
    }

//    @ResponseBody
//    @GetMapping("/gettochuctrongphuong")
//    public String getAllToChucTrongPhuong(@RequestBody String idPhuong) throws JsonProcessingException {
//        String res = "";
//        List<CongTy> lstCongTy = congTyService.findAllCongTyTrongPhuong(idPhuong);
//        res += ListToJSON(lstCongTy);
//        List<TruongHoc> lstTruongHoc = truongHocService.findAllTruongHocTrongPhuong(idPhuong);
//        res += ListToJSON(lstTruongHoc);
//        List<HoGiaDinh> lstHoGiaDinh = hoGiaDinhService.findAllHoGiaDinhTrongPhuong(idPhuong);
//        res += ListToJSON(lstHoGiaDinh);
//        return res;
//    }
    private static <T> ArrayList<T> JSONToList(String json) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        ArrayList<T> lst = mapper.readValue(json, new TypeReference<ArrayList<T>>() {
        });
        return lst;
    }

    private static <T> String ListToJSON(ArrayList<T> input) throws JsonProcessingException {
        ObjectWriter ow = new ObjectMapper().setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY).writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(input);
        return json;
    }

}
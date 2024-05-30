/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.BHYT.HoGiaDinh;

import java.util.ArrayList;
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
import com.example.demo.BHYT.Quan.QuanController;
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
public class HoGiaDinhController {
    @Autowired
    private HoGiaDinhService service;
    @Autowired
    private QuanController quanController;
    @Autowired
    private CaNhanService caNhanService;

    @ResponseBody
    @GetMapping("/getallhogiadinh")
    public List<HoGiaDinh> getAllHoGiaDinh(){
        return service.findAllHoGiaDinh();
    }
    @ResponseBody
    @PostMapping("/getcanhantronghogiadinh")
    public String getCaNhanTrongHoGiaDinh(@RequestBody String id) throws JsonProcessingException{
        System.out.println("Running getCaNhanTrongHoGiaDinh " + id);
        if(id == null) return null;
        id = id.replaceAll("\"", "");
//        System.out.println(id);
        HoGiaDinh th = service.findByIdBHYT(id).get(0);
        List<String> lstCaNhanStr = JSONToList(th.getListCaNhan());
        List<CaNhan> res = new ArrayList<>();
        for(String s: lstCaNhanStr){
            List<CaNhan> lst = caNhanService.findCaNhanByID(s);
            res.addAll(lst);
        }
        return ListToJSON(res);
    }
//    @ResponseBody
//    @GetMapping("/getallhogiadinhtrongquan")
//    public List<HoGiaDinh> getAllHoGiaDinhTrongQuan(String idQuan){
//        List<String> listPhuong = quanController.getPhuongTrongQuan(idQuan);
//        List<HoGiaDinh> lst = service.findAllHoGiaDinh();
//        for(int i = lst.size()-1; i >= 0; i--){
//            if(!listPhuong.contains(lst.get(i).getIdBHYTPhuong()))  lst.remove(i);
//        }
//        return lst;
//    }
//    @ResponseBody
//    @GetMapping("/getallhogiadinhtrongphuong")
//    public List<HoGiaDinh> getAllHoGiaDinhTrongPhuong(String idPhuong){
//        List<HoGiaDinh> lst = service.findAllHoGiaDinhByIdBHYTPhuong(idPhuong);
//        return lst;
//    }

    @ResponseBody
    @PostMapping("/addhogiadinh")
    public String addHoGiaDinh(@RequestBody HoGiaDinh c){
        service.addHoGiaDinh(c);
        return "success";
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

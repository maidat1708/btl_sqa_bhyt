/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.BHYT.TruongHoc;

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
import com.example.demo.BHYT.Quan.QuanService;
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
public class TruongHocController {
    @Autowired
    private TruongHocService service;
    @Autowired
    private QuanService quanService;
    @Autowired
    private CaNhanService caNhanService;

    @ResponseBody
    @GetMapping("/getalltruonghoc")
    public List<TruongHoc> getAllTruongHoc(){
        return service.findAllTruongHoc();
    }

    @ResponseBody
    @PostMapping("/addtruonghoc")
    public String addTruongHoc(@RequestBody TruongHoc c){
        service.addTruongHoc(c);
        return "success";
    }
    @ResponseBody
    @PostMapping("/getcanhantrongtruonghoc")
    public String getCaNhanTrongTruongHoc(@RequestBody String id) throws JsonProcessingException{
        System.out.println("Running getCaNhanTrongTruongHoc " + id);
        if(id == null) return null;
        id = id.replaceAll("\"", "");
//        System.out.println(id);
        TruongHoc th = service.findByIdBHYT(id).get(0);
        List<String> lstCaNhanStr = JSONToList(th.getListCaNhan());
        List<CaNhan> res = new ArrayList<>();
        for(String s: lstCaNhanStr){
            List<CaNhan> lst = caNhanService.findCaNhanByID(s);
            res.addAll(lst);
        }
        return ListToJSON(res);
    }

//    @ResponseBody
//    @GetMapping("/getalltruonghoctrongquan")
//    public List<TruongHoc> getAllTruongHocTrongQuan(String idQuan){
//        List<String> listPhuong = quanService.findPhuongTrongQuan(idQuan);
//        List<TruongHoc> lst = service.findAllTruongHoc();
//        for(int i = lst.size()-1; i >= 0; i--){
//            if(!listPhuong.contains(lst.get(i).getIdBHYTPhuong()))  lst.remove(i);
//        }
//        return lst;
//    }
//    @ResponseBody
//    @GetMapping("/getalltruonghoctrongphuong")
//    public List<TruongHoc> getAllTruongHocTrongPhuong(String idPhuong){
//        List<TruongHoc> lst = service.findAllTruongHocByIdBHYTPhuong(idPhuong);
//        return lst;
//    }
    private static <T> ArrayList<T> JSONToList(String json) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        ArrayList<T> lst = mapper.readValue(json, new TypeReference<ArrayList<T>>() {
        });
        return lst;
    }

    private static <T> String ListToJSON(List<T> input) throws JsonProcessingException {
        ObjectWriter ow = new ObjectMapper().setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY).writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(input);
        return json;
    }
}

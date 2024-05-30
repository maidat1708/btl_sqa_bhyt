/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.BHYT.Quan;

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
import com.example.demo.BHYT.Phuong.PhuongService;
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
public class QuanController {

    @Autowired
    private QuanService service;
    @Autowired
    private PhuongService phuongService;

    @ResponseBody
    @GetMapping("/getallquan")
    public List<Quan> getAllQuan() {
        return service.findAllQuan();
    }

    @ResponseBody
    @PostMapping("/addquan")
    public String addQuan(@RequestBody Quan q) {
        service.addQuan(q);
        return "success";
    }

    @ResponseBody
    @PostMapping("/getquan")
    public Quan getQuan(@RequestBody String id) {
        System.out.println("Running getQuan " + id);
        if(id == null) return null;
        return service.findQuanByIdBHYT(id).get(0);
    }

    @ResponseBody
    @PostMapping("/getcanhantrongquan")
    public String getCaNhanTrongQuan(@RequestBody String idQuan) throws JsonProcessingException {
        System.out.println("Running getCaNhanTrongQuan " + idQuan);
        if(idQuan == null) return "null input";
        idQuan = idQuan.replaceAll("\"", "");
        System.out.println(idQuan);
        Quan q = service.findQuanByIdBHYT(idQuan).get(0);
        if (q != null) {
            ArrayList<String> listPhuong = JSONToList(q.getListPhuong());
            ArrayList<CaNhan> res = new ArrayList<>();
            for (String s : listPhuong) {
                System.out.println(s);
                res.addAll(JSONToList(phuongService.findCaNhanTrongPhuong(s)));
            }
            return ListToJSON(res);
        }
        return "No result";
    }


    @ResponseBody
    @PostMapping("/getphuongtrongquan")
    public String getPhuongTrongQuan(@RequestBody String idQuan) throws JsonProcessingException {
        System.out.println("Running getPhuongTrongQuan " + idQuan);
        if(idQuan == null) return "null input";
        idQuan = idQuan.replaceAll("\"", "");
        System.out.println(idQuan);
//        ArrayList<Phuong> res = new ArrayList<>();
//        Quan q = service.findQuanByIdBHYT(idQuan).get(0);
//        ArrayList<String> listPhuong = JSONToList(q.getListPhuong());
//        for(String s: listPhuong){
//            res.add(phuongService.findPhuongByIdQuan(idQuan))
//        }
        return ListToJSON(phuongService.findPhuongByIdQuan(idQuan));
    }

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

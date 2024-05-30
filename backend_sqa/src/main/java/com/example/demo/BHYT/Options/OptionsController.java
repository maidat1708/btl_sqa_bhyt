/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.BHYT.Options;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

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
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 *
 * @author Admin
 */
@CrossOrigin
@Controller
public class OptionsController {

    @Autowired
    private PhuongService phuongService;
    @Autowired
    private QuanService quanService;
    @Autowired
    private CongTyService congTyService;
    @Autowired
    private HoGiaDinhService hoGiaDinhService;
    @Autowired
    private TruongHocService truongHocService;

    @ResponseBody
    @PostMapping("/query")
    public String query(@RequestBody String o) {
        if(o == null) return null;
        ObjectMapper mapper = new ObjectMapper();
        try {
            Options options = mapper.readValue(o, Options.class);
            System.out.println(options); // quan, phuong, truong, cty, hgd, ky han, nam, thang, quy
            if (options.getQuan() != null && !options.getQuan().equals("")) {
                if (options.getPhuong() != null && !options.getPhuong().equals("")) {
                    if (options.isCongTy() || options.isTruongHoc() || options.isHoGiaDinh()) {
                        // query every checked options in district
                        ObjectNode mergedNode = mapper.createObjectNode();
                        if (options.isCongTy()) {
                            List<CongTy> lst = congTyService.findAllCongTyTrongPhuong(options.getPhuong());
                            ArrayNode node = mapper.valueToTree(lst);
                            mergedNode.set("CongTy", node);
                        }
                        if (options.isTruongHoc()) {
                            List<TruongHoc> lst = truongHocService.findAllTruongHocTrongPhuong(options.getPhuong());
                            ArrayNode node = mapper.valueToTree(lst);
                            mergedNode.set("TruongHoc", node);
                        }
                        if (options.isHoGiaDinh()) {
                            List<HoGiaDinh> lst = hoGiaDinhService.findAllHoGiaDinhTrongPhuong(options.getPhuong());
                            ArrayNode node = mapper.valueToTree(lst);
                            mergedNode.set("HoGiaDinh", node);
                        }
                        return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(mergedNode);
                    } else {
                        // query every institution inside a district
                        String lstJson = phuongService.findAllToChucTrongPhuong(options.getPhuong());
//                        System.out.println(lstJson);
                        return lstJson;
                    }
                } else {
                    if (options.isCongTy() || options.isTruongHoc() || options.isHoGiaDinh()) {
                        System.out.println("Running here");

                        // query every checked options in province
                        ObjectNode mergedNode = mapper.createObjectNode();
                        if (options.isCongTy()) {
                            List<CongTy> lst = congTyService.findAllCongTyTrongQuan(options.getQuan());
                            ArrayNode node = mapper.valueToTree(lst);
                            mergedNode.set("CongTy", node);
                        }
                        if (options.isTruongHoc()) {
                            List<TruongHoc> lst = truongHocService.findAllTruongHocTrongQuan(options.getQuan());
                            ArrayNode node = mapper.valueToTree(lst);
                            mergedNode.set("TruongHoc", node);
                        }
                        if (options.isHoGiaDinh()) {
                            List<HoGiaDinh> lst = hoGiaDinhService.findAllHoGiaDinhTrongQuan(options.getQuan());
                            ArrayNode node = mapper.valueToTree(lst);
                            mergedNode.set("HoGiaDinh", node);
                        }
                        return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(mergedNode);
                    } else {
                        // query every district inside a province
                        List<Phuong> lst = phuongService.findPhuongByIdQuan(options.getQuan());
                        String json = ListToJSON(lst);
//                        System.out.println(json);
                        return json;
                    }
                }
            } else {
                if (options.isCongTy() || options.isTruongHoc() || options.isHoGiaDinh()) {
                    // query checked options insidle the whole city
                    ObjectNode mergedNode = mapper.createObjectNode();
                    if (options.isCongTy()) {
                        List<CongTy> lst = congTyService.findAllCongTy();
                        ArrayNode node = mapper.valueToTree(lst);
                        mergedNode.set("CongTy", node);
                    }
                    if (options.isTruongHoc()) {
                        List<TruongHoc> lst = truongHocService.findAllTruongHoc();
                        ArrayNode node = mapper.valueToTree(lst);
                        mergedNode.set("TruongHoc", node);
                    }
                    if (options.isHoGiaDinh()) {
                        List<HoGiaDinh> lst = hoGiaDinhService.findAllHoGiaDinh();
                        ArrayNode node = mapper.valueToTree(lst);
                        mergedNode.set("HoGiaDinh", node);
                    }
                    return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(mergedNode);
                } else {
                    // query every province
                    System.out.println("HEHREHREHRHEHRE");
                    List<Quan> lst = quanService.findAllQuan();
                    String json = ListToJSON(lst);
//                    System.out.println(json);
                    return json;
                }
            }
        } catch (JsonProcessingException ex) {
            Logger.getLogger(OptionsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "null hahahahaa";
    }

    @ResponseBody
    @PostMapping("/getcanhantrongtochuc")
    public String getCaNhanTrongToChuc(@RequestBody String s) throws JsonProcessingException{
        s = s.replaceAll("\"", "");
        if(s == null) return null;
        switch(s.substring(0, 2)){
            case "CT" -> {
                return congTyService.findAllCaNhanTrongCongTy(s);
            }
            case "GD" -> {
                return hoGiaDinhService.findAllCaNhanTrongHoGiaDinh(s);
            }
            default -> {
                if(s.substring(0,1).equals("T")){
                    return truongHocService.findAllCaNhanTrongTruongHoc(s);
                } else{
                    return "Invalid institution code.";
                }
            }
        }
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

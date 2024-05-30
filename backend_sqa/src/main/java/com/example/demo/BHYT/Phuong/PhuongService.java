/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.BHYT.Phuong;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.BHYT.CaNhan.CaNhan;
import com.example.demo.BHYT.CaNhan.CaNhanRepository;
import com.example.demo.BHYT.CongTy.CongTy;
import com.example.demo.BHYT.CongTy.CongTyRepository;
import com.example.demo.BHYT.HoGiaDinh.HoGiaDinh;
import com.example.demo.BHYT.HoGiaDinh.HoGiaDinhRepository;
import com.example.demo.BHYT.TruongHoc.TruongHoc;
import com.example.demo.BHYT.TruongHoc.TruongHocRepository;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 *
 * @author Admin
 */
@Service
public class PhuongService {

    @Autowired
    private PhuongRepository repo;
    @Autowired
    private CongTyRepository congTyRepo;
    @Autowired
    private TruongHocRepository truongHocRepo;
    @Autowired
    private HoGiaDinhRepository hoGiaDinhRepo;
    @Autowired
    private CaNhanRepository caNhanRepo;

    public List<Phuong> findAllPhuong() {
        System.out.println("running findAllPhuong");
        return repo.findAll();
    }

    public void addPhuong(Phuong p) {
        System.out.println("running addPhuong");
        repo.save(p);
    }

    public List<Phuong> findPhuongByIdBHYT(String id) {
        System.out.println("running findPhuongByIdBHYT " + id);
        if(id == null) return null;
        return repo.findByIdBHYT(id);
    }
    public Phuong findLastByIdBHYT(String id) {
        System.out.println("running findLastByIdBHYT " + id);
        if(id == null) return null;
        List<Phuong> lst = repo.findByIdBHYT(id);
        return lst.get(lst.size()-1);
    }
    public List<Phuong> findPhuongByIdQuan(String idQuan) {
        System.out.println("running findPhuongByIdQuan " + idQuan);
        if(idQuan == null) return null;
        return repo.findByIdBHYTQuan(idQuan);
    }

    public String findAllToChucTrongPhuong(String idPhuong) throws JsonProcessingException {
        System.out.println("running findAllToChucTrongPhuong " + idPhuong);
        if(idPhuong == null) return null;
        Phuong p = repo.findByIdBHYT(idPhuong).get(0);
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode mergedNode = mapper.createObjectNode();
        List<String> lstCongTyStr = JSONToList(p.getListCongTy());
        List<String> lstTruongHocStr = JSONToList(p.getListTruongHoc());
        List<String> lstHoGiaDinhStr = JSONToList(p.getListHoGiaDinh());

        List<CongTy> lstCongTy = new ArrayList<>();
        List<TruongHoc> lstTruongHoc = new ArrayList<>();
        List<HoGiaDinh> lstHoGiaDinh = new ArrayList<>();
        for (String s : lstCongTyStr) {
            lstCongTy.addAll(congTyRepo.findByIdBHYT(s));
        }
        mergedNode.set("CongTy", mapper.valueToTree(lstCongTy));
        for (String s : lstTruongHocStr) {
            lstTruongHoc.addAll(truongHocRepo.findByIdBHYT(s));
        }
        mergedNode.set("TruongHoc", mapper.valueToTree(lstTruongHoc));
        for (String s : lstHoGiaDinhStr) {
            lstHoGiaDinh.addAll(hoGiaDinhRepo.findByIdBHYT(s));
        }
        mergedNode.set("HoGiaDinh", mapper.valueToTree(lstHoGiaDinh));
        return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(mergedNode);
    }

    public String findCaNhanTrongPhuong(String idPhuong) throws JsonProcessingException {
        System.out.println("running findCaNhanTrongPhuong " + idPhuong);
        if(idPhuong == null) return null;
        idPhuong = idPhuong.replaceAll("\"", "");
        Phuong p = repo.findByIdBHYT(idPhuong).get(0);
        if (p != null) {
            List<String> lst = JSONToList(p.getListCaNhan());
            ArrayList<CaNhan> res = new ArrayList<>();
            for (String s : lst) {
                System.out.println(s);
                res.addAll(caNhanRepo.findByIdBHYT(s));
            }
            return ListToJSON(res);
        }
        return "No result";
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

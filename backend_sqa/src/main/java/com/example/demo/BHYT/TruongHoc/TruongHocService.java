/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.BHYT.TruongHoc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.BHYT.CaNhan.CaNhan;
import com.example.demo.BHYT.CaNhan.CaNhanRepository;
import com.example.demo.BHYT.Phuong.PhuongRepository;
import com.example.demo.BHYT.Quan.Quan;
import com.example.demo.BHYT.Quan.QuanRepository;
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
@Service
public class TruongHocService {

    @Autowired
    private TruongHocRepository repo;
    @Autowired
    private PhuongRepository phuongRepo;
    @Autowired
    private QuanRepository quanRepo;
    @Autowired
    private CaNhanRepository caNhanRepo;

    public List<TruongHoc> findAllTruongHoc() {
        System.out.println("running findAllTruongHoc");
        return repo.findAll();
    }

    public void addTruongHoc(TruongHoc p) {
        System.out.println("running addTruongHoc");
        repo.save(p);
    }

    public List<TruongHoc> findByIdBHYT(String id) {
        System.out.println("running findByIdBHYT " + id);
        if(id == null) return null;
        return repo.findByIdBHYT(id);
    }

    public TruongHoc findLastByIdBHYT(String id) {
        System.out.println("running findLastByIdBHYT " + id);
        if(id == null) return null;
        List<TruongHoc> lst = repo.findByIdBHYT(id);
        return lst.get(lst.size()-1);
    }

    public List<TruongHoc> findAllTruongHocTrongPhuong(String idPhuong) {
        System.out.println("running findAllTruongHocTrongPhuong " + idPhuong);
        return repo.findByIdBHYTPhuong(idPhuong);
    }

    public List<TruongHoc> findAllTruongHocTrongQuan(String idQuan) {
        System.out.println("running findAllTruongHocTrongQuan " + idQuan);
        if(idQuan == null) return null;
        Quan q = quanRepo.findByIdBHYT(idQuan).get(0);
        List<TruongHoc> lst = repo.findAll();
        for (int i = lst.size() - 1; i >= 0; i--) {
            if (!q.getListPhuong().contains(lst.get(i).getIdBHYTPhuong())) {
                lst.remove(i);
            }
        }
        return lst;
    }
    public String findAllCaNhanTrongTruongHoc(String id) throws JsonProcessingException{
        System.out.println("running findAllCaNhanTrongTruongHoc " + id);
        if(id == null) return null;
        TruongHoc ct = repo.findByIdBHYT(id).get(0);
        List<String> lst = JSONToList(ct.getListCaNhan());
        List<CaNhan> res = new ArrayList();
        for(String s: lst){
            List<CaNhan> lstCaNhan = caNhanRepo.findByIdBHYT(s);
            res.addAll(lstCaNhan);
        }
        return ListToJSON(res);
    }
    private static <T> ArrayList<T> JSONToList(String json) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        ArrayList<T> lst = mapper.readValue(json, new TypeReference<ArrayList<T>>() {
        });
        return lst;
    }

    private static <T> String ListToJSON(T input) throws JsonProcessingException {
        ObjectWriter ow = new ObjectMapper().setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY).writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(input);
        return json;
    }
}

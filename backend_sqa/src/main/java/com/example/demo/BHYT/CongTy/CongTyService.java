/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.BHYT.CongTy;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.BHYT.CaNhan.CaNhan;
import com.example.demo.BHYT.CaNhan.CaNhanRepository;
import com.example.demo.BHYT.Phuong.Phuong;
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
public class CongTyService {
    @Autowired
    private CongTyRepository repo;
    @Autowired
    private PhuongRepository phuongRepo;
    @Autowired
    private QuanRepository quanRepo;
    @Autowired
    private CaNhanRepository caNhanRepo;

    public List<CongTy> findAllCongTy(){
        System.out.println("running findAllCongTy");
        return repo.findAll();
    }
    public void addCongTy(CongTy p){
        System.out.println("running addCongTy");
        repo.save(p);
    }
    public List<CongTy> findByIdBHYT(String id){
        System.out.println("running findByIdBHYT " + id);
        if(id == null) return null;
        return repo.findByIdBHYT(id);
    }
    public CongTy findLastByIdBHYT(String id) {
        System.out.println("running findLastByIdBHYT " + id);
        if(id == null) return null;
        List<CongTy> lst = repo.findByIdBHYT(id);
        return lst.get(lst.size()-1);
    }
    public List<CongTy> findAllCongTyTrongPhuong(String idPhuong) {
        System.out.println("running findAllCongTyTrongPhuong " + idPhuong);
        if(idPhuong == null) return null;
        return repo.findByIdBHYTPhuong(idPhuong);
    }
    public ArrayList<CongTy> findAllCongTyTrongQuan(String idQuan) throws JsonProcessingException{
        System.out.println("running findAllCongTyTrongQuan " + idQuan);
        if(idQuan == null) return null;
        Quan q = quanRepo.findByIdBHYT(idQuan).get(0);
        String listPhuong = q.getListPhuong();
        System.out.println(listPhuong);
        List<String> lst = JSONToList(listPhuong);
        ArrayList<CongTy> res = new ArrayList<>();
        for(String s: lst){
            System.out.println(s);
            Phuong p = phuongRepo.findByIdBHYT(s).get(0);
            List<String> listIDCongTy = JSONToList(p.getListCongTy());
            for(String s2: listIDCongTy){
                res.addAll(repo.findByIdBHYT(s2));
            }
        }
        return res;
    }
    public String findAllCaNhanTrongCongTy(String id) throws JsonProcessingException{
        System.out.println("running findAllCaNhanTrongCongTy " + id);
        if(id == null) return null;
        CongTy ct = repo.findByIdBHYT(id).get(0);
        List<String> lst = JSONToList(ct.getListCaNhan());
        List<CaNhan> res = new ArrayList();
        for(String s: lst){
//            System.out.println(s);
            List<CaNhan> lstCaNhan = caNhanRepo.findByIdBHYT(s);
//            System.out.println(lstCaNhan.size());
            res.addAll(lstCaNhan);
        }
        return ListToJSON(res);
    }
    private static <T> List<T> JSONToList(String json) throws JsonProcessingException {
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

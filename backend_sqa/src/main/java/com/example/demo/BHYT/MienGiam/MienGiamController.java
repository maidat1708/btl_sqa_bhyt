/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.BHYT.MienGiam;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Admin
 */
@CrossOrigin
@Controller
public class MienGiamController {
    @Autowired
    private MienGiamService service;

    @ResponseBody
    @GetMapping("/getallmiengiam")
    public List<MienGiam> getAllMienGiam(){
        return service.findAllMienGiam();
    }

    @ResponseBody
    @PostMapping("/addmiengiam")
    public String addMienGiam(@RequestBody MienGiam c){
        service.addMienGiam(c);
        return "success";
    }
}

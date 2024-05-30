/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.BHYT.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

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
public class TestController {

    @Autowired
    private TestService service;

    @ResponseBody
    @GetMapping("/addtest")
    public void add(@RequestBody int i) {
        try {
            ArrayList<TestObj> lst = new ArrayList<>();
            lst.add(new TestObj(1));
            lst.add(new TestObj(2));
            lst.add(new TestObj(3));
            ObjectWriter ow = new ObjectMapper().setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY).writer().withDefaultPrettyPrinter();
            String json = ow.writeValueAsString(lst);
            System.out.println(json);
            service.add(new Test(1, json));
        } catch (JsonProcessingException ex) {
            Logger.getLogger(TestController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @ResponseBody
    @GetMapping("/gettest")
    public void get(@RequestBody int i) {
        try {
            Test obj = service.findByID(i);
            String ObjectJson = obj.getList();
            ObjectMapper mapper = new ObjectMapper();
            List<TestObj> lst = mapper.readValue(ObjectJson, new TypeReference<List<TestObj>>() {});
            System.out.println(lst.getClass());
            System.out.println(lst.get(0).getId());
            System.out.println(lst.get(2).getId());
            System.out.println(lst.get(1).getId());

        } catch (JsonProcessingException ex) {
            Logger.getLogger(TestController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

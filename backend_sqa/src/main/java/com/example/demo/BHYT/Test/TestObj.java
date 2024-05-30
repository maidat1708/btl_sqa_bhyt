/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.BHYT.Test;

import java.io.Serializable;

/**
 *
 * @author Admin
 */
public class TestObj implements Serializable{
    private int id;
    static public final long serialVersionUID = 123352432;

    public TestObj() {
    }

    public TestObj(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}

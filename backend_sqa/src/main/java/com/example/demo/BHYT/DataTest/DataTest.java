package com.example.demo.BHYT.DataTest;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.BHYT.CaNhan.CaNhan;
import com.example.demo.BHYT.CongTy.CongTy;
import com.example.demo.BHYT.HoGiaDinh.HoGiaDinh;
import com.example.demo.BHYT.Phuong.Phuong;
import com.example.demo.BHYT.Quan.Quan;
import com.example.demo.BHYT.TruongHoc.TruongHoc;

public class DataTest {
    public static List<Quan> listQuan = new ArrayList<>();
    public static List<Phuong> listPhuong = new ArrayList<>();
    public static List<TruongHoc> listTruongHoc = new ArrayList<>();
    public static List<CongTy> listCongTy = new ArrayList<>();
    public static List<HoGiaDinh> listHoGiaDinh = new ArrayList<>();
    public static List<CaNhan> listCaNhan = new ArrayList<>();

    public DataTest(){
        listQuan.add(new Quan(1, "Q001", "Quận Hai Bà Trưng", 62432000000.0, 36216000000.0, 26216000000.0, 480, Date.valueOf("2024-01-01"), Date.valueOf("2025-01-01"), "[\"P065\", \"P066\", \"P067\", \"P068\", \"P069\", \"P070\", \"P071\", \"P072\"]"));
        listPhuong.add(new Phuong(1,"P065", "Phường Cửa Đông", 7804000000.0, 4527000000.0, 3277000000.0, 60, Date.valueOf("2024-01-01"), Date.valueOf("2025-01-01"), "Q001", "[\"T257\", \"T258\", \"T259\", \"T260\"]","[\"CT257\", \"CT258\", \"CT259\", \"CT260\"]", "[\"GD257\", \"GD258\", \"GD259\", \"GD260\"]", "[\"CN3841\", \"CN3842\", \"CN3843\", \"CN3844\", \"CN3845\", \"CN3846\", \"CN3847\", \"CN3848\", \"CN3849\", \"CN3850\", \"CN3851\", \"CN3852\", \"CN3853\", \"CN3854\", \"CN3855\", \"CN3856\", \"CN3857\", \"CN3858\", \"CN3859\", \"CN3860\", \"CN3861\", \"CN3862\", \"CN3863\", \"CN3864\", \"CN3865\", \"CN3866\", \"CN3867\", \"CN3868\", \"CN3869\", \"CN3870\", \"CN3871\", \"CN3872\", \"CN3873\", \"CN3874\", \"CN3875\", \"CN3876\", \"CN3877\", \"CN3878\", \"CN3879\", \"CN3880\", \"CN3881\", \"CN3882\", \"CN3883\", \"CN3884\", \"CN3885\", \"CN3886\", \"CN3887\", \"CN3888\", \"CN3889\", \"CN3890\", \"CN3891\", \"CN3892\", \"CN3893\", \"CN3894\", \"CN3895\", \"CN3896\", \"CN3897\", \"CN3898\", \"CN3899\", \"CN3900\"]"));
        listTruongHoc.add(new TruongHoc(1, "T257", "Trường Tiểu Học Phường Cửa Đông - Quận Hai Bà Trưng", "Phường Cửa Đông - Quận Hai Bà Trưng", 5000000.0, 0.0, 5000000.0, 5,  Date.valueOf("2024-01-01"), Date.valueOf("2025-01-01"), 2, "P065", "[\"CN3851\", \"CN3852\", \"CN3853\", \"CN3854\", \"CN3855\"]"));
        listCongTy.add(new CongTy(1, "CT257", "Công ty TNHH Đinh Nam Thanh Dương", "Phường Cửa Đông - Quận Hai Bà Trưng", 10000000.0, 10000000.0, 0.0, 5,Date.valueOf("2024-01-01"), Date.valueOf("2024-02-01"), 0, "P065", "[\"CN3841\", \"CN3842\", \"CN3843\", \"CN3844\", \"CN3845\"]"));
        listHoGiaDinh.add(new HoGiaDinh(1, "GD257", "GD - Trần Hữu Thịnh", "Phường Cửa Đông - Quận Hai Bà Trưng", 10000000.0, 10000000.0, 0.0, 5,Date.valueOf("2024-01-01"), Date.valueOf("2024-02-01"), 0, "P065", "[\"CN3846\", \"CN3847\", \"CN3848\", \"CN3849\", \"CN3850\"]"));
    }
    public String testListQuan(){
        return "quanneee";
    }
}

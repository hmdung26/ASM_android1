package com.example.asm_android1.Model;

import java.io.Serializable;

public class NhanVienModel implements Serializable {
private String HoTen;
private String PhongBan;
    private String ChucVu;
    private String NgaySinh;
    private String DiaChi;
    private String SoDienThoai;
    private String Email;
    private String TinhTrangHonNhan;

    public NhanVienModel(String hoTen, String phongBan, String chucVu, String ngaySinh, String diaChi, String soDienThoai, String email, String tinhTrangHonNhan) {
        HoTen = hoTen;
        PhongBan = phongBan;
        ChucVu = chucVu;
        NgaySinh = ngaySinh;
        DiaChi = diaChi;
        SoDienThoai = soDienThoai;
        Email = email;
        TinhTrangHonNhan = tinhTrangHonNhan;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String hoTen) {
        HoTen = hoTen;
    }

    public String getPhongBan() {
        return PhongBan;
    }

    public void setPhongBan(String phongBan) {
        PhongBan = phongBan;
    }

    public String getChucVu() {
        return ChucVu;
    }

    public void setChucVu(String chucVu) {
        ChucVu = chucVu;
    }

    public String getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        NgaySinh = ngaySinh;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String diaChi) {
        DiaChi = diaChi;
    }

    public String getSoDienThoai() {
        return SoDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        SoDienThoai = soDienThoai;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getTinhTrangHonNhan() {
        return TinhTrangHonNhan;
    }

    public void setTinhTrangHonNhan(String tinhTrangHonNhan) {
        TinhTrangHonNhan = tinhTrangHonNhan;
    }
}

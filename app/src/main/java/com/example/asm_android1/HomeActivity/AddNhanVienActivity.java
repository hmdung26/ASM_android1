package com.example.asm_android1.HomeActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.asm_android1.Model.NhanVienModel;
import com.example.asm_android1.R;

public class AddNhanVienActivity extends AppCompatActivity {

    private EditText edtNameNV,edtDiaChiNV,editPhongBan,edtNgaySinh,edtSDT,edtEmail,edtTinhTrangHN,edtChucVu;
    private Button btnSUMMIT;
    private Toolbar toolbar_add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_nhan_vien);

        editPhongBan = findViewById(R.id.PhongBanNV);
        edtEmail = findViewById(R.id.EmailNV);
        edtNameNV = findViewById(R.id.HoTenNV);
        edtNgaySinh = findViewById(R.id.NgaySinhNV);
        edtSDT = findViewById(R.id.SDTNV);
        edtTinhTrangHN = findViewById(R.id.TinhTrangHonNhanNV);
        edtChucVu = findViewById(R.id.ChucVuNV);
        btnSUMMIT = findViewById(R.id.btnAddNV);
        edtDiaChiNV = findViewById(R.id.DiaChiNV);

        btnSUMMIT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            String HoTen = edtNameNV.getText().toString();
            String PhongBan = editPhongBan.getText().toString();
            String Email = edtEmail.getText().toString();
            String NgaySinh = edtNgaySinh.getText().toString();
            String SDT = edtSDT.getText().toString();
            String HonNhan = edtTinhTrangHN.getText().toString();
            String ChucVu = edtChucVu.getText().toString();
            String DiaChi = edtDiaChiNV.getText().toString();

                NhanVienModel modelNV = new NhanVienModel(HoTen,PhongBan,ChucVu,NgaySinh,DiaChi,SDT,Email,HonNhan);
                Intent i = new Intent();
                i.putExtra("newNV", modelNV);
setResult(1,i);
finish();
            }
        });
    }
}